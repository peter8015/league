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

 * 
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseBo implements Serializable {

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

	/**
	 * 保留字段
	 * 
	 */
	@Column(name = "RESERVED1", length = 50)
	private String reserved1;

	@Column(name = "RESERVED2", length = 50)
	private String reserved2;

	@Column(name = "RESERVED3", length = 50)
	private String reserved3;

	@Column(name = "RESERVED4", length = 50)
	private String reserved4;

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

	public String getReserved1() {
		return reserved1;
	}

	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}

	public String getReserved2() {
		return reserved2;
	}

	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}

	public String getReserved3() {
		return reserved3;
	}

	public void setReserved3(String reserved3) {
		this.reserved3 = reserved3;
	}

	public String getReserved4() {
		return reserved4;
	}

	public void setReserved4(String reserved4) {
		this.reserved4 = reserved4;
	}
}
