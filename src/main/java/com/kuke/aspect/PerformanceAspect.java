package com.kuke.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.kuke.cache.service.ICacheService;
import com.kuke.util.JSONUtil;

@Aspect
@Component
public class PerformanceAspect implements Ordered{
	
	//@Around("execution(* com.kuke.*.service..*Service.*(..))")
	public Object arround(ProceedingJoinPoint joinPoint) throws Throwable{
		if(joinPoint.getTarget() instanceof ICacheService){
			return joinPoint.proceed();
		}
		String pointcut = joinPoint.getTarget().getClass().getName() + "#" + joinPoint.getSignature().getName() + "(" + JSONUtil.beanToJson(joinPoint.getArgs()) + ")";
		System.out.println("\n" + pointcut + " begin ");
		
		Long start = new Date().getTime();
		
		Object result = joinPoint.proceed(joinPoint.getArgs());
		
		Long end = new Date().getTime();
		Long duration = end - start;
		System.out.println(pointcut + " end 用时: " + duration + " ms");
		return result;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
