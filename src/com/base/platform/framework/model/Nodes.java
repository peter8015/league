package com.base.platform.framework.model;

public class Nodes {
	/**
	 * 当前节点id
	 */
	private Long nodeId;
	/**
	 * 父节点id
	 */
	private Long parentId;
	/**
	 * 当前节点连接地址
	 */
	private String hrefAddress;
	/**
	 * 当前节点名称
	 */
	private String nodeName;

	public Nodes(Long nodeId, Long parentId, String hrefAddress, String nodeName) {
		super();
		this.nodeId = nodeId;
		this.parentId = parentId;
		this.hrefAddress = hrefAddress;
		this.nodeName = nodeName;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getHrefAddress() {
		return hrefAddress;
	}

	public void setHrefAddress(String hrefAddress) {
		this.hrefAddress = hrefAddress;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

}
