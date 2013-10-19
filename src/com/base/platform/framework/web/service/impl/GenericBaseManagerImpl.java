package com.base.platform.framework.web.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springside.modules.orm.PropertyFilter;

import com.base.platform.framework.web.orm.EntityDao;
import com.base.platform.framework.web.orm.Order;
import com.base.platform.framework.web.service.GenericBaseManager;
/**
 * <p/> Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2013.10.11
 */
public abstract class GenericBaseManagerImpl<T, PK extends Serializable>
		implements GenericBaseManager<T, PK> {
	
	protected static  Logger logger = Logger
			.getLogger(GenericBaseManagerImpl.class);
	
	public abstract EntityDao<T, PK> getEntityDao();

	public boolean doDelete(T t) throws Exception {
		try {
			doUpdate(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}



	public List<T> findAll() throws Exception {
		return getEntityDao().getAll();
	}

	public T findEntityBeanById(PK id) throws Exception {
		return getEntityDao().get(id);
	}

	public boolean doSave(T t) throws Exception {
		try {
			getEntityDao().save(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	public boolean doUpdate(T t) throws Exception {
		try {
			getEntityDao().save(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	public List<T> findBy(String propertyName, Object value) throws Exception {
		return getEntityDao().findBy(propertyName, value);
	}

	public T findUniqueBy(String propertyName, Object value) throws Exception {
		return getEntityDao().findUniqueBy(propertyName, value);
	}



	public List<T> find(List<PropertyFilter> filters) {
		return getEntityDao().find(filters);
	}

	public List<T> find(List<PropertyFilter> filters, Order order) {
		return getEntityDao().find(filters, order);
	}

	public List<T> findAll(Order order) throws Exception {
		return getEntityDao().getAll(order);
	}

	public List<T> findBy(String propertyName, Object value, Order order)
			throws Exception {
		return getEntityDao().findBy(propertyName, value, order);
	}
}
