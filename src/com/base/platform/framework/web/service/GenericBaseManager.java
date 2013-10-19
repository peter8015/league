package com.base.platform.framework.web.service;

import java.io.Serializable;
import java.util.List;
import org.springside.modules.orm.PropertyFilter;
import com.base.platform.framework.web.orm.Order;
/**
 * <p/> Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2013.10.11
 */
public  interface GenericBaseManager<T, PK extends Serializable> {
	public  boolean doSave(T paramT) throws Exception;

	public  boolean doUpdate(T paramT) throws Exception;

	public  boolean doDelete(T paramT) throws Exception;

	public  boolean doDelete(List<PK> paramList) throws Exception;

	public  List<T> findAll() throws Exception;

	public  List<T> findAll(Order paramOrder) throws Exception;

	public  T findEntityBeanById(PK paramPK) throws Exception;

	public  List<T> findBy(String paramString, Object paramObject)
			throws Exception;

	public  List<T> findBy(String paramString, Object paramObject,
			Order paramOrder) throws Exception;

	public  T findUniqueBy(String paramString, Object paramObject)
			throws Exception;

	public  List<T> find(List<PropertyFilter> paramList);

	public  List<T> find(List<PropertyFilter> paramList,
			Order paramOrder);
	
	public List<T> pageQuery(int pageNo, int pageSize, T bo);

	public List<T> pageOrQuery(int pageNo, int pageSize, T bo);

	public int queryRecordCount(T bo);

	public int queryOrRecordCount(T bo);
}
