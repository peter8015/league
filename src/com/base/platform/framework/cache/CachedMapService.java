package com.base.platform.framework.cache;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author pan,shaohua
 * @date 2013.08.08
 * 
 */
public interface CachedMapService extends Serializable {
    
    void initCachedMap();
    

    void setValue(String key, List<? extends Object> list);
    

    void setSqlValue(String key, String sql);
    

    void setDictCacheMap();
    

    void setCustomCacheMap();
    

    void cacheAll();
    

    void cacheRefresh();
}
