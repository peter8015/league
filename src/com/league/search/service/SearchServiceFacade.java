package com.league.search.service;

import java.util.List;

import com.base.platform.framework.web.service.GenericBaseManager;
import com.league.search.model.SearchContentBo;

public interface SearchServiceFacade extends
		GenericBaseManager<SearchContentBo, Long> {

	public List<SearchContentBo> pageOrQuery(int pageNo, int pageSize,
			SearchContentBo bo);
}
