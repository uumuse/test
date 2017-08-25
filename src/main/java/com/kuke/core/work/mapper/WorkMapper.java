package com.kuke.core.work.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuke.core.work.bean.Work;
import com.kuke.core.work.bean.WorkKey;

public interface WorkMapper {
	
	/**
	 * 获得作品key
	 * @return
	 */
	public List<WorkKey> getWorkKeyList(@Param("offset") Integer offset, @Param("rows") Integer rows);
	
	/**
	 * 根据作品Id批量获得作品信息
	 * @param workIdList
	 * @return
	 */
	public List<Work> getWorkList(@Param("workKeyList") List<WorkKey> workKeyList);
}
