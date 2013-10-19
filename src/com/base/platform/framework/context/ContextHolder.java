/**
 * ContextHolder.java com.thtf.rmi.manage.tool.context
 * 
 * @date 2010-10-13
 * @author pan,shaohua
 */
package com.base.platform.framework.context;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.base.platform.framework.cache.CachedMap;
import com.base.platform.framework.cache.utils.Pair;

/**
 * ClassName:ContextHolder
 * 
 * @author pan,shaohua
 * @Date 2010-10-13 下午05:15:20
 */
public class ContextHolder {
    private static final ContextHolder contextHolder = new ContextHolder();
    
    private ApplicationContext         context;
    
    private CachedMap                  cachedMap;
    
    
    public ContextHolder() {
    }
    

    public static Object getBean(String beanName) {
        return ContextHolder.getInstance().getContext().getBean(beanName);
    }
    

    /**
     * 取得缓存的LIST
     * 
     * @param key
     * @return
     */
    public static List<? extends Object> getCachedList(String key) {
        return ContextHolder.getInstance().getCachedMap().get(key);
    }
    

    /**
     * 缓存的是LIST在特定情况下需要用MAP直接转换一次；
     * 
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> getCachedDictMap(String key) {
        List<? extends Object> list = ContextHolder.getInstance().getCachedMap().get(key);
        Map<String, String> map = new LinkedHashMap<String, String>();
        if (list != null && !list.isEmpty()) {
            Object object = list.get(0);
            if (object != null && object instanceof Pair) {
                for (Object obj : list) {
                    Pair<String, String> pair = (Pair<String, String>) obj;
                    if (pair != null) {
                        map.put(pair.getKey(), pair.getValue());
                    }
                }
            }
        }
        return map;
    }
    

    public static ContextHolder getInstance() {
        return contextHolder;
    }
    

    public ApplicationContext getContext() {
        return context;
    }
    

    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    

    public CachedMap getCachedMap() {
        return cachedMap;
    }
    

    public void setCachedMap(CachedMap cachedMap) {
        this.cachedMap = cachedMap;
    }
    
}
