package com.trace.dao;

import java.util.List;

import com.trace.model.Product;

public interface ProductMapper {
	
	Product get(Integer id);
	
	Integer insert(Product product);
	
	Integer insertList(List<Product> products);

	void update(Product product);

	List<Product> getByAdmin(Integer adminId);

	void delete(Integer id);
}
