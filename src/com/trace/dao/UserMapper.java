package com.trace.dao;

import com.trace.model.User;

/** 
 * @author sunweijie 
 * @since 2017年3月13日 下午11:18:18
 */
public interface UserMapper {
	
	User get(Integer id);
	
	void insert(User user);

	void deleteByOpenId(String openid);

	User getByOpenid(String openid);
}
