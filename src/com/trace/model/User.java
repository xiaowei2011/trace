package com.trace.model;

/** 
 * @author sunweijie 
 * @since 2017年3月13日 下午10:59:16
 */
public class User {
	
	private Integer id;
	private String openid;
	private String nickname;
	private Integer sex;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", openid=" + openid + ", nickname=" + nickname + ", sex=" + sex + "]";
	}
	
}
