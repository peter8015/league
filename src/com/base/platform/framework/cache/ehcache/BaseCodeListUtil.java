package com.base.platform.framework.cache.ehcache;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.base.platform.framework.cache.utils.DictHandler;
import com.base.platform.framework.context.ContextHolder;

/**
 * 缓存处理类
 * 
 * @author pan,shaohua
 * @date 2013.08.08
 */

public class BaseCodeListUtil {

	private final  JdbcTemplate jdbcTemplate = (JdbcTemplate) ContextHolder
			.getBean("persistence.jdbcTemplate");
	
	public static Logger log = Logger.getLogger(BaseCodeListUtil.class);


	
	private Map<String, String> pairRowSet(String sql) {
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		Map<String, String> map = new HashMap<String, String>();
		while (rowSet.next()) {
			String key = null;
			String value = null;
			try {
				key = rowSet.getString(1);
			} catch (Exception e) {
			}
			try {
				value = rowSet.getString(2);
			} catch (Exception e) {
			}

			if (key == null) {
				throw new RuntimeException("sql 至少查询一项.");
			}
			if (value == null) {
				value = key;
			}
			map.put(key, value);
		}
		return map;
	}

	public  Map<String, String> findGcsTransLanZhList() {
		Map map = this.pairRowSet(DictHandler.getZHCNSql());
		return map;
	}

	public  Map<String, String> findGcsTransLanEnList() {
		Map map = pairRowSet(DictHandler.getENUSSql());
		return map;
	}

	public  Map<String, String> findGcsTransLanTwList() {
		Map map = pairRowSet(DictHandler.getZHTWSql());
		return map;
	}

}
