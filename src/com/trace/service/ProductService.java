package com.trace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trace.dao.AdminMapper;
import com.trace.dao.AdminProductMapper;
import com.trace.dao.ProductMapper;
import com.trace.model.Admin;
import com.trace.model.AdminProduct;
import com.trace.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private AdminProductMapper adminProductMapper;
	
	@Autowired
	private AdminMapper adminMapper;
	
	public Product get(Integer id) {
		return productMapper.get(id);
	}
	
	public Integer insert(Product product){
		return productMapper.insert(product);
	}
	
	public Integer insert(List<Product> products){
		return productMapper.insertList(products);
	}
	
	@Transactional
	public void insert(List<Product> products, String admin) {
		productMapper.insertList(products);
		Admin ad=adminMapper.get(null, admin, null);
		List<AdminProduct> adminProducts=new ArrayList<>();
		for(Product product : products){
			AdminProduct adminProduct=new AdminProduct();
			adminProduct.setAdminId(ad.getId());
			adminProduct.setProductId(product.getId());
			adminProducts.add(adminProduct);
		}
		adminProductMapper.insertList(adminProducts);
	}
	
	@Transactional
	public void insert(Product product, Integer adminId) {
		productMapper.insert(product);
		AdminProduct adminProduct=new AdminProduct();
		adminProduct.setAdminId(adminId);
		adminProduct.setProductId(product.getId());
		adminProductMapper.insert(adminProduct);
	}

	public void update(Product product) {
		productMapper.update(product);
	}

	public List<Product> getByAdmin(Integer adminId) {
		return productMapper.getByAdmin(adminId);
	}

	public void delete(Integer id) {
		productMapper.delete(id);
	}
}
