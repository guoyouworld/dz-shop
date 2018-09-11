package com.dz.dao;

import org.apache.ibatis.annotations.Param;

import com.dz.entity.TokenEntity;

/**
 * 用户Token
 */
public interface ApiTokenMapper extends BaseDao<TokenEntity> {

    TokenEntity queryByUserId(@Param("userId") Long userId);

    TokenEntity queryByToken(@Param("token") String token);

}
