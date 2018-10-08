package com.dz.service;

import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dz.dao.DzImageHostDao;
import com.dz.entity.DzImageHost;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Service("DzImageHostService") 
@ContextConfiguration({ "classpath:spring/spring-dao.xml" , "classpath:spring/spring-service.xml"})
public class DzImageHostServiceImpl implements DzImageHostService {
	@Autowired
    private DzImageHostDao hdao;

	@Override
	public ArrayList<DzImageHost> getAllDzImageHost() {
		return hdao.getAllDzImageHost();
	}
	

}
