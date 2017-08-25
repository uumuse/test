package com.kuke.cache.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.kuke.cache.bean.Cacheable;
import com.kuke.cache.service.ICacheService;

@Service
public class EhCacheServiceImpl implements ICacheService {
	private CacheManager cacheManager;
	
	public EhCacheServiceImpl() {
		cacheManager = CacheManager.getInstance();
	}

	@Override
	public boolean isKeyInCache(String cacheName, Object key) {
		Cache cache = getCache(cacheName);
		Element element = cache.get(key);
		boolean keyExist = cache.isKeyInCache(key);
		boolean objectExist = element != null && element.getObjectValue() != null;
		return keyExist && objectExist;
	}
	
	@Override
	public Object get(String cacheName, Object key) {
		Cache cache = getCache(cacheName);
		Element element = cache.get(key);
		if(element != null){
			Object target = element.getObjectValue();
			if(target instanceof Cacheable){
				target = ((Cacheable) target).clone();
			}
			return target;
		}
		return null;
	}
	
	@Override
	public List<Cacheable> getByKeyList(String cacheName, List<Object> keyList) {
		Cache cache = getCache(cacheName);
		Map<Object, Element> map = cache.getAll(keyList);
		List<Cacheable> list = new ArrayList<Cacheable>();
		if(map != null && CollectionUtils.isNotEmpty(map.keySet())){
			for(Object key: map.keySet()){
				Element element = map.get(key);
				Cacheable cacheable = null;
				if(element != null){
					cacheable = (Cacheable)element.getObjectValue();
				}
				if(cacheable != null && !"NULL".equals(cacheable.getKeyId())){
					list.add(cacheable.clone());
				}
			}
		}
		return list;
	}

	@Override
	public void put(String cacheName, Object key, Object value) {
		Cache cache = getCache(cacheName);
		cache.put(new Element(key, value));
	}
	
	@Override
	public void clean(String cacheName) {
		Cache cache = getCache(cacheName);
		cache.removeAll();
	}

	private Cache getCache(String cacheName){
		Cache cache = cacheManager.getCache(cacheName);
		return cache;
	}
	
	@Override
	public void destroy() throws Exception {
		cacheManager.shutdown();
	}
	
}
