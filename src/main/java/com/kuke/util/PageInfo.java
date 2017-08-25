package com.kuke.util;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

public class PageInfo<T> {
	private Logger logger = Logger.getLogger(this.getClass());
	private Integer totalPage;// 总数页
	private Integer pageNo = null;// 页码
	private Integer pageSize = null;// 每页总共多少行
	private Integer totalRows;
	private Collection<T> data;

	public PageInfo() {
		super();
	}

	public PageInfo(Integer pageNo, Integer pageSize) {
		super();
		if (pageNo != null) {
			this.pageNo = pageNo;
		}
		if (pageSize != null) {
			this.pageSize = pageSize;
		}
	}

	public PageInfo(String pageNo, String pageSize) {
		super();
		if (StringUtils.isNotBlank(pageNo) && NumberUtils.isNumber(pageNo)) {
			this.pageNo = Integer.valueOf(pageNo);
			if (this.pageNo <= 0) {
				this.pageNo = 1;
			}
		}
		if (StringUtils.isNotBlank(pageSize) && NumberUtils.isNumber(pageSize)) {
			this.pageSize = Integer.valueOf(pageSize);
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		if (totalRows % pageSize > 0) {
			this.totalPage = totalRows / pageSize + 1;
		} else {
			this.totalPage = totalRows / pageSize;
		}
	}

	public Collection<T> getData() {
		return data;
	}

	public void setData(Collection<T> data) {
		this.data = data;
	}

	public Integer getStart() {
		if (pageNo <= 0 || pageSize <= 0) {
			logger.error("page 和 pageSize 不能为0");
		} else {
			return (pageNo - 1) * pageSize;
		}
		return null;
	}
	
	public Integer offset() {
		return getStart();
	}

	public Integer rows() {
		return this.pageSize;
	}

	public void setPageResult(Integer totalRows, Collection<T> data) {
		setTotalRows(totalRows);
		setData(data);
	}
}
