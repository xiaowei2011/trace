package com.trace.controller.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trace.model.User;
import com.trace.model.message.TextMessage;
import com.trace.service.UserService;
import com.trace.service.wechat.SubscribeService;
import com.trace.util.wechat.AccessTokenThread;
import com.trace.util.wechat.Encode;
import com.trace.util.wechat.MessageUtil;
import com.trace.util.wechat.WechatConfig;

/** 
 * @author sunweijie 
 * @since 2017年3月14日 下午4:38:35
 */
@Controller
public class WechatController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = Logger.getLogger(WechatController.class);
	
	public WechatController() {
		new Thread(new AccessTokenThread()).start();
	}
	
	@Autowired
	private SubscribeService subscribeService;
	
	@RequestMapping(value = "wechat", method = RequestMethod.GET)
	public void doGet(String signature, String timestamp, String nonce, String echostr, PrintWriter out){
		String[] array = new String[]{WechatConfig.getToken(), timestamp, nonce};
		Arrays.sort(array);
		StringBuffer content = new StringBuffer();
		for(int i = 0; i < array.length; i++){
			content.append(array[i]);
		}
		String str = Encode.getSHA1(content.toString());
		if(signature.equals(str)){
			out.print(echostr);
		}
	}
	
	@RequestMapping(value = "wechat", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, PrintWriter out) throws IOException, DocumentException{
		Map<String, String> map = MessageUtil.xmlToMap(request);
		String msgType = map.get("MsgType");
		TextMessage message = new TextMessage();
		message.setToUserName(map.get("FromUserName"));
		message.setFromUserName(map.get("ToUserName"));
		message.setCreateTime(new Date().getTime());
		message.setMsgType("text");
		if("text".equals(msgType)){
			message.setContent("text");
			out.print(MessageUtil.textMessageToXml(message));
		}else if("event".equals(msgType)){
			String event = map.get("Event");
			if("CLICK".equals(event)){
				message.setContent("CLICK");
				out.print(MessageUtil.textMessageToXml(message));
			}else if("VIEW".equals(event)){
				HttpSession session = request.getSession(false);
				if(session == null){
					session = request.getSession(true);
				}
				User user = (User)session.getAttribute("user");
				if(user == null){
					user = userService.getByOpenid(map.get("FromUserName"));
					logger.debug(user);
					session.setAttribute("user", user);
				}
			}else if("scancode_waitmsg".equals(event)){
				
			}else if("subscribe".equals(event)){
				String content=subscribeService.subscribe(map.get("FromUserName"));
				message.setContent(content);
				logger.debug(MessageUtil.textMessageToXml(message));
				out.print(MessageUtil.textMessageToXml(message));
			}else if("unsubscribe".equals(event)){
				subscribeService.unsubscribe(map.get("FromUserName"));
			}else{
				message.setContent("else event");
				out.print(MessageUtil.textMessageToXml(message));
			}
		}else if("location".equals(msgType)){
			message.setContent("location");
			out.print(MessageUtil.textMessageToXml(message));
		}else{
			message.setContent("else");
			out.print(MessageUtil.textMessageToXml(message));
		}
	}
}
