package com.trace.dao;

import org.apache.ibatis.annotations.Param;

import com.trace.model.Admin;

public interface AdminMapper {
	
	Admin get(@Param("id")Integer id,@Param("account")String account,@Param("password")String password);
	
	Integer insert(Admin admin);
}
