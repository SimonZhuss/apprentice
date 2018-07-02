package com.zillion.fund.test.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.alibaba.fastjson.JSONObject;

public class FundTest {
	/**
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param params
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的HTML
	 */
	public static String doPost(String url, Map<String, String> params,
			String charset, boolean pretty) {
		StringBuffer response = new StringBuffer();
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		// 设置Http Post数据
		if (params != null) {
			NameValuePair[] nameValuePairs = new NameValuePair[params.size()];
			Set<Entry<String, String>> set = params.entrySet();
			int i = 0;
			// 设置查询参数
			for (Entry<String, String> entry : set) {
			   NameValuePair pair = new NameValuePair(entry.getKey(),entry.getValue());
			   nameValuePairs[i] = pair;
			   i++;
			}
			// 发送参数包
			method.setRequestBody(nameValuePairs);
		}
		try {
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(method.getResponseBodyAsStream(),
								charset));
				String line;
				while ((line = reader.readLine()) != null) {
					if (pretty)
						response.append(line).append(
								System.getProperty("line.separator"));
					else
						response.append(line);
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return response.toString();
	}

	public static void main(String[] args) {
		/*
		 * 系统参数
		 */
		String url = "http://cljj.kmdns.net:81/partner/accountHandler.go"; //帐户类接口
		String method = "cljj.account.create"; //请求方法：开户
		String v = "1.1"; //版本号
		String app_key = "yaowang"; //分配给合作方的AppKey
		String secret_key = "5d05427d31e747d4f7afc5757b47d339"; //私钥
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //请求时间
		String timestamp = sf.format(new Date()); //"2015-07-23 16:07:00"
		String sign = ""; //签名
		
		/*
		 * 应用参数
		 */
		String partner_user_id = "050502"; //渠道用户ID
		String idno = "33072219510409671X"; //身份证号
		String name = "李金暖"; //姓名
		String mobile = "13988888886"; //手机号
		String email = "test8002@t.cn"; //邮箱
		String tpwd = "888888"; //密码
		
		JSONObject json = new JSONObject();
		json.put("investor_name", name);
		json.put("identity_no", idno);
		json.put("mobile", mobile);
		json.put("e_mail", email);
		json.put("trade_pwd", tpwd);
		json.put("partner_user_id", partner_user_id);
		
		String data = json.toString();
		try {
			data = URLEncoder.encode(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>应用参数      ："+data);
		
		//系统
		StringBuffer sb = new StringBuffer();
		sb.append(secret_key);
		sb.append("app_key");
		sb.append(app_key);
		sb.append("method");
		sb.append(method);
		sb.append("timestamp");
		sb.append(timestamp);
		sb.append("v");
		sb.append(v);
		
		JSONObject injson = JSONObject.parseObject(data);
		for (Iterator<String> iter = (Iterator<String>) injson.entrySet(); iter.hasNext();) { 
		    String key = iter.next(); 
		    sb.append(key);
		    sb.append(json.getString(key));
		}
		sb.append(secret_key);
		
		//参数拼接
		String dSign = "";
		try {
			dSign = URLEncoder.encode(sb.toString(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("dSign:" + dSign);
		sign = org.apache.commons.codec.digest.DigestUtils.md5Hex(dSign).toUpperCase();
		System.out.println("sign="+sign);
		
		Map<String, String> params = new HashMap<String,String>();
		params.put("timestamp", timestamp);
		params.put("app_key", app_key);
		params.put("from_channel", "");
		params.put("method", method);
		params.put("v", v);
		params.put("sign", sign);
		params.put("data", data);
		String result = doPost(url, params,"UTF-8",true);
		System.out.println("result:" + result);
		
	}
}
