package com.base.platform.framework.web.orm.hibernate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.utils.ReflectionUtils;

import com.base.platform.framework.web.orm.EntityDao;
import com.base.platform.framework.web.orm.Order;

/**
 * <p/>
 * Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua
 * @date 2013.10.11
 */
public class HibernateEntityDao<T, PK extends Serializable> extends
		SimpleHibernateDao<T, PK> implements EntityDao<T, PK> {

	protected static Logger logger = Logger.getLogger(HibernateEntityDao.class);

	public HibernateEntityDao() {
	}

	public HibernateEntityDao(SessionFactory sessionFactory,
			Class<T> entityClass) {
		super(sessionFactory, entityClass);
	}

	@SuppressWarnings("unchecked")
	public List<T> pageQuery(String hql, int pageNo, int pageSize) {
		Session s = null;
		List<T> result = null;
		try {
			s = this.getSession();
			Query q = s.createQuery(hql);
			q.setFirstResult((pageNo - 1) * pageSize);
			q.setMaxResults(pageSize);
			result = q.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// s.close();
		}
		return result;
	}

	public int queryRecordCount(String hql) {
		int count = 0;
		Session s = null;
		try {
			s = this.getSession();
			Query q = s.createQuery(hql);
			count = ((Long) q.uniqueResult()).intValue();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// s.close();
		}
		return count;
	}

	public List<T> findBy(String propertyName, Object value,
			PropertyFilter.MatchType matchType) {
		Criterion criterion = buildPropertyFilterCriterion(propertyName, value,
				matchType);
		return find(new Criterion[] { criterion });
	}

	protected Criterion buildPropertyFilterCriterion(String propertyName,
			Object propertyValue, PropertyFilter.MatchType matchType) {
		// Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = null;
		try {
			if (PropertyFilter.MatchType.EQ.equals(matchType)) {
				criterion = Restrictions.eq(propertyName, propertyValue);

				return criterion;
			}
			if (PropertyFilter.MatchType.LIKE.equals(matchType)) {
				criterion = Restrictions.like(propertyName,
						(String) propertyValue, MatchMode.ANYWHERE);

				return criterion;

			}
			if (PropertyFilter.MatchType.LE.equals(matchType)) {
				criterion = Restrictions.le(propertyName, propertyValue);

				return criterion;
			}
			if (PropertyFilter.MatchType.LT.equals(matchType)) {
				criterion = Restrictions.lt(propertyName, propertyValue);

				return criterion;
			}
			if (PropertyFilter.MatchType.GE.equals(matchType)) {
				criterion = Restrictions.ge(propertyName, propertyValue);

				return criterion;
			}
			if (PropertyFilter.MatchType.GT.equals(matchType))
				criterion = Restrictions.gt(propertyName, propertyValue);
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}
		return criterion;
	}

	protected Map<String, Object> getProperties(List<PropertyFilter> filters) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (PropertyFilter filter : filters) {
			if (PropertyFilter.MatchType.LIKE.equals(filter.getMatchType()))
				map.put(filter.getNamedKey(), "%" + filter.getPropertyValue()
						+ "%");
			else {
				map.put(filter.getNamedKey(), filter.getPropertyValue());
			}
		}
		logger.debug("查询参数值: " + map);
		return map;
	}

	protected StringBuilder setHQLConditionToSb(StringBuilder sb,
			List<PropertyFilter> filters) {
		// if (isExistField("flag")) {
		// sb.append(" flag = 1 and ");
		// }

		if (CollectionUtils.isEmpty(filters)) {
			return sb.replace(sb.length() - 4, sb.length(), "");
		}

		for (PropertyFilter filter : filters) {
			sb.append(filter.getPropertyName()).append(" ")
					.append(filter.getMatchType().getValue()).append(" :")
					.append(filter.getNamedKey()).append(" and ");
		}
		return sb.replace(sb.length() - 4, sb.length(), "");
	}

	private StringBuilder getBaseHQL(List<PropertyFilter> filters) {
		StringBuilder sb = new StringBuilder();
		sb.append("from ").append(this.entityClass.getSimpleName())
				.append(" where ");
		return setHQLConditionToSb(sb, filters);
	}

	@SuppressWarnings("unused")
	private String getHql(Page<T> page, List<PropertyFilter> filters) {
		StringBuilder sb = getBaseHQL(filters);
		if ((page != null) && (page.isOrderBySetted())) {
			sb.append(page.getOrderHQL());
		}
		logger.debug("查询的hql: " + sb.toString());
		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Map<String, Object> values) {
		return createQuery(hql, values).list();
	}

	public List<T> find(List<PropertyFilter> filters) {
		return find(getBaseHQL(filters).toString(), getProperties(filters));
	}

	private String getHql(Order order, List<PropertyFilter> filters) {
		StringBuilder sb = getBaseHQL(filters);
		if ((order != null) && (order.isOrderBySetted())) {
			sb.append(order.getOrderHQL());
		}
		logger.debug("查询的hql: " + sb.toString());
		return sb.toString();
	}

	public List<T> find(List<PropertyFilter> filters, Order order) {
		return find(getHql(order, filters), getProperties(filters));
	}

	public List<T> findBy(String sql, List<Object> params) {
		Query query = this.getSession().createSQLQuery(sql);
		for (int i = 0; i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}

	public int saveAndUpdate(String sql, List<Object> params) {
		Query query = this.getSession().createSQLQuery(sql);
		for (int i = 0; i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}
		return query.executeUpdate();
	}
}
