package com.zss.test.controller;


import org.junit.Test;
import org.springframework.http.MediaType;

import com.zss.query.UserQuery;
import com.zss.test.base.BaseTest;
import com.zss.util.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserTest extends BaseTest {

    /*@Test
    public void login() throws Exception {
        UserQuery userQuery = new UserQuery();
        userQuery.setName("aaa");
        userQuery.setPwd("123");

        String json = JsonUtil.convertObjToStr(userQuery);
        mockMvc.perform((post("/user/login").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(json.getBytes()))).andExpect(status().isOk()).andDo(print());
    }*/

}
