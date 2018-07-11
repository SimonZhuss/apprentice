package com.zss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.zss.dao.UserDao;
import com.zss.entity.UserEntity;
import com.zss.exception.ApprenticeException;
import com.zss.mapper.UserMapper;
import com.zss.query.UserQuery;
import com.zss.query.ValidQuery;
import com.zss.repository.UserRepository;
import com.zss.service.UserService;
import com.zss.vo.ResponseResult;
import com.zss.vo.RspCode;
import com.zss.vo.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao; //采用TX组件进行的mybatis
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseResult<UserDTO> loginByTK(UserQuery userQuery) {
		log.info(">>>>>用户登录  || userQuery :{}",userQuery);
		UserEntity ue = userDao.selectOne(new UserEntity(null,userQuery.getName(),userQuery.getPwd()));
		ResponseResult.ResponseResultBuilder<UserDTO> result = new ResponseResult.ResponseResultBuilder<>();
		if(ue == null) return result.code("400").msg("failed").build();
		return result.code("200").msg("success").build();
	}

	@Override
	public ResponseResult insertUserByMybatis(UserQuery userQuery) {
		log.info(">>>>>添加用户  || userQuery :{}",userQuery);
		Long s = userMapper.insertUser(new UserEntity(null,userQuery.getName(),userQuery.getPwd()));
		ResponseResult.ResponseResultBuilder<UserDTO> result = new ResponseResult.ResponseResultBuilder<>();
		if(result == null || s != 1) return result.code("400").msg("failed").build();
		return result.code("200").msg("success").build();
	}

	@Override
	public ResponseResult saveUserByJPA(UserQuery userQuery) {
		log.info(">>>>>添加用户  || userQuery :{}",userQuery);
		UserEntity s = userRepository.save(new UserEntity(null,userQuery.getName(),userQuery.getPwd()));
		ResponseResult.ResponseResultBuilder<UserDTO> result = new ResponseResult.ResponseResultBuilder<>();
		if(result == null ) return result.code("400").msg("failed").build();
		return result.code("200").msg("success").build();
	}

	@Override
	public ResponseResult valid(@RequestBody @Validated ValidQuery validQuery) throws Exception {
		//throw new Exception(RspCode.SYS_ERROR.getMessage());
		return null;
	}
}
