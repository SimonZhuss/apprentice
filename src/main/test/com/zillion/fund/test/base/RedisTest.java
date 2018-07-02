package com.zillion.fund.test.base;

import org.junit.Test;

import com.zillion.fund.client.JedisClient;

public class RedisTest {
	
	@Test
	public void writeValue(){
		System.out.println(JedisClient.getInstance().setCacheString("test_fund","hi,hi",60));
	}

	@Test
	public void readValue(){
		System.out.println(JedisClient.getInstance().getCacheString("test_fund"));
	}
}
