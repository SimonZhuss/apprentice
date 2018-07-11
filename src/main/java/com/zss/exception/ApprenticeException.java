package com.zss.exception;

import com.zss.vo.RspCode;

/**
 * 自定义异常
 * @author zhushanshan
 *
 */
public class ApprenticeException extends RuntimeException{
	private static final long serialVersionUID = -8527322122885582644L;
	private String code;
    private String msg;

    public ApprenticeException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApprenticeException(String message) {
        super(message);
        this.msg = message;
    }
    
    public ApprenticeException(RspCode rspCode) {
    	this.code = rspCode.getCode();
        this.msg = rspCode.getMessage();
    }

    public ApprenticeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApprenticeException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
