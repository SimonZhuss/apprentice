package com.zss.test.base;


public class SystemTest {

	private static SystemTest instant = new SystemTest();
	public static 	int count = 1;
	public static SystemTest getInstants(){
		return instant;
	}
	
	private SystemTest(){
		System.out.println(count);
	}
	public static void main(String[] args) {
		SystemTest.getInstants();
	}
}
