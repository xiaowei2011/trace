package com.trace.util.wechat;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trace.model.User;
import com.trace.model.wechat.AccessToken;

/** 
 * @author sunweijie 
 * @since 2017年3月10日 下午10:02:24
 */
public class WechatUtil {
	
	private static Logger logger = Logger.getLogger(WechatUtil.class);
	
	public static User getUserInfo(String openid){
		String token = AccessToken.getToken();
		String url = WechatUrl.GET_USER_INFO_URL.replace("ACCESS_TOKEN", token).replace("OPENID", openid);
		JSONObject jsonObject = doGet(url);
		User user = JSON.parseObject(jsonObject.toJSONString(),User.class);
		return user;
	}
	
	public static int deleteMenu(String token){
		int result = 0;
		String url = WechatUrl.DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGet(url);
		if(jsonObject != null){
			result = jsonObject.getIntValue("errcode");
		}
		return result;
	}
	
	public static JSONObject queryMenu(String token){
		String url = WechatUrl.QUERY_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGet(url);
		return jsonObject;
	}
	
	public static int createMenu(String menu,String token){
		int result = 0;
		String url = WechatUrl.CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPost(url, menu);
		if(jsonObject!=null){
			result = jsonObject.getIntValue("errcode");
		}
		return result;
	}
	
	public static JSONObject doGet(String url){
		HttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject =null;
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			if(entity != null){
				String result = EntityUtils.toString(entity,"UTF-8");
				jsonObject = JSON.parseObject(result);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return jsonObject;
	}
	
	public static JSONObject doPost(String url,String outStr){
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject =null;
		try {
			httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity entity = httpResponse.getEntity();
			if(entity != null){
				String result = EntityUtils.toString(entity,"UTF-8");
				jsonObject = JSON.parseObject(result);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return jsonObject;
	}
}
