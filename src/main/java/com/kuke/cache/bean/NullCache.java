package com.kuke.cache.bean;


public class NullCache extends Cacheable{
	private static final long serialVersionUID = -3515319489413522217L;

	@Override
	public String getKeyId() {
		return "NULL";
	}

	@Override
	public Cacheable clone() {
		return null;
	}
}
