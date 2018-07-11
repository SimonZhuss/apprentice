package com.zss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zss.query.UserQuery;
import com.zss.query.ValidQuery;
import com.zss.service.UserService;
import com.zss.util.FastJsonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "用户控制器", description = "用户控制器")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "用户登录", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping("/login")
	public String login(@RequestBody UserQuery userQuery){
		return FastJsonUtil.convertObjToStr(userService.loginByTK(userQuery));
	}
	
	@RequestMapping("/valid")
	public String valid(@Validated @RequestBody ValidQuery validQuery) throws Exception{
		
		return "hello";
	}
}
