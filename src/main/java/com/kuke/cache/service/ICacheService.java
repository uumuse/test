package com.kuke.cache.service;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;

import com.kuke.cache.bean.Cacheable;

public interface ICacheService extends DisposableBean{
	
	public boolean isKeyInCache(String cacheName, Object key);
	
	public Object get(String cacheName, Object key);
	
	public List<Cacheable> getByKeyList(String cacheName, List<Object> keyList);
	
	public void put(String cacheName, Object key, Object value);
	
	public void clean(String cacheName);

}
