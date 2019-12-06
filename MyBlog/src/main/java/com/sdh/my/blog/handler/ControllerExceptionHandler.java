package com.sdh.my.blog.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 1059133033@qq.com
 * @createdTime 2019年12月3日
 * @description 自定义异常
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception {
		log.error("Request URL : {},Exception : {}",request.getRequestURL(),e);
		
		//判断是否存在状态码
		if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
			throw e;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("url", request.getRequestURL());
		mv.addObject("exception", e);
		mv.setViewName("error/error");
		return mv;
	}
	
	
}
