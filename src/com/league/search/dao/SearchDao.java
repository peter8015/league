package com.league.search.dao;

import java.util.List;

import com.base.platform.framework.web.orm.EntityDao;
import com.league.search.model.SearchContentBo;

public interface SearchDao extends EntityDao<SearchContentBo, Long>{
	
	public List<SearchContentBo> doHqlPageQuery(String hql, int pageNo, int pageSize);
	
	public int queryRecordCount(String hql);

}
