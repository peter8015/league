package com.base.platform.framework.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 序列化对象为JSON格式 遵循JSON组织公布标准
 */
public class JsonUtil {
    /** Commons Logging instance. */
    private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(JsonUtil.class);
    
    
    /**
     * @param array
     *            对象数组
     * @return String
     */
    public static String array2json(Object[] array) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                json.append(JsonUtil.object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1 , ']');
        }
        else {
            json.append("]");
        }
        return json.toString();
    }
    

    /**
     * @param bean
     *            bean对象
     * @return String
     */
    public static String bean2json(Object bean) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        PropertyDescriptor[] props = null;
        try {
            props = Introspector.getBeanInfo(bean.getClass() , Object.class).getPropertyDescriptors();
        }
        catch (IntrospectionException e) {
        }
        if (props != null) {
            for (int i = 0; i < props.length; i++) {
                try {
                    String name = JsonUtil.object2json(props[i].getName());
                    String value = JsonUtil.object2json(props[i].getReadMethod().invoke(bean));
                    json.append(name);
                    json.append(":");
                    json.append(value);
                    json.append(",");
                }
                catch (Exception e) {
                }
            }
            json.setCharAt(json.length() - 1 , '}');
        }
        else {
            json.append("}");
        }
        return json.toString();
    }
    

    public static <T> String bean2json(T bean, String... fields) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        StringBuilder json = new StringBuilder();
        json.append("{");
        for (String field : fields) {
            json.append(field).append(":").append(BeanUtils.getProperty(bean , field)).append(",");
        }
        json.setCharAt(json.length() - 1 , '}');
        return json.toString();
    }
    

    public static List<?> jsonArrayToBeanList(String json, Class<?> objClass) {
        JsonUtil.log.info("CLASS  : " + objClass.getName());
        JsonUtil.log.info("JSON   : " + json);
        Object[] array = null;
        if (StringUtils.isNotEmpty(StringUtils.trim(json))) {
            JSONArray jsonArray = JSONArray.fromObject(json);
            Object arrayObj = JSONArray.toArray(jsonArray , objClass);
            array = (Object[]) arrayObj;
            return Arrays.asList(array);
        }
        else {
            return null;
        }
    }
    

    /**
     * @param list
     *            list对象
     * @return String
     */
    public static String list2json(List<?> list) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                json.append(JsonUtil.object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1 , ']');
        }
        else {
            json.append("]");
        }
        return json.toString();
    }
    

    /**
     * @param map
     *            map对象
     * @return String
     */
    public static String map2json(Map<?, ?> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                json.append(JsonUtil.object2json(key));
                json.append(":");
                json.append(JsonUtil.object2json(map.get(key)));
                json.append(",");
            }
            json.setCharAt(json.length() - 1 , '}');
        }
        else {
            json.append("}");
        }
        return json.toString();
    }
    

    /**
     * @param obj
     *            任意对象
     * @return String
     */
    public static String object2json(Object obj) {
        StringBuilder json = new StringBuilder();
        if (obj == null) {
            json.append("\"\"");
        }
        else if (obj instanceof String || obj instanceof Integer || obj instanceof Float || obj instanceof Boolean || obj instanceof Short || obj instanceof Double || obj instanceof Long
                || obj instanceof BigDecimal || obj instanceof BigInteger || obj instanceof Byte) {
            json.append("\"").append(JsonUtil.string2json(obj.toString())).append("\"");
        }
        else if (obj instanceof Object[]) {
            json.append(JsonUtil.array2json((Object[]) obj));
        }
        else if (obj instanceof List) {
            json.append(JsonUtil.list2json((List<?>) obj));
        }
        else if (obj instanceof Map) {
            json.append(JsonUtil.map2json((Map<?, ?>) obj));
        }
        else if (obj instanceof Set) {
            json.append(JsonUtil.set2json((Set<?>) obj));
        }
        else {
            json.append(JsonUtil.bean2json(obj));
        }
        return json.toString();
    }
    

    /**
     * @param set
     *            集合对象
     * @return String
     */
    public static String set2json(Set<?> set) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (set != null && set.size() > 0) {
            for (Object obj : set) {
                json.append(JsonUtil.object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1 , ']');
        }
        else {
            json.append("]");
        }
        return json.toString();
    }
    

    /**
     * @param s
     *            参数
     * @return String
     */
    public static String string2json(String s) {
        if (s == null) { return ""; }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
            case '"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\t':
                sb.append("\\t");
                break;
            case '/':
                sb.append("\\/");
                break;
            default:
                if (ch >= '\u0000' && ch <= '\u001F') {
                    String ss = Integer.toHexString(ch);
                    sb.append("\\u");
                    for (int k = 0; k < 4 - ss.length(); k++) {
                        sb.append('0');
                    }
                    sb.append(ss.toUpperCase());
                }
                else {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
