package com.league.notice.service.impl;

/**
 * <p/> NoticeServiceImpl manager which provides basic CRUD operations
 * 
 */

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.platform.framework.web.orm.EntityDao;
import com.base.platform.framework.web.service.impl.GenericBaseManagerImpl;
import com.league.notice.dao.impl.MSsBankMsgDao;
import com.league.notice.model.SsBankMsg;
import com.league.notice.service.ISsBankMsgService;

/**
 * @Author pan,shaohua
 * @date 2011.10.10
 */
@Service("ssBankMsgService")
public class SsBankMsgService extends GenericBaseManagerImpl<SsBankMsg, Long>
		implements ISsBankMsgService {

	@Resource(name = "mssBankMsgDao")
	private MSsBankMsgDao mssBankMsgDao;

	@Override
	public EntityDao<SsBankMsg, Long> getEntityDao() {
		// TODO Auto-generated method stub
		return mssBankMsgDao;
	}

	@Override
	public boolean doDelete(List<Long> checkbox) throws Exception {
		// TODO Auto-generated method stub
		if (checkbox != null && checkbox.size() > 0) {
			try {
				for (Long id : checkbox) {
					SsBankMsg govDjgzBo = this.findEntityBeanById(id);
					mssBankMsgDao.delete(govDjgzBo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			    super.logger.error(e.getMessage());
				throw new Exception(e);
			}
		}
		return true;

	}

	public List<SsBankMsg> pageQuery(int pageNo, int pageSize, SsBankMsg bo) {
		String hql = createHql(bo);
		return mssBankMsgDao.pageQuery(hql, pageNo, pageSize);
	}

	public List<SsBankMsg> pageOrQuery(int pageNo, int pageSize, SsBankMsg bo) {
		String hql = createOrHql(bo);
		return mssBankMsgDao.pageQuery(hql, pageNo, pageSize);
	}

	public int queryRecordCount(SsBankMsg bo) {
		String hql = createCountHql(bo);
		return mssBankMsgDao.queryRecordCount(hql);
	}

	public int queryOrRecordCount(SsBankMsg bo) {
		String hql = createOrCountHql(bo);
		return mssBankMsgDao.queryRecordCount(hql);
	}

	private String createHql(SsBankMsg bo) {
		StringBuffer sb = new StringBuffer();
		sb.append("from SsBankMsg where 1=1");
		if (bo != null) {
			if (bo.getId() != null) {
				sb.append(" and id=").append(String.valueOf(bo.getId()));
			}
			if (bo.getDjgzContent() != null && !"".equals(bo.getDjgzContent())) {
				sb.append(" and djgzContent='")
						.append(String.valueOf(bo.getDjgzContent()))
						.append("'");
			}
			if (bo.getDjgzName() != null && !"".equals(bo.getDjgzName())) {
				sb.append(" and djgzName='")
						.append(String.valueOf(bo.getDjgzName())).append("'");
			}

		}
		sb.append(" order by id desc");
		return sb.toString();
	}

	private String createOrHql(SsBankMsg bo) {
		StringBuffer sb = new StringBuffer();
		sb.append("from SsBankMsg where 1!=1");
		if (bo != null) {
			if (bo.getId() != null) {
				sb.append(" or id=").append(String.valueOf(bo.getId()));
			}

		}
		sb.append(" order by id desc");
		return sb.toString();
	}

	private String createCountHql(SsBankMsg bo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(id) from SsBankMsg where 1=1");
		if (bo != null) {
			if (bo.getId() != null) {
				sb.append(" and id=").append(String.valueOf(bo.getId()));
			}

		}
		return sb.toString();
	}

	private String createOrCountHql(SsBankMsg bo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(id) from SsBankMsg where 1!=1");
		if (bo != null) {
			if (bo.getId() != null) {
				sb.append(" or id=").append(String.valueOf(bo.getId()));
			}

		}
		return sb.toString();
	}

}
