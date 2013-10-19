package com.league.notice.utils;
/**
 * <p/> Persistence manager which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2011.09.29
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.base.platform.framework.context.ContextHolder;
import com.league.notice.model.SsBankMsg;

public class NoticeDaoUtil  {


	public static List<SsBankMsg> findPre6Notices() {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ContextHolder.getBean("persistence.jdbcTemplate");
		String sql = "select * from T_WZGL_TZGG where ROWNUM<= 6 order by DJGZ_TIME desc";
	    SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
	    List<SsBankMsg> nbs = new ArrayList<SsBankMsg>();
	    while(sqlRowSet.next()){
	    	 SsBankMsg nb = 	new SsBankMsg();
	    	 nb.setDjgzName(sqlRowSet.getString("DJGZ_NAME"));
	    	 nb.setId(Long.parseLong(sqlRowSet.getString("ID")));
	    	 nbs.add(nb);	 
	    }
		return nbs;
		
	}

}
