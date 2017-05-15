package com.trace.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trace.model.Admin;
import com.trace.model.Product;
import com.trace.service.AdminService;
import com.trace.service.ProductService;

@Controller
public class AdminProcess {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("toLogin")
	public ModelAndView toLogin(){
		return new ModelAndView("login");
	}
	
	@RequestMapping("login")
	public ModelAndView login(String account,String password,HttpSession session){
		Map<String, Object> map=new HashMap<>();
		Admin admin=adminService.get(account);
		if(admin==null){
			map.put("message","帐号不存在，请重新输入");
			return new ModelAndView("login",map);
		}
		if(!admin.getPassword().equals(password)){
			map.put("message","密码错误，请核对后再输入");
			return new ModelAndView("login",map);
		}
		session.setAttribute("admin", admin);
		List<Product> products=productService.getByAdmin(admin.getId());
		map.put("products", products);
		return new ModelAndView("productManage",map);
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(String url,HttpSession session){
		Map<String, Object> map=new HashMap<>();
		map.put("url", url);
		String status="操作成功!";
		String message="退出成功!";
		try{
			session.removeAttribute("admin");
		}catch(Exception e){
			status="操作失败!";
			message="退出失败!";
		}
		map.put("status", status);
		map.put("message", message);	
		return new ModelAndView("status",map);
	}
}
