package com.league.search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.platform.framework.web.orm.EntityDao;
import com.base.platform.framework.web.service.impl.GenericBaseManagerImpl;
import com.league.search.dao.SearchDao;
import com.league.search.model.SearchContentBo;
import com.league.search.service.SearchServiceFacade;

@Service("searchService")
public class SearchServiceImpl extends
		GenericBaseManagerImpl<SearchContentBo, Long> implements
		SearchServiceFacade {
	@Resource
	private SearchDao searchDao;

	@Override
	public boolean doDelete(List<Long> checkbox) throws Exception {
		if (checkbox != null && checkbox.size() > 0) {

			try {
				for (Long id : checkbox) {
					SearchContentBo myRecordBo = this.findEntityBeanById(id);
					searchDao.delete(myRecordBo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return true;
	}

	public List<SearchContentBo> pageOrQuery(int pageNo, int pageSize,
			SearchContentBo bo) {
		String hql = createOrHql(bo);
		return searchDao.doHqlPageQuery(hql, pageNo, pageSize);
	}

	public int queryOrRecordCount(SearchContentBo bo) {
		String hql = createOrCountHql(bo);
		return searchDao.queryRecordCount(hql);
	}

	private String createOrHql(SearchContentBo bo) {
		StringBuffer sb = new StringBuffer();
		sb.append("from SearchContentBo where 1!=1");
		if (bo != null) {
			if (bo.getId() != null) {
				sb.append(" or id=").append(String.valueOf(bo.getId()));
			}
			if (bo.getProjectName() != null && !"".equals(bo.getProjectName())) {
				sb.append(" or projectName like '%")
						.append(String.valueOf(bo.getProjectName()))
						.append("%'");
			}
			if (bo.getCardName() != null && !"".equals(bo.getCardName())) {
				sb.append(" or cardName like '%")
						.append(String.valueOf(bo.getCardName())).append("%'");
			}
			if (bo.getCardType() != null && !"".equals(bo.getCardType())) {
				sb.append(" or cardType like '%")
						.append(String.valueOf(bo.getCardType())).append("%'");
			}
		}
		sb.append(" order by id desc");
		return sb.toString();
	}

	private String createOrCountHql(SearchContentBo bo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(id) from SearchContentBo where 1!=1");
		if (bo != null) {
			if (bo.getId() != null) {
				sb.append(" or id=").append(String.valueOf(bo.getId()));
			}
			if (bo.getProjectName() != null && !"".equals(bo.getProjectName())) {
				sb.append(" or projectName like '%")
						.append(String.valueOf(bo.getProjectName()))
						.append("%'");
			}
			if (bo.getCardName() != null && !"".equals(bo.getCardName())) {
				sb.append(" or cardName like '%")
						.append(String.valueOf(bo.getCardName())).append("%'");
			}
			if (bo.getCardType() != null && !"".equals(bo.getCardType())) {
				sb.append(" or cardType like '%")
						.append(String.valueOf(bo.getCardType())).append("%'");
			}
		}
		return sb.toString();
	}

	@Override
	public EntityDao<SearchContentBo, Long> getEntityDao() {
		return searchDao;
	}

	@Override
	public List<SearchContentBo> pageQuery(int pageNo, int pageSize,
			SearchContentBo bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryRecordCount(SearchContentBo bo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
