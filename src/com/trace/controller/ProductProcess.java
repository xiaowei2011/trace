package com.trace.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trace.model.Admin;
import com.trace.model.Product;
import com.trace.service.ProductService;

@Controller
public class ProductProcess {
	
	@Autowired
	private ProductService productService;
	
	private DateFormat format=new SimpleDateFormat("yy-MM-dd");
	
	@RequestMapping("navigation")
	public ModelAndView navigation(){
		return new ModelAndView("navigation");
	}
	
	@RequestMapping("toProductDetail")
	public ModelAndView toProductDetail(Integer id){
		Product product=productService.get(id);
		return new ModelAndView("productDetail","product",product);
	}
	
	@RequestMapping("toIndex")
	public ModelAndView toIndex(){
		return new ModelAndView("index");
	}
	
	@RequestMapping("toProductManage")
	public ModelAndView toProductManage(HttpSession session){
		Admin admin=(Admin)session.getAttribute("admin");
		Map<String, Object> map=new HashMap<>();
		List<Product> products= productService.getByAdmin(admin.getId());
		map.put("products", products);
		return new ModelAndView("productManage",map);
	}
	
	@RequestMapping("toProductAdd")
	public ModelAndView toProductAdd(HttpSession session){
		return new ModelAndView("productAdd");
	}
	
	@RequestMapping("productAdd")
	public ModelAndView productAdd(Product product,String pickDateStr,String plantDateStr,
			HttpServletRequest request,HttpSession session){
		try{
			product.setPickDate(format.parse(pickDateStr));
		}catch(Exception e){}
		try{
			product.setPlantDate(format.parse(plantDateStr));
		}catch(Exception e){}
		Admin admin =(Admin)session.getAttribute("admin");
		productService.insert(product,admin.getId());
		try {
			Part file=request.getPart("img");
			String path=request.getServletContext().getRealPath("/")+"upload"+File.separator+"img";
			File dir=new File(path);
			if(!dir.exists())
				dir.mkdirs();
			String fileName=file.getHeader("content-disposition");
			fileName=fileName.substring(fileName.lastIndexOf("=")+2, fileName.length()-1);
			String suffix=fileName.substring(fileName.lastIndexOf("."));
			File img=new File(dir, "product_"+product.getId()+suffix);
			file.write(img.getPath());
			product.setImg(request.getContextPath()+File.separator+"upload"+File.separator+"img"
					+File.separator+img.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		productService.update(product);
		Map<String, Object> map=new HashMap<>();
		List<Product> products=productService.getByAdmin(admin.getId());
		map.put("products", products);
		return new ModelAndView("productManage",map);
	}
	
	@RequestMapping("toProductAlter")
	public ModelAndView toProductAlter(Integer id,HttpSession session){
		Map<String, Object> map=new HashMap<>();
		Product product=productService.get(id);
		map.put("product", product);
		return new ModelAndView("productAlter",map);
	}
	@RequestMapping("productAlter")
	public ModelAndView productAlter(Product product,HttpServletRequest request,
			String pickDateStr,String plantDateStr,HttpSession session){
		try{
			product.setPickDate(format.parse(pickDateStr));
		}catch(Exception e){}
		try{
			product.setPlantDate(format.parse(plantDateStr));
		}catch(Exception e){}
		try {
			Part file=request.getPart("img");
			String path=request.getServletContext().getRealPath("/")+"upload"+File.separator+"img";
			File dir=new File(path);
			if(!dir.exists())
				dir.mkdirs();
			String fileName=file.getHeader("content-disposition");
			fileName=fileName.substring(fileName.lastIndexOf("=")+2, fileName.length()-1);
			String suffix=fileName.substring(fileName.lastIndexOf("."));
			File img=new File(dir, "product_"+product.getId()+suffix);
			file.write(img.getPath());
			product.setImg(request.getContextPath()+File.separator+"upload"+File.separator+"img"
					+File.separator+img.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		productService.update(product);
		Map<String, Object> map=new HashMap<>();
		Admin admin =(Admin)session.getAttribute("admin");
		List<Product> products=productService.getByAdmin(admin.getId());
		map.put("products", products);
		return new ModelAndView("productManage",map);
	}
	
	@RequestMapping("productDelete")
	public ModelAndView productDelete(Integer id,HttpServletRequest request){
		Map<String, Object> map=new HashMap<>();
		String status="操作成功！";
		String message="删除成功！";
		String url="toProductManage.htm";
		try{
			Product product=productService.get(id);
			String img=product.getImg();
			if(img!=null){
				String dir=request.getServletContext().getRealPath("/")+"upload"+File.separator+"img";
				String fileName=img.substring(img.lastIndexOf("product_"));
				File file=new File(dir+File.separator+fileName);
				if(file.exists() && file.isFile())
					file.delete();
			}
			productService.delete(id);	
		}catch(Exception e){
			e.printStackTrace();
			status="操作失败！";
			message="删除失败！";
		}
		map.put("status", status);
		map.put("message", message);
		map.put("url", url);
		return new ModelAndView("status",map);
	}

}
