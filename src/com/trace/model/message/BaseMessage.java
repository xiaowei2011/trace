package com.trace.model.message;
/** 
 * @author sunweijie 
 * @since 2017年3月10日 下午8:06:28
 */
public class BaseMessage {
	
	private String ToUserName;
	private String FromUserName;
	private Long CreateTime;
	private String MsgType;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	@Override
	public String toString() {
		return "BaseMessage [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime
				+ ", MsgType=" + MsgType + "]";
	}
}
