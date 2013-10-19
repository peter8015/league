package com.league.myrecord.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "L_PROJECT_USER")
public class ProjectUserBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "projectId")
	private Long projectId;

	@Column(name = "userId")
	private Long userId;

	@Column(name = "authority")
	private int authority;

	@Transient
	private MyRecordBo record;

	@Transient
	private String groupNames;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public MyRecordBo getRecord() {
		return record;
	}

	public void setRecord(MyRecordBo record) {
		this.record = record;
	}

	public String getGroupNames() {
		return groupNames;
	}

	public void setGroupNames() {
		StringBuffer str = new StringBuffer();
		if (record != null && record.getGroupList() != null
				&& record.getGroupList().size() > 0) {
			for (GroupBo bo : record.getGroupList()) {
				str.append(bo.getName()).append(",");
			}
			str.deleteCharAt(str.length() - 1);
		}
		groupNames = str.toString();
	}
}
