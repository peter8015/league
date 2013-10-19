package com.league.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.base.platform.framework.web.orm.hibernate.HibernateEntityDao;
import com.league.project.dao.ProjectDao;
import com.league.project.model.ProjectBo;

@Repository("projectDao")
public class ProjectDaoImpl extends HibernateEntityDao<ProjectBo, Long>
implements ProjectDao{

}
