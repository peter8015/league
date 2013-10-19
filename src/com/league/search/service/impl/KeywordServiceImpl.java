package com.league.search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.platform.framework.web.orm.EntityDao;
import com.base.platform.framework.web.service.impl.GenericBaseManagerImpl;
import com.league.search.dao.KeywordDao;
import com.league.search.model.KeywordBo;
import com.league.search.service.KeywordServiceFacade;

@Service("keywordService")
public class KeywordServiceImpl extends GenericBaseManagerImpl<KeywordBo, Long>
		implements KeywordServiceFacade {
	@Resource
	private KeywordDao keywordDao;

	@Override
	public boolean doDelete(List<Long> checkbox) throws Exception {
		if (checkbox != null && checkbox.size() > 0) {

			try {
				for (Long id : checkbox) {
					KeywordBo myRecordBo = this.findEntityBeanById(id);
					keywordDao.delete(myRecordBo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return true;
	}

	@Override
	public EntityDao<KeywordBo, Long> getEntityDao() {
		return keywordDao;
	}

	@Override
	public List<KeywordBo> pageQuery(int pageNo, int pageSize, KeywordBo bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KeywordBo> pageOrQuery(int pageNo, int pageSize, KeywordBo bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryRecordCount(KeywordBo bo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryOrRecordCount(KeywordBo bo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
