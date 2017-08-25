package com.kuke.aspect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.kuke.cache.annotation.MultiKeyCache;
import com.kuke.cache.bean.Cacheable;
import com.kuke.cache.bean.NullCache;
import com.kuke.cache.service.ICacheService;

@Aspect
@Component
public class MultiKeyAspect extends BaseAspect implements Ordered {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ICacheService cacheService;

	@SuppressWarnings("unchecked")
	@Around("@annotation(com.kuke.cache.annotation.MultiKeyCache)")
	public Object multiKeyCache(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		String keyPrefix = getKeyPrefix(method);
		String cacheName = getCacheName(method);
		if(StringUtils.isBlank(cacheName)){
			cacheName = "tempCache";
		}
		
		List<Object> targetIdList = (List<Object>)args[0];
		List<Object> mishitList = new ArrayList<Object>();
		List<Object> cacheKeyList = new ArrayList<Object>();
		
		for(Object targetId: targetIdList){
			Object cacheKey = getKey(keyPrefix, targetId);
			boolean hit = cacheService.isKeyInCache(cacheName, cacheKey);
			if(!hit){
				mishitList.add(targetId);
			}
			else{
				logger.debug("Cache " + cacheName + " hit, cache key is " + cacheKey);
			}
			cacheKeyList.add(cacheKey);
		}
		
		if(mishitList.size() > 0){
			args[0] = mishitList;
			List<Cacheable> cacheableList = (List<Cacheable>)joinPoint.proceed(args);
			cacheData(cacheName, keyPrefix, mishitList, cacheableList);
		}
		
		ArrayList<Cacheable> resultList = (ArrayList<Cacheable>)cacheService.getByKeyList(cacheName, cacheKeyList);
		return resultList;
	}
	
	private void cacheData(String cacheName, String keyPrefix, List<Object> mishitList, List<Cacheable> cacheableList){
		Map<Object, Cacheable> map = new HashMap<Object, Cacheable>();
		if(CollectionUtils.isNotEmpty(cacheableList)){
			for(Cacheable cacheable: cacheableList){
				Object key = getKey(keyPrefix, cacheable.getKeyId());
				map.put(key, cacheable);
			}
		}
		if(CollectionUtils.isNotEmpty(mishitList)){
			for(Object key: mishitList){
				Object cacheKey = getKey(keyPrefix, key);
				Cacheable cacheable = map.get(cacheKey);
				if(cacheable == null){
					cacheable = new NullCache();
				}
				cacheService.put(cacheName, cacheKey, cacheable);
				logger.debug("cache data key " + cacheKey);
			}
		}
	}
	
	@Override
	protected String getCacheName(Method method) {
		MultiKeyCache cache = method.getAnnotation(MultiKeyCache.class);
		String cacheName = cache.cacheName();
		return cacheName;
	}

	@Override
	protected String getKeyPrefix(Method method) {
		MultiKeyCache cache = method.getAnnotation(MultiKeyCache.class);
		String keyPrefix = cache.keyPrefix();
		return keyPrefix;
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
