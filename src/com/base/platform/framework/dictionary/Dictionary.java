package com.base.platform.framework.dictionary;

import java.util.Map;


/**
 * 
 * @author pan,shaohua
 * @date 2013.08.08
 * 
 */
public interface Dictionary {

	
	/**
	 * @return 获取这个字典的名字
	 */
	String getName();
	
	/**
	 * 得到所有枚举值
	 * @return 
	 */
	Map<String,String> getItems();
	
	void setItems(Map<String, String> items);
}
