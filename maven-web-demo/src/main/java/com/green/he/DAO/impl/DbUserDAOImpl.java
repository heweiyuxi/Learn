package com.green.he.DAO.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;





import javax.annotation.Resource;







import com.green.he.DAO.DbuserDAO;
import com.green.he.domain.Dbuser;

public class DbUserDAOImpl  implements DbuserDAO {

	private static final Logger logger = LoggerFactory.getLogger(DbUserDAOImpl.class);	
	
	public DbUserDAOImpl(){};
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	/*@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	*/	
	
	public List<Dbuser> getDbuser(){
		String hsql="from Dbuser";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hsql);
		
		return query.list();
	}

}
