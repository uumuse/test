package com.kuke.core.track.bean;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuke.cache.bean.Cacheable;
import com.kuke.core.cataloguebio.bean.Cataloguebio;
import com.kuke.core.work.bean.Work;
import com.kuke.core.work.bean.WorkKey;

public class Track extends Cacheable implements Serializable {
	private static final long serialVersionUID = 1038766807180841608L;
	private String l_code;
	private String item_code;
	private Long workid;
	private String title;
	private String ctitle;
	private String timing;
	private Integer CD;
	private Integer track;
	private String ISRC;
	private Integer istxt;
	private String old_l_code;
	private Integer wav;
	private Integer kbps320;
	private Integer kbps192;

	private Cataloguebio cataloguebio;
	private Work work;
	private String musician;

	public Track() {
		super();
	}
	
	public Track(String l_code, String item_code, Long workid, String title, String ctitle, String timing, Integer CD, Integer track, String ISRC, Integer istxt,
			String old_l_code, Integer wav, Integer kbps320, Integer kbps192) {
		super();
		this.l_code = l_code;
		this.item_code = item_code;
		this.workid = workid;
		this.title = title;
		this.ctitle = ctitle;
		this.timing = timing;
		this.CD = CD;
		this.track = track;
		this.ISRC = ISRC;
		this.istxt = istxt;
		this.old_l_code = old_l_code;
		this.wav = wav;
		this.kbps320 = kbps320;
		this.kbps192 = kbps192;
	}

	public String getL_code() {
		return l_code;
	}

	public void setL_code(String l_code) {
		this.l_code = l_code;
	}

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
		if (StringUtils.isBlank(ctitle)) {
			return this.title;
		}
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public Integer getCD() {
		return CD;
	}

	public void setCD(Integer cD) {
		CD = cD;
	}

	public Integer getTrack() {
		return track;
	}

	public void setTrack(Integer track) {
		this.track = track;
	}

	public String getISRC() {
		return ISRC;
	}

	public void setISRC(String iSRC) {
		ISRC = iSRC;
	}

	public Integer getIstxt() {
		return istxt;
	}

	public void setIstxt(Integer istxt) {
		this.istxt = istxt;
	}

	public String getOld_l_code() {
		return old_l_code;
	}

	public void setOld_l_code(String old_l_code) {
		this.old_l_code = old_l_code;
	}

	public Integer getWav() {
		return wav;
	}

	public void setWav(Integer wav) {
		this.wav = wav;
	}

	public Integer getKbps320() {
		return kbps320;
	}

	public void setKbps320(Integer kbps320) {
		this.kbps320 = kbps320;
	}

	public Integer getKbps192() {
		return kbps192;
	}

	public void setKbps192(Integer kbps192) {
		this.kbps192 = kbps192;
	}

	public Cataloguebio getCataloguebio() {
		return cataloguebio;
	}

	public void setCataloguebio(Cataloguebio cataloguebio) {
		this.cataloguebio = cataloguebio;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public String getMusician() {
		return musician;
	}

	public void setMusician(String musician) {
		this.musician = musician;
	}

	@Override
	public String getKeyId() {
		return this.l_code;
	}

	@JsonIgnore
	public WorkKey getWorkKey() {
		return new WorkKey(item_code, workid);
	}

	@Override
	public Cacheable clone() {
		Track clone = new Track(l_code, item_code, workid, title, ctitle, timing, CD, track, ISRC, istxt, old_l_code, wav, kbps320, kbps192);
		return clone;
	}
}
