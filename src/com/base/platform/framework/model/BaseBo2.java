package com.base.platform.framework.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 父类实体Bean
 * 
 * 与BaseBo类相比BaseBo2修改了保留字段的属性名称
 * 
 * 

 * 
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseBo2 implements Serializable {

	/**
	 * 状态标识 0：无效 1：有效
	 * 
	 */
	@Column(name = "FLAG", nullable = false)
	private Integer flag;

	/**
	 * 操作人ID
	 * 
	 */
	@Column(name = "OPERATOR", nullable = false)
	private Long operator;

	/**
	 * 
	 * 操作时间
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPERATETIME", length = 20)
	private Date operatetime;

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	public String getReserve4() {
		return reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	}

	/**
	 * 保留字段
	 * 
	 */
	@Column(name = "RESERVE1", length = 50)
	private String reserve1;

	@Column(name = "RESERVE2", length = 50)
	private String reserve2;

	@Column(name = "RESERVE3", length = 50)
	private String reserve3;

	@Column(name = "RESERVE4", length = 50)
	private String reserve4;

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}
}
