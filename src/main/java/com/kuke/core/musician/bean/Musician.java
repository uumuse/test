package com.kuke.core.musician.bean;

import com.kuke.cache.bean.Cacheable;

public abstract class Musician extends Cacheable {
	private static final long serialVersionUID = -7103799165462471687L;
	private String musicianType;
	private String fullname;

	public String getMusicianType() {
		return musicianType;
	}

	public void setMusicianType(String musicianType) {
		this.musicianType = musicianType;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
