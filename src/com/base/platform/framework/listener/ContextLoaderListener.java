/**
 * 
 * @date 2010-10-27
 * @author pan,shaohua
 */
package com.base.platform.framework.listener;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.base.platform.framework.cache.CachedMapService;
import com.base.platform.framework.cache.ehcache.BaseCodeListCacheProvider;
import com.base.platform.framework.cache.impl.CachedApplicationMapService;
import com.base.platform.framework.context.ContextHolder;

/**
 * ClassName:ContextLoaderListener
 * 
 * @author pan,shaohua
 * @Date 2010-10-27 下午05:53:48
 */
public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {
    Logger log = Logger.getLogger(ContextLoaderListener.class);
    
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        
        /**
         * 在组装好的WebApplicationContext对象中 通过getServletContext取得bean的上下文值
         */
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        ContextHolder.getInstance().setContext(context);
        log.debug("com.base.platform.framework.context.ContextHolder get WebApplicationContext instance success ...");
        
        /**
         * 初始化数据字典数据缓存
         */
        CachedMapService cachedMapService = CachedApplicationMapService.getInstance();
        cachedMapService.initCachedMap();
        cachedMapService.cacheAll();
        
        /**
         * 初始化国际化数据缓存
         */
		if (context != null) {
			//BaseCodeListCacheProvider ccc = (BaseCodeListCacheProvider)context.getBean("codeListCacheProvider");
			try {
				//ccc.cache2Context();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        log.debug("com.base.platform.framework.cache.CachedMapService cached map success ...");
        
    }
}
