package com.league.notice.dao.impl;

/**
 * <p/> Persistence manager which provides basic CRUD operations
 * 
 * @author Pan,Shaohua 
 * @date 2011.09.29
 */

import org.springframework.stereotype.Repository;

import com.base.platform.framework.web.orm.hibernate.HibernateEntityDao;
import com.league.notice.dao.ISsBankMsgDao;
import com.league.notice.model.SsBankMsg;

@Repository("mssBankMsgDao")
public class MSsBankMsgDao extends HibernateEntityDao<SsBankMsg, Long>
		implements ISsBankMsgDao {

}
