package com.trace.interceptor;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
@Aspect
public class ExceptionProcessAspect {
	
	@Pointcut("execution(* com.trace.controller.*.*(..))")
	public void pointcut(){}
	
	@Around("pointcut()")
	public Object exceptionProcess(ProceedingJoinPoint point){
		try{
			return point.proceed();
		}catch(Throwable e){
			e.printStackTrace();
			System.out.println("exception");
		}
		Map<String, Object> map=new HashMap<>();
		map.put("status", "系统错误");
		map.put("message", "糟糕，系统出错，请稍后再试");
		return new ModelAndView("status", map);
	}
}
