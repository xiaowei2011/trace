package com.trace.util.wechat;

import com.alibaba.fastjson.JSON;
import com.trace.model.wechat.AccessToken;
import com.trace.model.wechat.Button;
import com.trace.model.wechat.ClickButton;
import com.trace.model.wechat.Menu;
import com.trace.model.wechat.ViewButton;

/** 
 * @author sunweijie 
 * @since 2017年3月15日 上午9:57:34
 */
public class MenuUtil {
	
	public static void main(String[] args){
		System.out.println("开始创建菜单");
		Menu menu = initMenu();
		String menuStr = JSON.toJSONString(menu);
		AccessTokenThread.refreshAccessToken();
		int result = WechatUtil.createMenu(menuStr, AccessToken.getToken());
		System.out.println(result == 0 ? "创建成功" : "创建失败");
//		JSONObject jsonObject = WechatUtil.queryMenu(AccessToken.getToken());
//		System.out.println(jsonObject);
	}
	
	public static Menu initMenu() {
		ViewButton button11 = new ViewButton();
		button11.setName("产品管理");
		button11.setType("view");
		button11.setUrl("manage");
		ClickButton button21 = new ClickButton();
		button21.setName("扫一扫");
		button21.setType("scancode_push");
		button21.setKey("scancode");
		Menu menu = new Menu();
		menu.setButton(new Button[]{button11,button21});
		return menu;
	}
}
