package com.kuke.core.musician.bean;

import com.kuke.cache.bean.Cacheable;


public class MusicianOfWork extends Musician {
	private static final long serialVersionUID = -5203227675893159215L;
	private String item_code;
	private Integer workid;
	private String musicianType;// 艺术家的类型 1:作曲家; 6:作词者; 7:曲作家/编曲者
	private String fullname;

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public Integer getWorkid() {
		return workid;
	}

	public void setWorkid(Integer workid) {
		this.workid = workid;
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
		return "('" + this.item_code + "'" + "," + workid + ")";
	}

	@Override
	public Cacheable clone() {
		return this;
	}
}
