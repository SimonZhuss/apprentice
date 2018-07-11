package com.zss.test.controller;


import org.junit.Test;
import org.springframework.http.MediaType;

import com.zss.query.UserQuery;
import com.zss.query.ValidQuery;
import com.zss.test.base.BaseTest;
import com.zss.util.FastJsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserTest extends BaseTest {

    @Test
    public void login() throws Exception {
        UserQuery userQuery = new UserQuery();
        userQuery.setName("aaa");
        userQuery.setPwd("123");

        String json = FastJsonUtil.convertObjToStr(userQuery);
        mockMvc.perform((post("/user/login").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(json.getBytes()))).andExpect(status().isOk()).andDo(print());
    }
    
    @Test
    public void valid() throws Exception {
    	ValidQuery validQuery = new ValidQuery();
    	validQuery.setSubjectName("");

        String json = FastJsonUtil.convertObjToStr(validQuery);
        mockMvc.perform((post("/user/valid").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(json.getBytes()))).andExpect(status().isOk()).andDo(print());
    }

}
