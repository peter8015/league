package com.base.platform.framework.dictionary;

import java.util.HashMap;
import java.util.Map;

import com.base.platform.framework.dictionary.Dictionary;

/**
 * 
 * @author pan,shaohua
 * @date 2013.08.08
 * 
 */
public class DictionaryProviderImpl implements DictionaryProvider {
	
	private Map<String,Dictionary> map = new HashMap<String,Dictionary>();

	@Override
	public Dictionary getDictionary(String name) {
		return this.map.get(name);
	}

	@Override
	public void register(Dictionary dict) {
		map.put(dict.getName(), dict);
	}

}
