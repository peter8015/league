package com.league.myrecord.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.league.project.model.ProjectBo;

@Entity
@Table(name="L_MYRECORD")
public class MyRecordBo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;////hibernate的uuid机制,生成32为字符串
	
	@Column(name="NICKNAME")
	private String nickName;//昵称
	
	@Column(name="SEX")
	private String sex;//性别
	
	@Column(name="BIRTH")
	private String birth;//生日
	
	@Column(name="CONSTELLATION")
	private String constellation;//星座
	
	@Column(name="PHOTOPATH")
	private String photoPath;
	
	@Column(name="LOGINNAME")
	private String loginName;
	
	@Column(name="TRUENAME")
	private String trueName;//真实名字
	
	@Column(name="PROJECTID")
	private String projectId;//项目ID
	
	@Column(name="RELEASEID")
	private String releaseId;//版本ID
	
	@Column(name="ITERATORID")
	private String iteratorId;//迭代周期ID
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="USERTYPE")
	private String userType;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ACTIVATE")
	private String activate;
	
	@Column(name="SHAPASSWORD")
	private String shaPassword;
	
	@ManyToMany
	@JoinTable(name = "l_project_user", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "projectId") })
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("id")
	private List<ProjectBo> projectList = new ArrayList<ProjectBo>();
	
	@ManyToMany
	@JoinTable(name = "l_group_user", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "groupId") })
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("id")
	private List<GroupBo> groupList = new ArrayList<GroupBo>();
	
	@Transient
	private boolean inProject;
	
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	@Transient
	private String age;
	
	public String getAge() {
		
		if(birth!=null&&!birth.trim().equals("")){
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();     
			Date mydate;
			  long day=0l;
			try {
				mydate = myFormatter.parse(birth);
				day=(date.getTime()-mydate.getTime())/(24*60*60*1000) + 1;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			    age=new java.text.DecimalFormat("#").format(day/365f);
			
		}
		
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActivate() {
		return activate;
	}
	public void setActivate(String activate) {
		this.activate = activate;
	}
	public List<ProjectBo> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<ProjectBo> projectList) {
		this.projectList = projectList;
	}
	
	public boolean isInProject() {
		return inProject;
	}
	public void setInProject(boolean inProject) {
		this.inProject = inProject;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((loginName == null) ? 0 : loginName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyRecordBo other = (MyRecordBo) obj;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		return true;
	}
	public List<GroupBo> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<GroupBo> groupList) {
		this.groupList = groupList;
	}
	public String getShaPassword() {
		return shaPassword;
	}
	public void setShaPassword(String shaPassword) {
		this.shaPassword = shaPassword;
	}

}
