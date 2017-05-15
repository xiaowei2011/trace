package com.trace.model.wechat;
/** 
 * @author sunweijie 
 * @since 2017年3月12日 下午10:48:54
 */
public class ClickButton extends Button {
	
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "ClickButton [key=" + key + "]";
	}
	
}
