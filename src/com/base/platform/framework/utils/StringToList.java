package com.base.platform.framework.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串转换成list集合
 * 
 * @ClassName: StringToList
 * 
 * @Description: TODO
 * @author：psh882003@gmail.com
 * @date：2010-7-17 下午05:14:22
 * 
 */
public final class StringToList {

	/**
	 * 默认以逗号分割
	 * 
	 * @param idList
	 *            进行转换的字符串
	 * @return
	 */
	public static List<Long> string2List(String idList) {
		return string2List(idList, ",");
	}

	/**
	 * 
	 * @param idList
	 *            进行转换的字符串
	 * @param sepStr
	 *            分隔符
	 * @return
	 */
	public static List<Long> string2List(String idList, String sepStr) {
		if (StringUtils.isBlank(idList)) {
			return Collections.emptyList();
		}
		List<Long> ids = new ArrayList<Long>();
		for (String id : StringUtils.split(idList, sepStr)) {
			if (StringUtils.isBlank(id)) {
				continue;
			}
			ids.add(Long.valueOf(id));
		}
		return ids;
	}

}
