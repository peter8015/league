package com.base.platform.framework.schedule.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.base.platform.framework.cache.CachedMapService;
import com.base.platform.framework.cache.impl.CachedApplicationMapService;

public class CachedMapRefreshJob extends QuartzJobBean {
    
    private Logger           log              = Logger.getLogger(CachedMapRefreshJob.class);
    private CachedMapService cachedMapService = CachedApplicationMapService.getInstance();
    
    
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("cached map refresh job started .");
        cachedMapService.cacheRefresh();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        Date nextFireTime = jobExecutionContext.getNextFireTime();
        log.debug("cached map refresh job ended . next fire time is  " + dateFormat.format(nextFireTime));
        System.gc();
    }
    
}
