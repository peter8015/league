package com.base.oa.dao.system.impl;

/*
 *  
 *  
 */
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.base.oa.dao.system.CompanyDao;

public class CompanyDaoImplTest extends TestCase {

	private ApplicationContext factory = new ClassPathXmlApplicationContext(
			"conf/app-context.xml");
	private CompanyDao dao = (CompanyDao) factory.getBean("companyDao");

	public void testfindCompany() {
		System.out.println(dao.findCompany());
	}
	
	public void testa(){
		System.out.println("a");
	}

}
