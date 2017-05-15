package com.trace.model.message;

/** 
 * @author sunweijie 
 * @since 2017年3月6日 下午11:08:05
 */
public class TextMessage extends BaseMessage{
	
	private String Content;
	private long MsgId;
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	@Override
	public String toString() {
		return "TextMessage [Content=" + Content + ", MsgId=" + MsgId + "]";
	}
	
}
