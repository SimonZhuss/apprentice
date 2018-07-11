package com.zss.query;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ValidQuery {
	
	@Range(min=1,max=2,message = "档案类型错误")
	private Integer archiveType;

	/**
	 * column:hs_archive_info.subject_name
	 * comment:档案主体名称
	 */
	@NotBlank(message = "档案主体名称不能为空")
	private String subjectName;
}
