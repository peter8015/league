package com.base.platform.framework.cache.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.base.platform.framework.cache.CachedMap;

public class CachedApplicationMap implements CachedMap {
    
    private static final long                   serialVersionUID = -459791656289669055L;
    private Map<String, List<? extends Object>> map              = new ConcurrentHashMap<String, List<? extends Object>>();
    private static CachedApplicationMap         instance;
    
    
    public static synchronized CachedApplicationMap getInstance() {
        if (CachedApplicationMap.instance == null) {
            CachedApplicationMap.instance = new CachedApplicationMap();
        }
        return CachedApplicationMap.instance;
    }
    

    private CachedApplicationMap() {
        CachedMap.log.debug(" cached application map initialized .");
    }
    

    @Override
    public boolean clear() {
        map.clear();
        CachedMap.log.debug("cached application map is cleared in memory . ");
        return true;
    }
    

    @Override
    public Boolean containsKey(String key) {
        CachedMap.log.debug(" cached application map contains key ? " + key);
        return map.containsKey(key);
    }
    

    @Override
    public List<? extends Object> get(String key) {
        CachedMap.log.debug(" get list from cached application map . key -> " + key);
        return map.get(key);
    }
    

    @Override
    public Set<String> keySet() {
        CachedMap.log.debug(" get all keys from cached application map . ");
        return map.keySet();
    }
    

    @Override
    public boolean put(String key, List<? extends Object> list) {
        map.put(key , list);
        CachedMap.log.debug("key -> " + key + " , value -> " + list + " put into memory .");
        return true;
    }
    

    @Override
    public boolean remove(String key) {
        map.remove(key);
        CachedMap.log.debug("key -> " + key + " , removed from memory . ");
        return true;
    }
    
}
