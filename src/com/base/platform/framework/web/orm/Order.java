package com.base.platform.framework.web.orm;

import org.apache.commons.lang.StringUtils;
/**
 * <p/> Persistence framework which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2013.10.11
 */
public class Order {
	public static final String ASC = "asc";
	public static final String DESC = "desc";
	private String orderBy = null;

	private String order = null;

	public Order() {
	}

	public Order(String orderBy, String order) {
		this.orderBy = orderBy;
		setOrder(order);
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public boolean isOrderBySetted() {
		return ((StringUtils.isNotBlank(this.orderBy)) && (StringUtils
				.isNotBlank(this.order)));
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		String[] orders = StringUtils.split(StringUtils.lowerCase(order), ',');
		for (String orderStr : orders) {
			if ((StringUtils.equals("desc", orderStr))
					|| (StringUtils.equals("asc", orderStr)))
				continue;
			throw new IllegalArgumentException("排序方向" + orderStr + "不是合法值");
		}

		this.order = StringUtils.lowerCase(order);
	}

	public String getOrderHQL() {
		if (isOrderBySetted()) {
			return " order by " + this.orderBy + " " + this.order;
		}
		return null;
	}
}
