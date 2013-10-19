package com.base.platform.framework.web.action;

/**
 * <p/>
 * NoticeContorller  which provides basic CRUD operations
 * 
 * @author Pan,Shaohua
 * @date 2013.10.11
 */

import org.apache.log4j.Logger;

public class BaseContorller {

	private static final Logger logger = Logger.getLogger(BaseContorller.class);

	/**
	 * 功能：计算分页查询总页数
	 * 
	 * @param pageSize
	 * @param allRow
	 * @return
	 */
	protected long countTotalPage(int pageSize, long allRow) {
		long totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow
				/ pageSize + 1;
		return totalPage;
	}

}
