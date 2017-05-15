package com.trace.model.wechat;
/** 
 * @author sunweijie 
 * @since 2017年3月12日 下午10:50:00
 */
public class ViewButton extends Button {
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ViewButton [url=" + url + "]";
	}
	
}
