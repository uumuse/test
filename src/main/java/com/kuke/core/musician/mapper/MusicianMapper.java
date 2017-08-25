package com.kuke.core.musician.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuke.core.musician.bean.MusicianOfTrack;
import com.kuke.core.musician.bean.MusicianOfWork;
import com.kuke.core.work.bean.WorkKey;

public interface MusicianMapper {
	
	/**
	 * 获得作品相关的艺术家
	 * @param workIdList
	 * @return
	 */
	public List<MusicianOfWork> getMusicianOfWork(@Param("workKeyList") List<WorkKey> workKeyList);
	
	/**
	 * 获得单曲相关的艺术家
	 * @param lcodeList
	 * @return
	 */
	public List<MusicianOfTrack> getMusicianOfTrack(@Param("lcodeList") List<String> lcodeList);
}
