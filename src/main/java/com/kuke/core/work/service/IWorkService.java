package com.kuke.core.work.service;

import java.util.List;

import com.kuke.core.work.bean.Work;
import com.kuke.core.work.bean.WorkKey;

public interface IWorkService {
	
	/**
	 * 获得作品key
	 * @return
	 */
	public List<WorkKey> getWorkKeyList(Integer offset, Integer rows);
	
	/**
	 * 根据作品Id批量获得作品信息
	 * @param workIdList
	 * @return
	 */
	public List<Work> getWorkList(List<WorkKey> workKeyList);
}
