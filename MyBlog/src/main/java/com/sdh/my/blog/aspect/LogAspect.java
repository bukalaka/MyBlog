package com.sdh.my.blog.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 1059133033@qq.com
 * @createdTime 2019年12月3日
 * @description 
 */

@Slf4j
@Aspect
@Component
public class LogAspect {
	
	@Pointcut("execution(* com.sdh.my.blog.web.*.*(..))")
	public void log() {}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String url = request.getRequestURL().toString();
		String ip  = request.getRemoteAddr();
		String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
		log.info("RequestLog :{}", requestLog);
	}
	
	@After("log()")
	public void doAfter() {
		//log.info("------------doAfter-----------");
	}
	
	@AfterReturning(returning = "result", pointcut = "log()")
	public void doAfterReturning(Object result) {
		log.info("Result : {} " + result);
	}
	
	@SuppressWarnings("unused")
	private class RequestLog {
		private String url;
		private String ip;
		private String classMethod;	//请的哪个类的哪一个方法
		private Object[] args; //请求参数
		
		public RequestLog(String url, String ip, String classMethod, Object[] args) {
			super();
			this.url = url;
			this.ip = ip;
			this.classMethod = classMethod;
			this.args = args;
		}

		@Override
		public String toString() {
			return "RequestLog [url=" + url + ", ip=" + ip + ", classMethod=" + classMethod + ", args="
					+ Arrays.toString(args) + "]";
		}
		
		
		
	}

}
