package com.kuke.aspect;

import java.lang.reflect.Method;


public abstract class BaseAspect {
	protected Object getKey(String keyPrefix, Object arg) {
		return keyPrefix + "-" + arg.toString();
	}
	
	protected abstract String getCacheName(Method method);
	
	protected abstract String getKeyPrefix(Method method);
	
}
