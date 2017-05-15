package com.trace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trace.dao.AdminProductMapper;
import com.trace.model.AdminProduct;

@Service
public class AdminProductService {
	
	@Autowired
	private AdminProductMapper adminProductMapper;
	
	public AdminProduct get(Integer adminId,Integer productId) {
		List<AdminProduct> list=adminProductMapper.get(adminId,productId);
		return list.size()>0?list.get(0):null;
	}
	
	public List<AdminProduct> getByAdminId(Integer adminId) {
		return adminProductMapper.get(adminId,null);
	}
	
	public List<AdminProduct> getByProductId(Integer productId) {
		return adminProductMapper.get(null,productId);
	}
	
	public Integer insert(AdminProduct adminProduct){
		return adminProductMapper.insert(adminProduct);
	}
	
	public Integer insert(List<AdminProduct> adminProducts){
		return adminProductMapper.insertList(adminProducts);
	}
}
