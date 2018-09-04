package com.dz.dao;

import org.apache.ibatis.annotations.Param;

import com.dz.entity.DzImageMain;

public interface DzImageMainDao {
	public DzImageMain getDzImageMainById(@Param("img_id") String img_id);
}
