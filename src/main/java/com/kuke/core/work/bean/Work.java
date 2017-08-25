package com.kuke.core.work.bean;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuke.cache.bean.Cacheable;
import com.kuke.core.track.bean.Track;

public class Work extends Cacheable {
	private static final long serialVersionUID = 5095847656691661682L;
	private String item_code;
	private Long workid;
	private String title;
	private String ctitle;
	
	private String musician;
	private List<Track> trackList = new LinkedList<Track>();
	
	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public Long getWorkid() {
		return workid;
	}

	public void setWorkid(Long workid) {
		this.workid = workid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCtitle() {
		if(StringUtils.isBlank(ctitle)){
			return title;
		}
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	
	public String getMusician() {
		return musician;
	}

	public void setMusician(String musician) {
		this.musician = musician;
	}

	public List<Track> getTrackList() {
		return trackList;
	}

	public void setTrackList(List<Track> trackList) {
		this.trackList = trackList;
	}

	@Override
	@JsonIgnore
	public String getKeyId() {
		return "('" + this.item_code + "'" + "," + workid + ")";
	}

	@Override
	public Cacheable clone() {
		Work work = new Work();
		work.setItem_code(this.item_code);
		work.setWorkid(this.workid);
		work.setTitle(this.title);
		work.setCtitle(this.ctitle);
		return work;
	}
}
