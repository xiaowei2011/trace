package com.trace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trace.dao.UserMapper;
import com.trace.model.User;


/** 
 * @author sunweijie 
 * @since 2017年3月13日 下午11:26:28
 */
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User get(Integer id){
		return userMapper.get(id);
	}
	
	public User getByOpenid(String openid){
		return userMapper.getByOpenid(openid);
	}
	
	public void insert(User user){
		userMapper.insert(user);
	}

	public void deleteByOpenId(String openid) {
		userMapper.deleteByOpenId(openid);
	}
}
