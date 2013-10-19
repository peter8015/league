package com.league.myrecord.service;

import java.util.List;

import com.base.platform.framework.web.service.GenericBaseManager;
import com.league.myrecord.model.MyRecordBo;

public interface MyRecordServiceFacade extends GenericBaseManager<MyRecordBo, Long>{
	
	public List<MyRecordBo> pageQuery(int pageNo, int pageSize, MyRecordBo bo);
	
	public List<MyRecordBo> pageOrQuery(int pageNo, int pageSize, MyRecordBo bo);
	
	public int queryRecordCount(MyRecordBo bo);
	
	public int queryOrRecordCount(MyRecordBo bo);
	
}
