package com.dz.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dz.entity.DzImageHost;
import com.dz.entity.DzImageMain;
import com.dz.service.DzImageHostService;
import com.dz.service.DzImageMainService;

@Controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class MainController {
	
	protected Logger logger = Logger.getLogger(getClass());
	@Autowired
	private DzImageMainService dService;
	@Autowired
	private DzImageHostService hService;
	/**
	 * 
	 * <pre>
	 * Example: 
	 * Description: 返回首页顶部轮播图url集合，json格式
	 * Arguments: 
	 * Return: String
	 * Variable：
	 * </pre>
	 */
	@RequestMapping(value="/main/slideshow")
	@ResponseBody
	public ArrayList<DzImageMain> slideshow(HttpServletRequest request ,Model model) {
		//ArrayList<String> result =  new ArrayList<String>();
		ArrayList<DzImageMain> slideshow = dService.getDzImageMainByCategory("1");
		if(slideshow.size()>0) {
			ArrayList<DzImageHost> allDzImageHost = hService.getAllDzImageHost();
			if(allDzImageHost.size()>0) {
				int index=(int)(Math.random()*allDzImageHost.size());
				DzImageHost dzImageHost = allDzImageHost.get(index);
				for(DzImageMain imageMain :slideshow) {
					String url="http://"+dzImageHost.getHostUrl()+imageMain.getImgUrl();
					imageMain.setImgUrl(url);
					//result.add(url);
				}
			}
		}
		return slideshow;
	}
	
}
