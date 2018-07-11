package com.zss.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zss.vo.ResponseResult;
import com.zss.vo.RspCode;

import lombok.extern.slf4j.Slf4j;

/**
 * 自动捕捉异常
 * @author zhushanshan
 *
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	/**
	 * 系统异常
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseResult handleException(Exception e) throws ApprenticeException {
		ResponseResult r = new ResponseResult();
		r.setCode(RspCode.SYS_ERROR.getCode());
		r.setMsg(e.getMessage());
		log.info("ApprenticeException:"+e);
		return r;
	}

	/**
	 * 业务异常
	 */
	@ExceptionHandler(ApprenticeException.class)
	@ResponseBody
	public ResponseResult handleApprenticeException(ApprenticeException e) throws ApprenticeException {
		ResponseResult r = new ResponseResult();
		r.setCode(e.getCode());
		r.setMsg(e.getMsg());
		log.info("ApprenticeException:"+e);
		return r;
	}
	
	/**
	 * 验证异常
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.CHECKPOINT)
	@ResponseBody
	public ResponseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		ResponseResult r = new ResponseResult();
		BindingResult bindingResult = e.getBindingResult();
    	String errorMesssage = "校验失败:";
	    for (FieldError fieldError : bindingResult.getFieldErrors()) {
	        errorMesssage += fieldError.getDefaultMessage() + ", ";
	    }
	    r.setMsg(errorMesssage);
		log.info("MethodArgumentNotValidException:"+errorMesssage);
		return r;
	}
}
