package com.zss.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zss.query.UserQuery;
import com.zss.service.UserService;
import com.zss.test.base.BaseTest;

public class UserServiceTest extends BaseTest{

	@Autowired
	private UserService userService;
	
	@Test
	public void insertUser(){
		userService.insertUserByMybatis(new UserQuery("xulm","123456"));
	}
	
	@Test
	public void saveUser(){
		userService.insertUserByMybatis(new UserQuery("zss","123456"));
	}
}
