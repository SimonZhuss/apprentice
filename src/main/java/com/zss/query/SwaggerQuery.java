package com.zss.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaggerQuery {

	@ApiModelProperty(value="姓名")
    private String name;
	
	@ApiModelProperty(value="地址")
	private String address; 
}
