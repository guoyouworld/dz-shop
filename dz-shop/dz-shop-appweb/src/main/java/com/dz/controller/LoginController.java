package com.dz.controller;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class LoginController {
	
	
	@RequestMapping(value="/auth/login", method = RequestMethod.POST)
	@ResponseBody
	public String test(HttpServletRequest request ,Model model) {
		Object username = request.getParameter("username");
		Object password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		return "success";
	}
	@RequestMapping(value="/auth/login_by_weixin", method = RequestMethod.POST)
	@ResponseBody
	public String login_by_weixin(HttpServletRequest request ,Model model,@RequestBody String param ) {
		//因为'Content-Type': 'application/json',，所以request.getParameter这种方式无法获取值
		//@RequestParam用来处理ContentType: 为 application/x-www-form-urlencoded编码的内容
		//@RequestBody该注解常用来处理Content-Type: 不是application/x-www-form-urlencoded编码的内容，例如application/json, application/xml等；
		
		//Object code = request.getParameter("code");
		//Object userInfo = request.getParameter("userInfo");
		
		System.out.println(param);
		return "success";
	}
}
