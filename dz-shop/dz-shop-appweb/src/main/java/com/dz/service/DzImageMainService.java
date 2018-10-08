package com.dz.service;


import java.util.ArrayList;

import com.dz.entity.DzImageMain;

public interface DzImageMainService {
	public DzImageMain getDzImageMainById(String img_id);
	public ArrayList<DzImageMain> getDzImageMainByCategory(String img_category);
	
}
