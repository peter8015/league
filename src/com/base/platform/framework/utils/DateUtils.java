package com.base.platform.framework.utils;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 时间日期格式化工具类
 * 
 * @ClassName: DateUtils
 * @author Panshaohua
 * @date 2011.11.21
 * 
 */
public final class DateUtils {
	private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

	public static String getCurrentDate() {
		return DateFormatUtils.format(new Date(), DEFAULT_PATTERN);
	}

	public static String getCurrentDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	public static String dateFormat(Date date,String pattern) {
		return DateFormatUtils.format(date, pattern);
	}
	
	public static String dateDefFormat(Date date) {
		return DateFormatUtils.format(date, DEFAULT_PATTERN);
	}
}
