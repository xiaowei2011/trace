package com.trace.model.wechat;

import java.util.Arrays;

/** 
 * @author sunweijie 
 * @since 2017年3月12日 下午10:51:06
 */
public class Menu {
	
	private Button[] button;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	@Override
	public String toString() {
		return "Menu [button=" + Arrays.toString(button) + "]";
	}
	
}
