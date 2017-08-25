package com.kuke.aspect;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.kuke.cache.annotation.OneKeyCache;
import com.kuke.cache.service.ICacheService;

@Aspect
@Component
public class OneKeyAspect extends BaseAspect implements Ordered{
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ICacheService cacheService;

	@Around("@annotation(com.kuke.cache.annotation.OneKeyCache)")
	public Object oneKeyCache(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		String keyPrefix = getKeyPrefix(method);
		String cacheName = getCacheName(method);
		if(StringUtils.isBlank(cacheName)){
			cacheName = "tempCache";
		}
		
		Object targetId = args[0];
		Object cacheKey = getKey(keyPrefix, targetId);
		boolean hit = cacheService.isKeyInCache(cacheName, cacheKey);
		if(!hit){
			Object target = joinPoint.proceed(args);
			cacheService.put(cacheName, cacheKey, target);
			logger.debug("cache data key " + cacheKey);
		}
		else{
			logger.debug("Cache " + cacheName + " hit, cache key is " + cacheKey);
		}
		
		Object result = cacheService.get(cacheName, cacheKey);
		return result;
	}
	
	@Override
	protected String getCacheName(Method method) {
		OneKeyCache cache = method.getAnnotation(OneKeyCache.class);
		String cacheName = cache.cacheName();
		return cacheName;
	}

	@Override
	protected String getKeyPrefix(Method method) {
		OneKeyCache cache = method.getAnnotation(OneKeyCache.class);
		String keyPrefix = cache.keyPrefix();
		return keyPrefix;
	}
	
	@Override
	public int getOrder() {
		return 1;
	}
}
