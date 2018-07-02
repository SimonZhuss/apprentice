package com.zss.test.base;


public class SystemTest {

	public static void main(String[] args) {
		String t = "123456";
		char[] ts = t.toCharArray();
		long result = 0;
		for(int i = 0;i<ts.length;i++){
			long a = ts[i]- '0';//不能直接转化,那样得到是Ascii，直接后面-'0'
			result += a*Math.pow(10,ts.length-i-1); 
		}
		System.out.println(result);
	}
}
