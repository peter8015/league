package com.base.platform.framework.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public class BeanTranslateUtil {
    
    private static Object beanCopy(Object bo, Class<? extends Object> boClazz, Class<? extends Object> voClazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Method[] declaredMethods = boClazz.getDeclaredMethods();
        Map<String, String> map = new HashMap<String, String>();
        for (Method method : declaredMethods) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                String propName = methodName.substring(3 , 4).toLowerCase() + methodName.substring(4);
                Class<?> returnType = method.getReturnType();
                String strVal = "";
                if (returnType.equals(String.class)) {
                    String obj = (String) method.invoke(bo);
                    if (obj != null) {
                        strVal = obj;
                    }
                }
                else if (returnType.isAssignableFrom(Date.class)) {
                    Date date = (Date) method.invoke(bo);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    if (date != null) {
                        strVal = dateFormat.format(date);
                    }
                }
                else {
                    Object obj = method.invoke(bo);
                    if (obj != null) {
                        strVal = obj.toString();
                    }
                }
                if (StringUtils.isNotEmpty(strVal)) {
                    map.put(propName , strVal);
                }
            }
        }
        Object voObj = voClazz.newInstance();
        Method[] voDeclaredMethods = voClazz.getDeclaredMethods();
        for (Method method : voDeclaredMethods) {
            String methodName = method.getName();
            if (methodName.startsWith("set")) {
                String propName = methodName.substring(3 , 4).toLowerCase() + methodName.substring(4);
                if (map.containsKey(propName)) {
                    method.invoke(voObj , map.get(propName));
                }
            }
        }
        return voObj;
    }
    

    public static Object boToVo(Object bo, Class<? extends Object> boClazz, Class<? extends Object> voClazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return beanCopy(bo , boClazz , voClazz);
    }
    

    private static Map<String, Method> getAccessAbleMethodMap(Class<? extends Object> clazz, String type) throws SecurityException, NoSuchFieldException {
        Map<String, Field> suspectedAccessAbleFieldMap = getSuspectedAccessAbleFieldMap(clazz);
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Map<String, Method> resultMap = new HashMap<String, Method>();
        if (CollectionUtils.isNotEmpty(suspectedAccessAbleFieldMap.keySet())) {
            for (String propName : suspectedAccessAbleFieldMap.keySet()) {
                Field field = suspectedAccessAbleFieldMap.get(propName);
                Class<?> filedType = field.getType();
                String getMethodName = "get" + propName.substring(0 , 1).toUpperCase() + propName.substring(1);
                String setMethodName = "set" + propName.substring(0 , 1).toUpperCase() + propName.substring(1);
                for (Method method : declaredMethods) {
                    String methodName = method.getName();
                    Class<?> returnType = method.getReturnType();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    int length = method.getParameterTypes().length;
                    if (StringUtils.equals(methodName , setMethodName) && StringUtils.equalsIgnoreCase(type , "set") && filedType != null && length == 1 && parameterTypes[0].equals(filedType)) {
                        resultMap.put(propName , method);
                    }
                    if (StringUtils.equals(methodName , getMethodName) && StringUtils.equalsIgnoreCase(type , "get") && filedType != null && length == 0 && returnType.equals(filedType)) {
                        resultMap.put(propName , method);
                    }
                }
            }
        }
        return resultMap;
    }
    

    private static Map<String, Field> getSuspectedAccessAbleFieldMap(Class<? extends Object> clazz) throws SecurityException, NoSuchFieldException {
        Collection<String> accessAbleNames = getSuspectedAccessAbleFieldNames(clazz);
        Map<String, Field> reslutMap = new HashMap<String, Field>();
        for (String name : accessAbleNames) {
            Field field = clazz.getDeclaredField(name);
            reslutMap.put(name , field);
        }
        return reslutMap;
    }
    

    @SuppressWarnings("unchecked")
    private static Collection<String> getSuspectedAccessAbleFieldNames(Class<? extends Object> clazz) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Field[] declaredFields = clazz.getDeclaredFields();
        
        Set<String> fieldNameList = new HashSet<String>();
        Set<String> getterNameList = new HashSet<String>();
        Set<String> setterNameList = new HashSet<String>();
        for (Field field : declaredFields) {
            String name = field.getName();
            fieldNameList.add(name);
        }
        for (Method method : declaredMethods) {
            String methodName = method.getName();
            if (StringUtils.startsWith(methodName , "set")) {
                String propName = methodName.substring(3 , 4).toLowerCase() + methodName.substring(4);
                setterNameList.add(propName);
            }
            if (StringUtils.startsWith(methodName , "get")) {
                String propName = methodName.substring(3 , 4).toLowerCase() + methodName.substring(4);
                getterNameList.add(propName);
            }
        }
        
        Collection<String> accessAbleNames = null;
        if (CollectionUtils.isNotEmpty(fieldNameList) && CollectionUtils.isNotEmpty(setterNameList) && CollectionUtils.isNotEmpty(getterNameList)) {
            accessAbleNames = CollectionUtils.intersection(CollectionUtils.intersection(fieldNameList , setterNameList) , getterNameList);
        }
        return accessAbleNames;
    }
    

    /**
     * 严格拷贝<br>
     * 只有目标对象(dist)属性名称和类型和源对象(src)的名称和类型全一致 ，<br>
     * 且必须目标对象(dist)源对象有get/set方法，且方法是public 的情况才发生拷贝<br>
     * 
     * @param srcObj
     * @param srcClazz
     * @param disClazz
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     */
    public static Object strictCopy(Object srcObj, Class<? extends Object> srcClazz, Class<? extends Object> disClazz) throws Exception {
        Object distObj = disClazz.newInstance();
        distObj = strictCopy(srcObj , srcClazz , distObj , disClazz);
        return distObj;
    }
    

    /**
     * 严格拷贝<br>
     * 只有目标对象(dist)属性名称和类型和源对象(src)的名称和类型全一致 ，<br>
     * 且必须目标对象(dist)源对象有get/set方法，且方法是public 的情况才发生拷贝<br>
     * 
     * @param srcObj
     * @param srcClazz
     * @param disObj
     * @param disClazz
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Object strictCopy(Object srcObj, Class<? extends Object> srcClazz, Object disObj, Class<? extends Object> disClazz) throws Exception {
        Map<String, Method> srcGetMap = getAccessAbleMethodMap(srcClazz , "get");
        Map<String, Method> disSetMap = getAccessAbleMethodMap(disClazz , "set");
        Set<String> srcKeySet = srcGetMap.keySet();
        Set<String> disKeySet = disSetMap.keySet();
        Collection<String> accessAbleKeyCollection = CollectionUtils.intersection(srcKeySet , disKeySet);
        for (String key : accessAbleKeyCollection) {
            Method getMethod = srcGetMap.get(key);
            Method setMethod = disSetMap.get(key);
            if (methodArgsMatch(getMethod , setMethod)) {
                Object value = getMethod.invoke(srcObj);
                setMethod.invoke(disObj , value);
            }
        }
        return disObj;
    }
    

    private static boolean methodArgsMatch(Method getMethod, Method setMethod) {
        Class<?> returnType = getMethod.getReturnType();
        Class<?>[] parameterTypes = setMethod.getParameterTypes();
        if (parameterTypes.length != 1) { return false; }
        Class<?> paramType = parameterTypes[0];
        if (!returnType.isAssignableFrom(paramType)) { return false; }
        return true;
    }
}
