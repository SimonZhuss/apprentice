package com.zss.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class UserQuery {
	
	@ApiModelProperty(value="姓名")
	private String name;
	
	@ApiModelProperty(value="密码")
	private String pwd;
}
