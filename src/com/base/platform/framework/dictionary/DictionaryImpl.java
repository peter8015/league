package com.base.platform.framework.dictionary;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author pan,shaohua
 * @date 2013.08.08
 * 
 */

public class DictionaryImpl implements Dictionary {
	
	protected final Log logger = LogFactory.getLog(getClass());

	private String name;
	
	private Map<String,String> items;

	public void setItems(Map<String, String> items) {
		this.items = items;
	}

	@Override
	public Map<String, String> getItems() {
		return items;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}



}
