package com.trace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trace.dao.AdminMapper;
import com.trace.model.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public Admin get(Integer id) {
		return adminMapper.get(id,null,null);
	}
	
	public Admin get(String account) {
		return adminMapper.get(null,account,null);
	}
	
	public Admin get(String account,String password) {
		return adminMapper.get(null,account,password);
	}
	
	public Integer insert(Admin admin){
		return adminMapper.insert(admin);
	}
}
