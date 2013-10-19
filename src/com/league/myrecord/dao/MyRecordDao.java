package com.league.myrecord.dao;

import java.util.List;

import com.base.platform.framework.web.orm.EntityDao;
import com.league.myrecord.model.MyRecordBo;

public interface MyRecordDao extends EntityDao<MyRecordBo, Long>{
	
	public List<MyRecordBo> doHqlPageQuery(String hql, int pageNo, int pageSize);
	
	public int queryRecordCount(String hql);

}
