package com.league.notice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the T_GOV_DJGZ database table.
 * @Author pan,shaohua
 * @date 2011.10.10
 */
@Entity
@Table(name="T_WZGL_TZGG")
public class SsBankMsg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	/** 
	 * 内容
	 */
	@Column(name="DJGZ_CONTENT")
	private String djgzContent;
	/** 
	 * 标题名称
	 */
	@Column(name="DJGZ_NAME")
	private String djgzName;
	/** 
	 * 发布时间
	 */
    @Temporal( TemporalType.DATE)
	@Column(name="DJGZ_TIME")
	private Date djgzTime;
    /**
	 * 上传的文件名
	 */
	@Column(name="PAP_SAVENAME")
	private String papSaveName;
	/**
	 * 显示文件名
	 */
	@Column(name="DIS_FILENAME")
	private String disFileName;
	/**
	 * 上传地址
	 */
	@Column(name="PAP_URL")
	private String papUrl;
	/**
	 * 删除标志
	 */
	@Column(name="FLAG")
	private Integer flag;
	/**
	 * 操作时间
	 */
    @Temporal( TemporalType.DATE)
	@Column(name="OPERATETIME")
	private Date operatetime;
    
    
    /**
	 * 操作人
	 */
	@Column(name="OPERATOR")
	private Long operator;
	/**
	 * 公告类型
	 */
	@Column(name="DJGZ_TYPE")
	private String djgzType;
	
	

	
    public String getPapSaveName() {
		return papSaveName;
	}

	public void setPapSaveName(String papSaveName) {
		this.papSaveName = papSaveName;
	}

	public String getPapUrl() {
		return papUrl;
	}

	public void setPapUrl(String papUrl) {
		this.papUrl = papUrl;
	}

	
    public String getDjgzType() {
		return djgzType;
	}

	public void setDjgzType(String djgzType) {
		this.djgzType = djgzType;
	}

	public SsBankMsg() {
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDjgzContent() {
		return this.djgzContent;
	}

	public void setDjgzContent(String djgzContent) {
		this.djgzContent = djgzContent;
	}

	public String getDjgzName() {
		return this.djgzName;
	}

	public void setDjgzName(String djgzName) {
		this.djgzName = djgzName;
	}

	public Date getDjgzTime() {
		return this.djgzTime;
	}

	public void setDjgzTime(Date djgzTime) {
		this.djgzTime = djgzTime;
	}

	public Integer getFlag() {
		return this.flag;
	}
 
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Date getOperatetime() {
		return this.operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public Long getOperator() {
		return this.operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public void setDisFileName(String disFileName) {
		this.disFileName = disFileName;
	}

	public String getDisFileName() {
		return disFileName;
	}

}