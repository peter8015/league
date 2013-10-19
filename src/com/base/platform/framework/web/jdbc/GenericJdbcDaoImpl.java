package com.base.platform.framework.web.jdbc;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springside.modules.utils.ReflectionUtils;
/**
 * <p/> Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2013.10.11
 */
public abstract class GenericJdbcDaoImpl<T, PK extends Serializable> extends
		SimpleJdbcDaoSupport implements GenericJdbcDao<T, PK> {
	private Class<T> clazz;

	protected abstract String getEntityBeanByIdSql();

	protected abstract String getSaveSql(T paramT);

	protected abstract String getUpdateSql(T paramT);

	protected abstract String getDeleteSql(T paramT);

	protected abstract String getFindSql(T paramT);

	protected GenericJdbcDaoImpl() {
		this.clazz = ReflectionUtils.getSuperClassGenricType(super.getClass());
	}

	public int save(T t) throws Exception {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getSimpleJdbcTemplate().getNamedParameterJdbcOperations()
				.update(getSaveSql(t), new BeanPropertySqlParameterSource(t),
						keyHolder);
		return ((keyHolder.getKeys().get("ID") == null) ? 0 : keyHolder
				.getKey().intValue());
	}

	public void update(T t) throws Exception {
		getSimpleJdbcTemplate().update(getUpdateSql(t),
				new BeanPropertySqlParameterSource(t));
	}

	public void delete(T t) throws Exception {
		getSimpleJdbcTemplate().update(getDeleteSql(t),
				new BeanPropertySqlParameterSource(t));
	}

	@SuppressWarnings("deprecation")
	public List<T> find(T t) throws Exception {
		return getSimpleJdbcTemplate().query(getFindSql(t),
				ParameterizedBeanPropertyRowMapper.newInstance(this.clazz),
				new BeanPropertySqlParameterSource(t));
	}

	@SuppressWarnings("deprecation")
	public T getEntityBeanById(PK id) throws Exception {
		return getSimpleJdbcTemplate().queryForObject(getEntityBeanByIdSql(),
				ParameterizedBeanPropertyRowMapper.newInstance(this.clazz),
				new Object[] { id });
	}
}
