package com.league.project.model;

import java.io.Serializable;

import java.util.ArrayList;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.league.myrecord.model.MyRecordBo;

@Entity
@Table(name="L_PROJECT")
public class ProjectBo implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;////hibernate的uuid机制,生成32为字符串
	/** 
	 * 内容
	 */
	@Column(name="NAME")
	private String name;
	@Column(name="PROJECTSYNOPSIS")
	private String projectSynopsis;//项目简介
	@Column(name="CREATEPERSON")
	private String createPerson;//创建人
	@Column(name="CREATEDATE")
	private String createDate;//创建日期
	@Column(name="MODIFYPERSON")
	private String modifyPerson;//修改人
	@Column(name="MODIFYDATE")
	private String modifyDate;//修改日期
	@Column(name="REMARK")
	private String remark;//备注
	@Column(name="PROJECTTYPE")
	private String projectType;//项目类型
	@Column(name="DELETEIF")
	private String  deleteif;//是否删除0为不删除标志，1为删除标志
	@Column(name="PROJECTFLAG")
	private String projectFlag;//标志位￥
	@Column(name="IDENTIFIER")
	private  String identifier;//唯一标识
	@Column(name="CARDSNAME")
	private String cardsName;
	@Column(name="CARDSHISTORYNAME")
	private String cardsHistoryName;
	@Column(name="ISPUBLIC")
	public String isPublic;
	
	
	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	@ManyToMany
	@JoinTable(name = "l_project_user", joinColumns = { @JoinColumn(name = "projectId") }, inverseJoinColumns = { @JoinColumn(name = "userId") })
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("id")
	private List<MyRecordBo> myRecordList = new ArrayList<MyRecordBo>();
	
	
	public String getDeleteif() {
		return deleteif;
	}
	public String getProjectFlag() {
		return projectFlag;
	}
	public void setProjectFlag(String projectFlag) {
		this.projectFlag = projectFlag;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getCardsName() {
		return cardsName;
	}
	public void setCardsName(String cardsName) {
		this.cardsName = cardsName;
	}
	public String getCardsHistoryName() {
		return cardsHistoryName;
	}
	public void setCardsHistoryName(String cardsHistoryName) {
		this.cardsHistoryName = cardsHistoryName;
	}
	public void setDeleteif(String deleteif) {
		this.deleteif = deleteif;
	}
	
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProjectSynopsis() {
		return projectSynopsis;
	}
	public void setProjectSynopsis(String projectSynopsis) {
		this.projectSynopsis = projectSynopsis;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyPerson() {
		return modifyPerson;
	}
	public void setModifyPerson(String modifyPerson) {
		this.modifyPerson = modifyPerson;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public List<MyRecordBo> getMyRecordList() {
		return myRecordList;
	}
	public void setMyRecordList(List<MyRecordBo> myRecordList) {
		this.myRecordList = myRecordList;
	}
	
	

}
