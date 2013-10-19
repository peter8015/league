package com.base.platform.framework.cache.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.base.platform.framework.cache.CachedMapService;
import com.base.platform.framework.cache.utils.CachedMapHandler;
import com.base.platform.framework.cache.utils.DictHandler;
import com.base.platform.framework.cache.utils.Pair;
import com.base.platform.framework.context.ContextHolder;

public class CachedApplicationMapService implements CachedMapService {
    private static final long                  serialVersionUID = -2570707071926871167L;
    private final Logger                       log              = Logger.getLogger(CachedApplicationMapService.class);
    private final ContextHolder                contextHolder    = ContextHolder.getInstance();
    private final JdbcTemplate                 jdbcTemplate     = (JdbcTemplate) ContextHolder.getBean("persistence.jdbcTemplate");
    private static CachedApplicationMapService instance;
    
    
    public static synchronized CachedApplicationMapService getInstance() {
        if (CachedApplicationMapService.instance == null) {
            CachedApplicationMapService.instance = new CachedApplicationMapService();
        }
        return CachedApplicationMapService.instance;
    }
    

    private CachedApplicationMapService() {
    }
    

    @Override
    public void cacheAll() {
        setDictCacheMap();
        setCustomCacheMap();
    }
    

    @Override
    public void cacheRefresh() {
        contextHolder.getCachedMap().clear();
        cacheAll();
    }
    

    @Override
    public void initCachedMap() {
        if (contextHolder.getCachedMap() == null) {
            contextHolder.setCachedMap(CachedApplicationMap.getInstance());
        }
    }
    

    private List<Pair<String, String>> pairRowSet(String sql) {
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        List<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
        while (rowSet.next()) {
            String key = null;
            String value = null;
            try {
                key = rowSet.getString(1);
            }
            catch (Exception e) {
            }
            try {
                value = rowSet.getString(2);
            }
            catch (Exception e) {
            }
            
            if (key == null) { throw new RuntimeException("sql 至少查询一项."); }
            if (value == null) {
                value = key;
            }
            
            Pair<String, String> pair = new Pair<String, String>(key , value);
            list.add(pair);
        }
        return list;
    }
    

    @Override
    public void setCustomCacheMap() {
        log.debug("set customized cache map ..");
    }
    

    @Override
    public void setDictCacheMap() {
        log.debug("set dictionary cache map ..");
        List<String> commonTableList = DictHandler.commonTableList();
        for (String tableName : commonTableList) {
            String commonSql = DictHandler.getCommonSql(tableName);
            setSqlValue(tableName , commonSql);
        }
        
        // 特殊字典表 民族
        setSqlValue("T_DM_RYMZ" , DictHandler.getRymzSql());
  
        
    }
    

    @Override
    public void setSqlValue(String key, String sql) {
        log.debug("get value from database ..");
        log.debug("sql [ " + sql + " ]");
        setValue(key , pairRowSet(sql));
    }
    

    @Override
    public void setValue(String key, List<? extends Object> list) {
        log.debug("set value  .. " + key);
        CachedMapHandler.setValue(contextHolder.getCachedMap() , key , list);
    }
    
}
