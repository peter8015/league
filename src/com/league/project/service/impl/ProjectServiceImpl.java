package com.league.project.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.platform.framework.web.orm.EntityDao;
import com.base.platform.framework.web.service.impl.GenericBaseManagerImpl;
import com.league.notice.model.SsBankMsg;
import com.league.project.dao.ProjectDao;
import com.league.project.model.ProjectBo;
import com.league.project.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl extends GenericBaseManagerImpl<ProjectBo, Long>
implements ProjectService{
	@Resource(name = "projectDao")
	private ProjectDao projectDao;
	@Override
	public EntityDao<ProjectBo, Long> getEntityDao() {
		// TODO Auto-generated method stub
		return projectDao;
	}
	@Override
	public boolean doDelete(List<Long> paramList) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProjectBo> pageQuery(int pageNo, int pageSize, ProjectBo bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectBo> pageOrQuery(int pageNo, int pageSize, ProjectBo bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryRecordCount(ProjectBo bo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryOrRecordCount(ProjectBo bo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
}
