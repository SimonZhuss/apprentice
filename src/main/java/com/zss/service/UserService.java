package com.zss.service;

import com.zss.query.UserQuery;
import com.zss.query.ValidQuery;
import com.zss.vo.ResponseResult;
import com.zss.vo.UserDTO;

public interface UserService {

	ResponseResult<UserDTO> loginByTK(UserQuery userQuery);
	
	ResponseResult insertUserByMybatis(UserQuery userQuery);
	
	ResponseResult saveUserByJPA(UserQuery userQuery);
	
	ResponseResult valid(ValidQuery validQuery) throws Exception;
}
