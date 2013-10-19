package com.base.platform.framework.utils;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.log4j.Logger;
import org.nuxeo.common.xmap.XMap;

/**
 * 处理 xml和bean之间的转换的工具类
 * 
 * 1.基于nuxeo common的注解解析
 * 
 * 2.基于digester的规则文件解析
 * 
 * 
 */
public final class XMLUtils {
	private static final Logger logger = Logger.getLogger(XMLUtils.class);

	private static final Map<Class<?>, XMap> xmap;

	private static final Map<Class<?>, Digester> digesterMap;

	private XMLUtils() {
	}

	static {
		xmap = new HashMap<Class<?>, XMap>();
		digesterMap = new HashMap<Class<?>, Digester>();
	}

	/**
	 * 从bean映射成xml文件
	 * 
	 * @param <T>
	 * @param bean
	 *            JavaBean对象
	 * @return
	 */
	public static <T> String beanToXml(T bean) {
		try {
			return getXmap(bean.getClass()).toXML(bean);
		} catch (Exception e) {
			logger.error("bean映射成xml异常", e);
		}
		return null;
	}

	/**
	 * 从xml映射成bean
	 * 
	 * @param <T>
	 * @param xmlStr
	 *            xml字符串
	 * @param clazz
	 *            JavaBean类型
	 * @return JavaBean对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(String xmlStr, Class<T> clazz) {
		try {
			return (T) getXmap(clazz).load(
					new ByteArrayInputStream(xmlStr.getBytes()));
		} catch (Exception e) {
			logger.error("xml映射成bean异常", e);
		}
		return null;
	}

	/**
	 * 
	 * 
	 * @param <T>
	 * @param xmlStr
	 *            xml字符串
	 * @param clazz
	 *            JavaBean对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlToBeanByRules(String xmlStr, Class<T> clazz) {
		try {
			return (T) getDigester(clazz).parse(new StringReader(xmlStr));
		} catch (Exception e) {
			logger.error("xml映射成bean异常", e);
		}
		return null;
	}

	public static XMap getXmap(Class<?> clazz) {
		XMap map = xmap.get(clazz);
		if (map == null) {
			map = new XMap();
			map.register(clazz);
			xmap.put(clazz, map);
		}
		return map;
	}

	public static Digester getDigester(Class<?> clazz) {
		Digester digester = digesterMap.get(clazz);
		if (digester == null) {
			digester = DigesterLoader.createDigester(ClassLoader
					.getSystemResource(clazz.getSimpleName().toLowerCase()
							+ "-rules.xml"));
			digester.setValidating(false);
			digesterMap.put(clazz, digester);
		}
		return digester;
	}

}
