package com.trace.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.trace.model.Admin;
import com.trace.service.AdminProductService;

public class AdminInterceptor implements HandlerInterceptor{
	
	@Autowired
	private AdminProductService adminProductService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try{
			//可读性略差，不好
			Admin admin;
			HttpSession session=request.getSession();
			if(session==null){
				request.setAttribute("message", "session失效，请重新登录");
				throw new Exception();
			}else if((admin=(Admin)session.getAttribute("admin"))==null){
				request.setAttribute("message", "登录后才能进行此操作");
				throw new Exception();
			}
			if(request.getParameterMap().containsKey("id") && adminProductService.get(admin.getId(), 
					Integer.parseInt(request.getParameter("id")))==null){
				request.setAttribute("message", "你不是该产品管理员，请重新登录！");
				throw new Exception();
			}
			return true;
		}catch(Exception e){}
		try {
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		} catch (Exception e) {}
		return false;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
}
