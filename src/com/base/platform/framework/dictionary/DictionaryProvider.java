package com.base.platform.framework.dictionary;

import com.base.platform.framework.dictionary.Dictionary;

/**
 * 
 * @author pan,shaohua
 * @date 2013.08.08
 * 
 */
public interface DictionaryProvider {
	
	Dictionary getDictionary(String name);
	
	void register(Dictionary dict);

}
