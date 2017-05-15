 package com.trace.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.trace.model.AdminProduct;

public interface AdminProductMapper {
	
	List<AdminProduct> get(@Param("adminId")Integer adminId,@Param("productId")Integer productId);
	
	Integer insert(AdminProduct adminProduct);
	
	Integer insertList(List<AdminProduct> adminProducts);
}
