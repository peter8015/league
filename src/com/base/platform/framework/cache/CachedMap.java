package com.base.platform.framework.cache;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * 
 * @author pan,shaohua
 * @date 2013.08.08
 * 
 */
public interface CachedMap extends Serializable {
    
    public static Logger log = Logger.getLogger(CachedMap.class);
    
    
    List<? extends Object> get(String key);
    

    Boolean containsKey(String key);
    

    boolean put(String key, List<? extends Object> list);
    

    Set<String> keySet();
    

    boolean remove(String key);
    

    boolean clear();
}
