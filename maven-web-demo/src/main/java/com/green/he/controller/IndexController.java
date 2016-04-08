package com.green.he.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HttpServletBean;

import com.gh.config.Config;
import com.green.he.DAO.DbuserDAO;
import com.green.he.DAO.impl.DbUserDAOImpl;
import com.green.he.base.TestGetDataSource;
import com.green.he.domain.User;
import com.green.he.service.DbuserService;
import com.green.he.service.impl.DbuserServiecImpl;

@Controller
@RequestMapping("/welcome")
public class IndexController {

	private static final Logger logger  = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(Model model){
		
		DbuserService userSercice = new DbuserServiecImpl();
//		userSercice.getDbuser();
		User user = new User("hewei","shenzheng");
		model.addAttribute("user",user);
		model.addAttribute("connection", null);
		//request.setAttribute("user", user);
		model.addAttribute("baseDir", Config.getBaseDir());
		logger.info("user");
		return "hello";
	}
	
}
