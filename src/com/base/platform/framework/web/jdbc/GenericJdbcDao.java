package com.base.platform.framework.web.jdbc;

import java.io.Serializable;
import java.util.List;
/**
 * <p/> Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2013.10.11
 */
public abstract interface GenericJdbcDao<T, PK extends Serializable> {
	public abstract int save(T paramT) throws Exception;

	public abstract void update(T paramT) throws Exception;

	public abstract void delete(T paramT) throws Exception;

	public abstract List<T> find(T paramT) throws Exception;

	public abstract T getEntityBeanById(PK paramPK) throws Exception;
}
