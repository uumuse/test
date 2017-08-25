package com.kuke.core.musician.service;

import java.util.List;

import com.kuke.core.musician.bean.MusicianOfTrack;
import com.kuke.core.musician.bean.MusicianOfWork;
import com.kuke.core.work.bean.WorkKey;

public interface IMusicianService {
	
	/**
	 * 获得作品相关的艺术家
	 * @param workIdList
	 * @return
	 */
	public List<MusicianOfWork> getMusicianOfWork(List<WorkKey> workKeyList);
	
	/**
	 * 获得单曲相关的艺术家
	 * @param lcodeList
	 * @return
	 */
	public List<MusicianOfTrack> getMusicianOfTrack(List<String> lcodeList);

}
