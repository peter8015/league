package com.league.search.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.base.platform.framework.web.orm.hibernate.HibernateEntityDao;
import com.league.myrecord.model.MyRecordBo;
import com.league.search.dao.KeywordDao;
import com.league.search.model.KeywordBo;

@Repository("keywordDao")
public class KeywordDaoImpl extends HibernateEntityDao<KeywordBo, Long> implements KeywordDao{
	
	public List<MyRecordBo> doHqlPageQuery(String hql, int pageNo, int pageSize){
		Query q = this.getSession().createQuery(hql);   
		q.setFirstResult((pageNo-1)*pageSize);
		q.setMaxResults(pageSize);
		List<MyRecordBo> result = q.list();
		return result;
	}
	
	public int queryRecordCount(String hql){
		Query q = this.getSession().createQuery(hql);
		int count = ((Long) q.uniqueResult()).intValue();
		return count;
	}
	
}
