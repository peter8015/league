package com.base.platform.framework.security;

import java.util.LinkedHashMap;

import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.security.springsecurity.ResourceDetailsService;


/**
 * 从数据库查询URL--授权定义Map的实现类.
 */
@Transactional(readOnly = true)
public class ResourceDetailsServiceImpl implements ResourceDetailsService {

	public LinkedHashMap<String, String> getRequestMap() throws Exception {
		LinkedHashMap<String, String> requestMap = new LinkedHashMap<String, String>();
		return requestMap;
	}
}
