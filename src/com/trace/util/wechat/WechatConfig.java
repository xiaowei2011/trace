package com.trace.util.wechat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/** 
 * @author sunweijie 
 * @since 2017年3月14日 下午4:42:46
 */
public class WechatConfig {
	
	private static Logger logger = Logger.getLogger(WechatConfig.class);
	private static Properties wechatProperties;
	private static final String CONFIG_PATH = "/com/trace/config/wechat.properties";
	
	static {
		init();
	}
	
	private static void init() {
		InputStream inputStream = WechatConfig.class.getResourceAsStream(CONFIG_PATH);
		if(inputStream == null){
			logger.error("获取配置文件失败！");
			return;
		}
		try {
			wechatProperties = new Properties();
			wechatProperties.load(inputStream);
			logger.debug("wechat配置加载完成");
		} catch (IOException e) {
			logger.error(e);
		}
		if(inputStream != null){
			try {
				inputStream.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
	}
	
	public static String getToken(){
		return wechatProperties.getProperty("wechat.token");
	}
	
	public static String getOriginalId(){
		return wechatProperties.getProperty("wechat.originalid");
	}
	
	public static String getAppid(){
		return wechatProperties.getProperty("wechat.appid");
	}
	
	public static String getAppsecret(){
		return wechatProperties.getProperty("wechat.appsecret");
	}
}
