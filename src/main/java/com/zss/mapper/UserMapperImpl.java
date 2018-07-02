package com.zss.mapper;

import org.springframework.stereotype.Repository;

import com.zss.entity.UserEntity;

@Repository
public class UserMapperImpl extends MybatisBaseMapper implements UserMapper{

	public Long insertUser(UserEntity userEntity){
		return (long) getSqlSession().insert("insertUser", userEntity);
	}
}
