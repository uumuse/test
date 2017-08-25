package com.kuke.core.cataloguebio.bean;

import java.util.Date;

import com.kuke.cache.bean.Cacheable;

public class Cataloguebio extends Cacheable {
	private static final long serialVersionUID = 6102710939236022588L;
	private String item_code;
	private String labelid;
	private String title;
	private String ctitle;
	private Integer nocd;
	private String timing;
	private String barcode;
	private Date releasedate;
	private String waveready;
	private Integer isshow;
	private Integer isdown;
	private String gettype;
	private String catabio;
	private Integer rar;
	private Integer maximg;
	private Integer minimg;
	private Date last_date;
	
	public Cataloguebio() {
		super();
	}

	public Cataloguebio(String item_code, String labelid, String title, String ctitle, Integer nocd, String timing, String barcode, Date releasedate, String waveready,
			Integer isshow, Integer isdown, String gettype, String catabio, Integer rar, Integer maximg, Integer minimg, Date last_date) {
		super();
		this.item_code = item_code;
		this.labelid = labelid;
		this.title = title;
		this.ctitle = ctitle;
		this.nocd = nocd;
		this.timing = timing;
		this.barcode = barcode;
		this.releasedate = releasedate;
		this.waveready = waveready;
		this.isshow = isshow;
		this.isdown = isdown;
		this.gettype = gettype;
		this.catabio = catabio;
		this.rar = rar;
		this.maximg = maximg;
		this.minimg = minimg;
		this.last_date = last_date;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getLabelid() {
		return labelid;
	}

	public void setLabelid(String labelid) {
		this.labelid = labelid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public Integer getNocd() {
		return nocd;
	}

	public void setNocd(Integer nocd) {
		this.nocd = nocd;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public String getWaveready() {
		return waveready;
	}

	public void setWaveready(String waveready) {
		this.waveready = waveready;
	}

	public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public Integer getIsdown() {
		return isdown;
	}

	public void setIsdown(Integer isdown) {
		this.isdown = isdown;
	}

	public String getGettype() {
		return gettype;
	}

	public void setGettype(String gettype) {
		this.gettype = gettype;
	}

	public String getCatabio() {
		return catabio;
	}

	public void setCatabio(String catabio) {
		this.catabio = catabio;
	}

	public Integer getRar() {
		return rar;
	}

	public void setRar(Integer rar) {
		this.rar = rar;
	}

	public Integer getMaximg() {
		return maximg;
	}

	public void setMaximg(Integer maximg) {
		this.maximg = maximg;
	}

	public Integer getMinimg() {
		return minimg;
	}

	public void setMinimg(Integer minimg) {
		this.minimg = minimg;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}

	@Override
	public String getKeyId() {
		return this.item_code;
	}

	@Override
	public Cacheable clone() {
		return new Cataloguebio(item_code, labelid, title, ctitle, nocd, timing, barcode, releasedate, waveready, isshow, isdown, gettype, catabio, rar, maximg, minimg, last_date);
	}
}
