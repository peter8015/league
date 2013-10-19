package com.base.platform.framework.utils;


public class Node {
	/**
	 * 父ID
	 */
	private Long parentId;
	
	/**
	 * 自己ID
	 */
	private Long selfId;
	
	/**
	 * 名称
	 */
	private String item;

	/**
	 * 
	 * URL
	 */
	private String url;
	
	/**
	 * 
	 * URL 问号的参数名称
	 */
	private String param;
	
	/**
	 * 
	 * 鼠标放到树节点上是 显示的内容
	 */
	private String altString;
	
	/**
	 * 设置是否回显
	 */
	private boolean echo;
	
	public Node(Long parentId,Long selfId,String name,boolean echo) {
		this.parentId = parentId;
		this.selfId = selfId;
		this.item  = name;
		this.echo = echo;
	}
	
	public Node(Long parentId,Long selfId,String name) {
		this.parentId = parentId;
		this.selfId = selfId;
		this.item  = name;
	}
	public Node() {
		
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getAltString() {
		return altString;
	}

	public void setAltString(String altString) {
		this.altString = altString;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getSelfId() {
		return selfId;
	}

	public void setSelfId(Long selfId) {
		this.selfId = selfId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	public Boolean getEcho() {
		return echo;
	}
	public void setEcho(Boolean echo) {
		this.echo = echo;
	}
	
	
}
