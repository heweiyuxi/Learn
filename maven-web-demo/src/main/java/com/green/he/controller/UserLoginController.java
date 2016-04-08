package com.green.he.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.he.DAO.DbuserDAO;
import com.green.he.DAO.impl.DbUserDAOImpl;
import com.green.he.domain.Dbuser;
import com.green.he.service.DbuserService;
import com.green.he.service.impl.DbuserServiecImpl;

@Controller
@RequestMapping(value="/User")
public class UserLoginController {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);	

	private DbuserService dbService;
	
	
	public DbuserService getDbService() {
		return dbService;
	}

	public void setDbService(DbuserService dbService) {
		this.dbService = dbService;
	}

	
	ApplicationContext context;

	@RequestMapping(value="/Login")
	public String userLogin(HttpServletRequest request,Model model,String name,String pwd){
		logger.info("++++++++++Start Login++++++");
		context = (ApplicationContext) request.getSession().getServletContext().getAttribute("org.springframework.web.context.WebApplicationContext.ROOT")  ;
		logger.info(context.toString());
		
		DbuserDAO dao = (DbuserDAO) context.getBean("dao");
//		dao.getDbuser();
		String username =request.getParameter("name");
		String password = request.getParameter("password");
//        dbService  = (DbuserService)context.getBean("dbService");
		
//		List<Dbuser> list = dbService.getDbuser();

        String name1 =request.getParameter("name");
        String password1 = request.getParameter("password");
		
		return "hello";
	}
	
}
