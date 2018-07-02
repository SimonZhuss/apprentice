package com.zillion.fund.test.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "/spring-context.xml"})
public class BaseTest {

	@Autowired  
    private WebApplicationContext wac; 
	
    public MockMvc mockMvc;  
  
    @Before  
    public void setup() {  
        //import 导入static的类
    	this.mockMvc = webAppContextSetup(this.wac).build();
    }
}
