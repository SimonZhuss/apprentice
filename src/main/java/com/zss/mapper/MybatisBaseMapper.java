package com.zss.mapper;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;


public class MybatisBaseMapper extends SqlSessionDaoSupport {
	
	@Resource
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
      		super.setSqlSessionTemplate(sqlSessionTemplate);
    }
	
}
