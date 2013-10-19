package com.league.sys;


public class LeagueUser {

	private String loginName;
	private String realName;
	private String photoPath;
	
	private String projectId;//项目ID
	private String releaseId;//版本ID
	private String iteratorId;//迭代周期ID
	
	private String projectIdentifier;//唯一标识
	
	
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}
	public String getIteratorId() {
		return iteratorId;
	}
	public void setIteratorId(String iteratorId) {
		this.iteratorId = iteratorId;
	}

	
}
