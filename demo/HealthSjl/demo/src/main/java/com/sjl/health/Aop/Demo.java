package com.sjl.health.Aop;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import com.sjl.health.entity.Result;


@Aspect
@Order(-99) // 控制多个Aspect的执行顺序，越小越先执行
@Component
public class Demo {
	
	private final static Logger logger = LoggerFactory.getLogger(Demo.class);
	
	/* @Around("execution(* com.sjl.health.controller..*.*(..))") */
	public Object aroundMethod(ProceedingJoinPoint joinPoint){
		
		Object result = null;
		String methodName = joinPoint.getSignature().getName();
		
		int i = 0;
		
		 //执行目标方法
		try {
			logger.info("获取AOP");
			//前置通知
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(joinPoint.getArgs()));	
			//用的最多 通知的签名
			Signature signature = joinPoint.getSignature();
			//AOP代理类的类（class）信息
			signature.getDeclaringType();
			//获取RequestAttributes
			RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
			//从获取RequestAttributes中获取HttpServletRequest的信息
			HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
			//代理的是哪一个方法
			System.out.println(signature.getName());
			//AOP代理类的名字
			System.out.println(signature.getDeclaringTypeName());
			//AOP代理类的类（class）信息
			signature.getDeclaringType();
			
			Enumeration<String> enumerationGetHeader = request.getHeaderNames();
			StringBuffer headers = new StringBuffer();
			while (enumerationGetHeader.hasMoreElements()) {
				String name = enumerationGetHeader.nextElement();
				String value = request.getHeader(name);
				headers.append(name + ":" + value).append(",");
			}
			System.out.println(headers);
			String uri = UUID.randomUUID() + "|" + request.getRequestURI();
			System.out.println(uri);
			//如果要获取Session信息的话，可以这样写：
			//HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
			
			//判断是否执行目标方法
			if(i != 0) {
//				Result rs = new Result();
//				rs.setError("您的Token已过期");
//				result = rs;
				return result;
			}else {
				//执行目标方法
				result = joinPoint.proceed();
				
			}
			//执行目标方法
			//result = joinPoint.proceed();
			//后置通知
			/* System.out.println("The method " + methodName + "  ends with " + result); */
		}catch (Throwable e) {
			//异常通知
			System.out.println("The method " + methodName + "  occurs exception: " + e);
			throw new RuntimeException(e);
		}
		//后置通知
		/*
		 * System.out.println("The method " + methodName + " ends");
		 * System.out.println(result);
		 */
		return result;
		
	}
	
	
}
