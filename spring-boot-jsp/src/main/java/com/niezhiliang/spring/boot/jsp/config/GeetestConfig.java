package com.niezhiliang.spring.boot.jsp.config;

/**
 * GeetestWeb配置文件
 * 
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String geetest_id = "2bb0f4e9d5f05124fae8e7173f18f092";
	private static final String geetest_key = "2cc1b83ce184adab1fe0f674bccdd6e1";
	private static final boolean newfailback = true;

	public static final String getGeetest_id() {
		return geetest_id;
	}

	public static final String getGeetest_key() {
		return geetest_key;
	}
	
	public static final boolean isnewfailback() {
		return newfailback;
	}

}
