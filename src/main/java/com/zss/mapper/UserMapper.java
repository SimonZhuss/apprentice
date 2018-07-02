package com.zss.mapper;

import com.zss.entity.UserEntity;

//传统的mybatis连接
public interface UserMapper {

	Long insertUser(UserEntity userEntity);
}
