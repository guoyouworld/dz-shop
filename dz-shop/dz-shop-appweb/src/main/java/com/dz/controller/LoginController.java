package com.dz.controller;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class LoginController {
	
	
	@RequestMapping(value="/auth/login", method = RequestMethod.GET)
	@ResponseBody
	public String test(HttpServletRequest request ,Model model) {
		Object username = request.getParameter("username");
		Object password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		return "success";
	}
	@RequestMapping(value="auth/login_by_weixin", method = RequestMethod.GET)
	@ResponseBody
	public String login_by_weixin(HttpServletRequest request ,Model model) {
		Object username = request.getParameter("username");
		Object password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		return "success";
	}
	@RequestMapping(value="/auth/login", method = RequestMethod.GET)
	@ResponseBody
	public String test(HttpServletRequest request ,Model model) {
		Object username = request.getParameter("username");
		Object password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		return "success";
	}
}
