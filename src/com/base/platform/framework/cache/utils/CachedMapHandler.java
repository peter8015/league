package com.base.platform.framework.cache.utils;

import java.util.List;

import com.base.platform.framework.cache.CachedMap;

public class CachedMapHandler {
    
    public static void setValue(CachedMap cachedMap, String key, List<? extends Object> list) {
        cachedMap.put(key, list);
    }
    
}
