package com.zillion.fund.test.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zillion.fund.ao.ProductAO;
import com.zillion.fund.client.JedisClient;
import com.zillion.fund.test.base.BaseTest;

public class ProductServceTest extends BaseTest{
	
	@Autowired
	private ProductAO productAO;
	

	@Test
	public  void redis() {
	}

}
