package com.trace.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.trace.model.Admin;
import com.trace.model.Product;
import com.trace.service.AdminService;
import com.trace.service.ProductService;

@Controller
public class GenerateCode {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private AdminService adminService;

	@RequestMapping("toGenerateCode")
	public ModelAndView toGenerateCode() {
		return new ModelAndView("generateCode");
	}

	@RequestMapping("generateCode")
	public void generateCode(String account, Integer amount, PrintWriter out) {
		JSONObject json = new JSONObject();
		Admin admin=adminService.get(account);
		boolean status = false;
		if(admin==null){
			json.put("message", "该管理员不存在，请核对后再输入!");
		}else{
			try {
				List<Product> products = new ArrayList<>();
				for (int i = 0; i < amount; i++) {
					products.add(new Product());
				}
				productService.insert(products, account);
				json.put("products", products);
				status = true;
			} catch (Exception e){
				json.put("message", "生成失败!");
			}
		}
		json.put("status", status);
		out.print(json);
	}
}
