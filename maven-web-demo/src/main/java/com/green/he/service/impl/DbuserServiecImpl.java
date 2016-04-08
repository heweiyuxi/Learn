package com.green.he.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.green.he.DAO.DbuserDAO;
import com.green.he.domain.Dbuser;
import com.green.he.service.DbuserService;

public class DbuserServiecImpl implements DbuserService {

//	@Resource(name="dao")
	private DbuserDAO dao;	
	
	public DbuserDAO getDao() {
		return dao;
	}

	public void setDao(DbuserDAO dao) {
		this.dao = dao;
	}

	public List<Dbuser> getDbuser() {
		return dao.getDbuser();
	}

}
