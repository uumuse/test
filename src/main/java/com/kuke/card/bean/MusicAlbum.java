package com.kuke.card.bean;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kuke.core.track.bean.Track;
import com.kuke.util.EntityDecoder;

public class MusicAlbum {
	private Long id;
	private String user_id;
	private String name;
	private String default_cover;
	private String album_desc;
	private Integer play_type;
	private Date create_time;
	private Date last_time;

	private List<String> coverList;
	private List<Track> trackList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		if (StringUtils.isNotBlank(name)) {
			return EntityDecoder.charToHtml(name);
		}
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefault_cover() {
		return default_cover;
	}

	public void setDefault_cover(String default_cover) {
		this.default_cover = default_cover;
	}

	public String getAlbum_desc() {
		if (StringUtils.isNotBlank(album_desc)) {
			return EntityDecoder.charToHtml(album_desc);
		}
		return album_desc;
	}

	public void setAlbum_desc(String album_desc) {
		this.album_desc = album_desc;
	}

	public Integer getPlay_type() {
		return play_type;
	}

	public void setPlay_type(Integer play_type) {
		this.play_type = play_type;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getLast_time() {
		return last_time;
	}

	public void setLast_time(Date last_time) {
		this.last_time = last_time;
	}

	public List<String> getCoverList() {
		return coverList;
	}

	public void setCoverList(List<String> coverList) {
		this.coverList = coverList;
	}

	public List<Track> getTrackList() {
		return trackList;
	}

	public void setTrackList(List<Track> trackList) {
		this.trackList = trackList;
	}

}
