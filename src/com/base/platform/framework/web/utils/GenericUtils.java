package com.base.platform.framework.web.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p/> Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2013.10.11
 */
public final class GenericUtils {
	public static <K, V> Map<K, V> newHashMap() {
		return new HashMap();
	}

	public static <T> List<T> initArrayList(T[] values) {
		ArrayList<T> list = new ArrayList<T>();
		for (Object t : values) {
			list.add((T) t);
		}
		return list;
	}

	public static <T> List<T> newArrayList() {
		return new ArrayList();
	}
}
