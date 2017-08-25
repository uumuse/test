package com.kuke.core.work.bean;

public class WorkKey {
	private String item_code;
	private Long workid;

	public WorkKey() {
		super();
	}

	public WorkKey(String item_code, Long workid) {
		super();
		this.item_code = item_code;
		this.workid = workid;
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

	public String getKey() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "('" + this.item_code + "'" + "," + workid + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_code == null) ? 0 : item_code.hashCode());
		result = prime * result + ((workid == null) ? 0 : workid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkKey other = (WorkKey) obj;
		if (item_code == null) {
			if (other.item_code != null)
				return false;
		} else if (!item_code.equals(other.item_code))
			return false;
		if (workid == null) {
			if (other.workid != null)
				return false;
		} else if (!workid.equals(other.workid))
			return false;
		return true;
	}
}
