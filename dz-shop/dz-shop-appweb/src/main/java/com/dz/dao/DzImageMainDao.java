package com.dz.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.dz.entity.DzImageMain;

public interface DzImageMainDao {
	public DzImageMain getDzImageMainById(@Param("img_id") String img_id);
	public ArrayList<DzImageMain> getDzImageMainByCategory(@Param("img_category") String img_category);
}
