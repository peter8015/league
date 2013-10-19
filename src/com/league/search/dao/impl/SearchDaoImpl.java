package com.league.search.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.base.platform.framework.web.orm.hibernate.HibernateEntityDao;
import com.league.search.dao.SearchDao;
import com.league.search.model.SearchContentBo;

@Repository("searchDao")
public class SearchDaoImpl extends HibernateEntityDao<SearchContentBo, Long> implements SearchDao{
	
	public List<SearchContentBo> doHqlPageQuery(String hql, int pageNo, int pageSize){
		Query q = this.getSession().createQuery(hql);   
		q.setFirstResult((pageNo-1)*pageSize);
		q.setMaxResults(pageSize);
		List<SearchContentBo> result = q.list();
		return result;
	}
	
	public int queryRecordCount(String hql){
		Query q = this.getSession().createQuery(hql);
		int count = ((Long) q.uniqueResult()).intValue();
		return count;
	}
	
}
