 package com.base.platform.framework.web.utils;
 
 import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.log4j.Logger;
import org.nuxeo.common.xmap.XMap;
import org.springframework.util.Assert;
/**
 * <p/> Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2013.10.11
 */
 public final class XMLUtils
 {
   private static final Logger logger = Logger.getLogger(XMLUtils.class);
 
   private static final Map<Class<?>, XMap> xmap = GenericUtils.newHashMap();
   private static final Map<Class<?>, Digester> digesterMap = GenericUtils.newHashMap();
 
   public static <T> String beanToXml(T bean)
   {
     try
     {
       Assert.notNull(bean, "JavaBean对象不能为空");
       return getXmap(bean.getClass()).toXML(bean);
     } catch (Exception e) {
       logger.error("bean映射成xml异常", e);
     }
     return null;
   }
 
   public static <T> T xmlToBean(String xmlStr, Class<T> clazz)
   {
     try
     {
       assertParameter(xmlStr, clazz);
       return (T) getXmap(clazz).load(
         new ByteArrayInputStream(xmlStr.getBytes()));
     } catch (Exception e) {
       logger.error("xml映射成bean异常", e);
     }
     return null;
   }
 
   public static <T> T xmlToBeanByRules(String xmlStr, Class<T> clazz)
   {
     try
     {
       assertParameter(xmlStr, clazz);
       return (T) getDigester(clazz).parse(new StringReader(xmlStr));
     } catch (Exception e) {
      logger.error("xml映射成bean异常", e);
     }
     return null;
   }
 
   private static XMap getXmap(Class<?> clazz) {
     XMap map = (XMap)xmap.get(clazz);
     if (map == null) {
       map = new XMap();
       map.register(clazz);
       xmap.put(clazz, map);
     }
     return map;
   }
 
   private static Digester getDigester(Class<?> clazz) {
     Digester digester = (Digester)digesterMap.get(clazz);
     if (digester == null) {
       digester = DigesterLoader.createDigester(
         ClassLoader.getSystemResource(clazz.getSimpleName().toLowerCase() + 
         "-rules.xml"));
       digester.setValidating(false);
       digesterMap.put(clazz, digester);
     }
     return digester;
   }
 
   private static void assertParameter(String xmlStr, Class<?> clazz) {
     Assert.hasLength(xmlStr, "被解析的xml文件长度不能为0");
     Assert.notNull(clazz, "class对象不能为空");
   }
 }
