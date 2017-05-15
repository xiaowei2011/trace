package com.trace.util.wechat;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.trace.model.wechat.AccessToken;

/** 
 * @author sunweijie 
 * @since 2017年3月15日 上午10:35:19
 */
public class AccessTokenThread implements Runnable {
	
	private static Logger logger = Logger.getLogger(AccessTokenThread.class);

	@Override
	public void run() {
		while(true){
			refreshAccessToken();
			try {
				Thread.sleep(115*60*1000);
			} catch (InterruptedException e) {
				logger.error(e);
			}
		}
	}
	
	public synchronized static void refreshAccessToken(){
		String url = WechatUrl.TOKEN_URL.replace("APPID", WechatConfig.getAppid())
				.replace("APPSECRET", WechatConfig.getAppsecret());
		while(true){
			JSONObject jsonObject = WechatUtil.doGet(url);
			if(jsonObject != null && jsonObject.getIntValue("errcode") == 0){
				AccessToken.setToken(jsonObject.getString("access_token"));
				AccessToken.setExpresired(jsonObject.getIntValue("expires_in"));
				if(logger.isDebugEnabled()){
					logger.debug("获取access_token成功，access_token:"+jsonObject.getString("access_token"));
				}
				break;
			}else{
				logger.error("获取access_token失败，errcode:"+jsonObject.getIntValue("errcode"));
			}
		}
	}
}
