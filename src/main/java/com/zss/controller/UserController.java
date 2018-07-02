package com.zss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zss.query.UserQuery;
import com.zss.service.UserService;
import com.zss.util.JsonUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(@RequestBody UserQuery userQuery){
		return JsonUtil.convertObjToStr(userService.loginByTK(userQuery));
	}
}
