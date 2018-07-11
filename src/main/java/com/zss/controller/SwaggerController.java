package com.zss.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zss.query.SwaggerQuery;
import com.zss.util.FastJsonUtil;
import com.zss.vo.ResponseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "Swagger测试控制器", description = "Swagger测试控制器")
@RestController
@RequestMapping(value = "/swg", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_UTF8_VALUE })
public class SwaggerController {

	@ApiOperation(value = "根据条件查询用户信息", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/queryByCondition", method = RequestMethod.POST)
	@ResponseBody
	public String queryByCondition(@RequestBody SwaggerQuery swaggerQuery) {
		return FastJsonUtil
				.convertObjToStr(new ResponseResult.ResponseResultBuilder<>().code("200").msg("success").build());
	}

}
