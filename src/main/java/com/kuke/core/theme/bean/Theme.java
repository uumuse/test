package com.kuke.core.theme.bean;

import java.util.List;

import com.kuke.cache.bean.Cacheable;
import com.kuke.core.track.bean.Track;
import com.kuke.core.work.bean.Work;

public class Theme extends Cacheable {
	private static final long serialVersionUID = -930696302455592761L;
	private Long id;
	private Long pro_base_id;
	private String cname;
	private String ename;
	private String img_max;
	private String img_min;
	private String img_com;
	private String com_music;
	private String remark;
	private Integer is_commend;
	private Integer is_show;
	private Integer is_sub_time;
	private Long listen_count;
	private String last_date;

	private List<Work> workList;

	private List<Track> trackList;

	public Theme() {
		super();
	}

	public Theme(Long id, Long pro_base_id, String cname, String ename, String img_max, String img_min, String img_com, String com_music, String remark, Integer is_commend,
			Integer is_show, Integer is_sub_time, Long listen_count, String last_date) {
		super();
		this.id = id;
		this.pro_base_id = pro_base_id;
		this.cname = cname;
		this.ename = ename;
		this.img_max = img_max;
		this.img_min = img_min;
		this.img_com = img_com;
		this.com_music = com_music;
		this.remark = remark;
		this.is_commend = is_commend;
		this.is_show = is_show;
		this.is_sub_time = is_sub_time;
		this.listen_count = listen_count;
		this.last_date = last_date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPro_base_id() {
		return pro_base_id;
	}

	public void setPro_base_id(Long pro_base_id) {
		this.pro_base_id = pro_base_id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getImg_max() {
		return img_max;
	}

	public void setImg_max(String img_max) {
		this.img_max = img_max;
	}

	public String getImg_min() {
		return img_min;
	}

	public void setImg_min(String img_min) {
		this.img_min = img_min;
	}

	public String getImg_com() {
		return img_com;
	}

	public void setImg_com(String img_com) {
		this.img_com = img_com;
	}

	public String getCom_music() {
		return com_music;
	}

	public void setCom_music(String com_music) {
		this.com_music = com_music;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIs_commend() {
		return is_commend;
	}

	public void setIs_commend(Integer is_commend) {
		this.is_commend = is_commend;
	}

	public Integer getIs_show() {
		return is_show;
	}

	public void setIs_show(Integer is_show) {
		this.is_show = is_show;
	}

	public Integer getIs_sub_time() {
		return is_sub_time;
	}

	public void setIs_sub_time(Integer is_sub_time) {
		this.is_sub_time = is_sub_time;
	}

	public Long getListen_count() {
		return listen_count;
	}

	public void setListen_count(Long listen_count) {
		this.listen_count = listen_count;
	}

	public String getLast_date() {
		return last_date;
	}

	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}

	public List<Work> getWorkList() {
		return workList;
	}

	public void setWorkList(List<Work> workList) {
		this.workList = workList;
	}

	public List<Track> getTrackList() {
		return trackList;
	}

	public void setTrackList(List<Track> trackList) {
		this.trackList = trackList;
	}

	@Override
	public String getKeyId() {
		return this.id.toString();
	}

	@Override
	public Cacheable clone() {
		return new Theme(id, pro_base_id, cname, ename, img_max, img_min, img_com, com_music, remark, is_commend, is_show, is_sub_time, listen_count, last_date);
	}
}
