package com.league.notice.vo;

import com.base.platform.framework.utils.BaseVo;


/**
 * @Author pan,shaohua
 * @date 2011.10.10
 */

public class NoticeVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String djgzContent;

	private String djgzName;

	private String djgzTime;

	private String papSaveName;

	private String papUrl;
	
	private String viewUrl;
	/**
	 * 发布时间
	 */
	private String operatetime;

	/**
	 * 发布人
	 */
	private String operator;
	/**
	 * 公告类型
	 */

	private String djgzType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getViewUrl() {
		return viewUrl;
	}

	public void setViewUrl(String viewUrl) {
		this.viewUrl = viewUrl;
	}
	public String getDjgzContent() {
		return djgzContent;
	}

	public void setDjgzContent(String djgzContent) {
		this.djgzContent = djgzContent;
	}

	public String getDjgzName() {
		return djgzName;
	}

	public void setDjgzName(String djgzName) {
		this.djgzName = djgzName;
	}

	public String getDjgzTime() {
		return djgzTime;
	}

	public void setDjgzTime(String djgzTime) {
		this.djgzTime = djgzTime;
	}

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

	public String getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(String operatetime) {
		this.operatetime = operatetime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getDjgzType() {
		return djgzType;
	}

	public void setDjgzType(String djgzType) {
		this.djgzType = djgzType;
	}
}