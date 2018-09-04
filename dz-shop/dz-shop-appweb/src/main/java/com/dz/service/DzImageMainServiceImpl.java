package com.dz.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dz.dao.DzImageMainDao;
import com.dz.entity.DzImageMain;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Service("KSellService") 
@ContextConfiguration({ "classpath:spring/spring-dao.xml" , "classpath:spring/spring-service.xml"})
public class DzImageMainServiceImpl implements DzImageMainService {
	@Autowired
    private DzImageMainDao ddao;
	
	@Override
	public DzImageMain getDzImageMainById(String img_id) {
		return ddao.getDzImageMainById(img_id);
	}

}
