package com.base.platform.framework.web.orm;

import java.io.Serializable;
import java.util.List;

import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;

/**
 * <p/>
 * Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua
 * @date 2013.10.11
 */
public  interface EntityDao<T, PK extends Serializable> {
	public  T get(PK paramPK);

	public  List<T> getAll();

	public  List<T> getAll(Order paramOrder);

	public  void save(T paramT);

	public  void delete(T paramT);

	public  void delete(PK paramPK);

	public  String getIdName();

	public  List<T> findBy(String paramString, Object paramObject);

	public  List<T> findBy(String paramString, Object paramObject,
			Order paramOrder);

	public  T findUniqueBy(String paramString, Object paramObject);

	public  List<T> find(List<PropertyFilter> paramList);

	public  List<T> find(List<PropertyFilter> paramList,
			Order paramOrder);

	public List<T> pageQuery(String hql, int pageNo, int pageSize);

	public int queryRecordCount(String hql);
}
