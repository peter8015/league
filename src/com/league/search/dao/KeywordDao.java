package com.league.search.dao;

import java.util.List;

import com.base.platform.framework.web.orm.EntityDao;
import com.league.myrecord.model.MyRecordBo;
import com.league.search.model.KeywordBo;

public interface KeywordDao extends EntityDao<KeywordBo, Long>{
	
	public List<MyRecordBo> doHqlPageQuery(String hql, int pageNo, int pageSize);
	
	public int queryRecordCount(String hql);

}
