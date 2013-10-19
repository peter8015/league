/**
 * ContextLoaderListener.java com.thtf.elearning.listener
 * 
 * @date 2010-10-27
 * @author pan,shaohua
 */
package com.base.platform.framework.context;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
        
       
        log.debug("com.base.platform.framework.cache.CachedMapService cached map success ...");
        
    }
}
