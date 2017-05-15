package com.trace.service.wechat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trace.model.User;
import com.trace.service.UserService;
import com.trace.util.wechat.WechatUtil;

/** 
 * @author sunweijie 
 * @since 2017年3月14日 下午10:39:28
 */
@Service
public class SubscribeService {
	
	@Autowired
	private UserService userService;
	
	public String subscribe(String openId){
		User user = WechatUtil.getUserInfo(openId);
		userService.insert(user);
		return "关注成功";
	}
	
	public void unsubscribe(String openId){
		User user = WechatUtil.getUserInfo(openId);
		userService.deleteByOpenId(user.getOpenid());
	}
}
