package com.base.platform.framework.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * 整个web-app所有需要的变量
 * 
 *
 */
@SuppressWarnings("serial")
public class Variable implements Serializable{
	/**
	 * 
	 * 每页显示的条数
	 */
	private int pageSize = 20;
	
	private Map<Integer,String> userTypeMap;
	
	private Map<String, String> stationTypeMap;
	
	private Map<Integer,String> authTypeMap;
	
	private Map<Integer,String> stoibTypeMap;
	
	public Map<Integer, String> getStoibTypeMap() {
		return stoibTypeMap;
	}

	public void setStoibTypeMap(Map<Integer, String> stoibTypeMap) {
		this.stoibTypeMap = stoibTypeMap;
	}

	public Map<Integer, String> getAuthTypeMap() {
		return authTypeMap;
	}

	public void setAuthTypeMap(Map<Integer, String> authTypeMap) {
		this.authTypeMap = authTypeMap;
	}

	public Map<String, String> getStationTypeMap() {
		return stationTypeMap;
	}

	public void setStationTypeMap(Map<String, String> stationTypeMap) {
		this.stationTypeMap = stationTypeMap;
	}

	public Map<Integer, String> getUserTypeMap() {
		return userTypeMap;
	}

	public void setUserTypeMap(Map<Integer, String> userTypeMap) {
		this.userTypeMap = userTypeMap;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
