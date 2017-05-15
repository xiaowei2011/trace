package com.trace.model.wechat;
/** 
 * @author sunweijie 
 * @since 2017年3月10日 下午10:33:59
 */
public class AccessToken {
	
	private static String token;
	private static int expresired;
	
	public static String getToken() {
		return token;
	}
	public static void setToken(String token) {
		AccessToken.token = token;
	}
	public static int getExpresired() {
		return expresired;
	}
	public static void setExpresired(int expresired) {
		AccessToken.expresired = expresired;
	}
	
}
