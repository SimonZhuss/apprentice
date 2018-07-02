package com.zss.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseResult<T> implements Serializable {
	private static final long serialVersionUID = -8063428306103890924L;
	private String code;
    private String msg;
    private T data;
    public static class ResponseResultBuilder<T>{
         	private ResponseResult<T> responseResult;
         	public ResponseResultBuilder(){       			 		   
         		this.responseResult = new ResponseResult<T>();
            } 
            public ResponseResultBuilder<T> code(String code){
                    this.responseResult.setCode(code);
                    return this;
            }
            public ResponseResultBuilder<T> msg(String msg){
                    this.responseResult.setMsg(msg);
                    return this;
            }
            public ResponseResultBuilder<T> data(T value){
                    this.responseResult.setData(value);
                    return this;
            }
            public ResponseResult<T> build(){
                    return this.responseResult;
            }
    }
}
