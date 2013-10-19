package com.base.platform.framework.web.orm.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springside.modules.utils.ReflectionUtils;

import com.base.platform.framework.web.orm.Order;

/**
 * <p/>
 * Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua
 * @date 2013.10.11
 */
public class SimpleHibernateDao<T, PK extends Serializable> {

	protected static Logger logger = Logger.getLogger(SimpleHibernateDao.class);

	protected SessionFactory sessionFactory;
	protected Class<T> entityClass;

	public SimpleHibernateDao() {
		this.entityClass = ReflectionUtils.getSuperClassGenricType(super
				.getClass());
	}

	public SimpleHibernateDao(SessionFactory sessionFactory,
			Class<T> entityClass) {
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().saveOrUpdate(entity);
		getSession().flush();
		logger.debug("save entity: {}" + entity);
	}

	public void delete(T entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().delete(entity);
		getSession().flush();
		logger.debug("delete entity: {}" + entity);
	}

	public void delete(PK id) {
		Assert.notNull(id, "id不能为空");
		delete(get(id));
		logger.debug("delete entity {},id is {}"
				+ this.entityClass.getSimpleName() + id);
	}

	@SuppressWarnings("unchecked")
	public T get(PK id) {
		Assert.notNull(id, "id不能为空");
		return (T) getSession().load(this.entityClass, id);
	}

	public int batchExecute(String hql, Map<String, Object> values) {
		return createQuery(hql, values).executeUpdate();
	}

	public Query createQuery(String queryString, Object value) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (value != null) {

			query.setParameter(0, value);

		}
		return query;
	}

	public Criteria createCriteria(Criterion[] criterions) {
		Criteria criteria = getSession().createCriteria(this.entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}

		// if (isExistField("flag")) {
		// criteria.add(Restrictions.eq("flag", Integer.valueOf(1)));
		// }
		return criteria;
	}

	@SuppressWarnings("unchecked")
	public List<T> find(Criterion[] criterions) {
		return createCriteria(criterions).list();
	}

	public Query createQuery(String queryString, Object[] values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; ++i) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	public Query createQuery(String queryString) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);

		return query;
	}

	@SuppressWarnings("rawtypes")
	protected boolean isExistField(String fieldName) {
		for (Class superClass = this.entityClass; superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				if (superClass.getDeclaredField(fieldName) != null)
					return true;
			} catch (NoSuchFieldException localNoSuchFieldException) {
			}
		}
		return false;
	}

	public Query distinct(Query query) {
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return query;
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] values) {
		return createQuery(hql, values).list();
	}

	public List<T> findBy(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.eq(propertyName, value);
		return find(new Criterion[] { criterion });
	}

	public Criteria distinct(Criteria criteria) {
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	public List<T> getAll() {
		return find(new Criterion[0]);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(Order order) {
		Assert.isTrue(order.isOrderBySetted(), "请设置排序属性");
		if (StringUtils.equals("asc", order.getOrder())) {
			return createCriteria(new Criterion[0]).addOrder(
					org.hibernate.criterion.Order.asc(order.getOrderBy()))
					.list();
		}
		return createCriteria(new Criterion[0]).addOrder(
				org.hibernate.criterion.Order.desc(order.getOrderBy())).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findBy(String propertyName, Object value, Order order) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Assert.isTrue(order.isOrderBySetted(), "请设置排序属性");
		Criterion criterion = Restrictions.eq(propertyName, value);
		if (StringUtils.equals("asc", order.getOrder())) {
			return createCriteria(new Criterion[] { criterion }).addOrder(
					org.hibernate.criterion.Order.asc(order.getOrderBy()))
					.list();
		}
		return createCriteria(new Criterion[] { criterion }).addOrder(
				org.hibernate.criterion.Order.desc(order.getOrderBy())).list();
	}

	@SuppressWarnings("unchecked")
	public T findUniqueBy(String propertyName, Object value) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.eq(propertyName, value);
		return (T) createCriteria(new Criterion[] { criterion }).uniqueResult();
	}

	public String getIdName() {
		ClassMetadata meta = getSessionFactory().getClassMetadata(
				this.entityClass);
		return meta.getIdentifierPropertyName();
	}
}