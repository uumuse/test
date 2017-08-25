package com.kuke.cache.bean;

import java.io.Serializable;

public abstract class Cacheable implements Serializable, Cloneable{
	private static final long serialVersionUID = 6594186951044108072L;

	public abstract String getKeyId();
	
	public abstract Cacheable clone();
}
