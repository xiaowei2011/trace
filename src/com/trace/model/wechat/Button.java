package com.trace.model.wechat;

import java.util.Arrays;

/** 
 * @author sunweijie 
 * @since 2017年3月12日 下午10:47:20
 */
public class Button {
	
	private String name;
	private String type;
	private Button[] sub_button;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Button[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
	@Override
	public String toString() {
		return "Button [name=" + name + ", type=" + type + ", sub_button=" + Arrays.toString(sub_button) + "]";
	}
	
}
