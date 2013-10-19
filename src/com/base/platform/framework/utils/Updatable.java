package com.base.platform.framework.utils;

/**
 * 
 * Action 可以实现的接口，在处理数据更新的用到

*/
public interface Updatable {
	
	/**
	 * 执行更新动作对象的ID
	 * @param id
	 */
	public void preUpdate(Long id);
}
