package com.league.myrecord.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.platform.framework.web.orm.EntityDao;
import com.base.platform.framework.web.service.impl.GenericBaseManagerImpl;
import com.league.myrecord.dao.MyRecordDao;
import com.league.myrecord.model.MyRecordBo;
import com.league.myrecord.service.MyRecordServiceFacade;

@Service("myRecordService")
public class MyRecordServiceImpl extends
		GenericBaseManagerImpl<MyRecordBo, Long> implements
		MyRecordServiceFacade {
	@Resource(name="myRecordDao")
	private MyRecordDao myRecordDao;

	@Override
	public boolean doDelete(List<Long> checkbox) throws Exception {
		if (checkbox != null && checkbox.size() > 0) {

			try {
				for (Long id : checkbox) {
					MyRecordBo myRecordBo = this.findEntityBeanById(id);
					myRecordDao.delete(myRecordBo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return true;
	}

	public List<MyRecordBo> pageQuery(int pageNo, int pageSize, MyRecordBo bo) {
		String hql = createHql(bo);
		return myRecordDao.doHqlPageQuery(hql, pageNo, pageSize);
	}

	public List<MyRecordBo> pageOrQuery(int pageNo, int pageSize, MyRecordBo bo) {
		String hql = createOrHql(bo);
		return myRecordDao.doHqlPageQuery(hql, pageNo, pageSize);
	}

	public int queryRecordCount(MyRecordBo bo) {
		String hql = createCountHql(bo);
		return myRecordDao.queryRecordCount(hql);
	}

	public int queryOrRecordCount(MyRecordBo bo) {
		String hql = createOrCountHql(bo);
		return myRecordDao.queryRecordCount(hql);
	}

	private String createHql(MyRecordBo bo) {
		StringBuffer sb = new StringBuffer();
		sb.append("from MyRecordBo where 1=1");
		if (bo != null) {
			if (bo.getId() != null) {
				sb.append(" and id=").append(String.valueOf(bo.getId()));
			}
			if (bo.getLoginName() != null && !"".equals(bo.getLoginName())) {
				sb.append(" and loginName=").append(
						String.valueOf(bo.getLoginName()));
			}
			if (bo.getTrueName() != null && !"".equals(bo.getTrueName())) {
				sb.append(" and trueName=").append(
						String.valueOf(bo.getTrueName()));
			}
			if (bo.getEmail() != null && !"".equals(bo.getEmail())) {
				sb.append(" and email=").append(String.valueOf(bo.getEmail()));
			}
			if (bo.getActivate() != null && !"".equals(bo.getActivate())) {
				sb.append(" and activate=").append(
						String.valueOf(bo.getActivate()));
			}
		}
		sb.append(" order by id desc");
		return sb.toString();
	}

	private String createOrHql(MyRecordBo bo) {
		StringBuffer sb = new StringBuffer();
		sb.append("from MyRecordBo where 1!=1");
		if (bo != null) {
			if (bo.getId() != null) {
				sb.append(" or id=").append(String.valueOf(bo.getId()));
			}
			if (bo.getLoginName() != null && !"".equals(bo.getLoginName())) {
				sb.append(" or loginName like '%").append(
						String.valueOf(bo.getLoginName())).append("%'");
			}
			if (bo.getTrueName() != null && !"".equals(bo.getTrueName())) {
				sb.append(" or trueName like '%").append(
						String.valueOf(bo.getTrueName())).append("%'");
			}
			if (bo.getEmail() != null && !"".equals(bo.getEmail())) {
				sb.append(" or email like '%").append(String.valueOf(bo.getEmail())).append("%'");
			}
			if (bo.getActivate() != null && !"".equals(bo.getActivate())) {
				sb.append(" or activate like '%").append(
						String.valueOf(bo.getActivate())).append("%'");
			}
		}
		sb.append(" order by id desc");
		return sb.toString();
	}

	private String createCountHql(MyRecordBo bo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(id) from MyRecordBo where 1=1");
		if (bo != null) {
			if (bo.getId() != null) {
				sb.append(" and id=").append(String.valueOf(bo.getId()));
			}
			if (bo.getLoginName() != null && !"".equals(bo.getLoginName())) {
				sb.append(" and loginName=").append(
						String.valueOf(bo.getLoginName()));
			}
			if (bo.getTrueName() != null && !"".equals(bo.getTrueName())) {
				sb.append(" and trueName=").append(
						String.valueOf(bo.getTrueName()));
			}
			if (bo.getEmail() != null && !"".equals(bo.getEmail())) {
				sb.append(" and email=").append(String.valueOf(bo.getEmail()));
			}
			if (bo.getActivate() != null && !"".equals(bo.getActivate())) {
				sb.append(" and activate=").append(
						String.valueOf(bo.getActivate()));
			}
		}
		return sb.toString();
	}

	private String createOrCountHql(MyRecordBo bo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(id) from MyRecordBo where 1!=1");
		if (bo != null) {
			if (bo.getId() != null) {
				sb.append(" or id=").append(String.valueOf(bo.getId()));
			}
			if (bo.getLoginName() != null && !"".equals(bo.getLoginName())) {
				sb.append(" or loginName like '%").append(
						String.valueOf(bo.getLoginName())).append("%'");
			}
			if (bo.getTrueName() != null && !"".equals(bo.getTrueName())) {
				sb.append("or trueName like '%").append(
						String.valueOf(bo.getTrueName())).append("%'");
			}
			if (bo.getEmail() != null && !"".equals(bo.getEmail())) {
				sb.append("or email like '%").append(String.valueOf(bo.getEmail())).append("%'");
			}
			if (bo.getActivate() != null && !"".equals(bo.getActivate())) {
				sb.append(" or activate like '%").append(
						String.valueOf(bo.getActivate())).append("%'");
			}
		}
		return sb.toString();
	}

	@Override
	public EntityDao<MyRecordBo, Long> getEntityDao() {
		// TODO Auto-generated method stub
		return myRecordDao;
	}

}
