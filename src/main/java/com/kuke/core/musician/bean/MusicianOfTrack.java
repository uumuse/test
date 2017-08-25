package com.kuke.core.musician.bean;

import com.kuke.cache.bean.Cacheable;


public class MusicianOfTrack extends Musician {
	private static final long serialVersionUID = -5203227675893159215L;
	private String l_code;
	private String musicianType;//艺术家的类型 0:演奏家; 2:指挥家; 3:合唱团; 4:合奏团; 5:管弦乐团;
	private String fullname;
	
	public String getL_code() {
		return l_code;
	}

	public void setL_code(String l_code) {
		this.l_code = l_code;
	}

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

	@Override
	public String getKeyId() {
		return this.l_code;
	}

	@Override
	public Cacheable clone() {
		return this;
	}
}
