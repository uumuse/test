package com.kuke.core.musician.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuke.cache.annotation.MultiKeyCache;
import com.kuke.core.musician.bean.MusicianOfTrack;
import com.kuke.core.musician.bean.MusicianOfWork;
import com.kuke.core.musician.mapper.MusicianMapper;
import com.kuke.core.musician.service.IMusicianService;
import com.kuke.core.work.bean.WorkKey;

@Service
public class MusicianServiceImpl implements IMusicianService {
	@Autowired
	private MusicianMapper musicanMapper;

	@Override
	@MultiKeyCache(cacheName="musicianCache",keyPrefix="work-musicican")
	public List<MusicianOfWork> getMusicianOfWork(List<WorkKey> workKeyList) {
		List<MusicianOfWork> list = musicanMapper.getMusicianOfWork(workKeyList);
		return list;
	}
	
	@Override
	@MultiKeyCache(cacheName="musicianCache",keyPrefix="track-musicican")
	public List<MusicianOfTrack> getMusicianOfTrack(List<String> lcodeList) {
		List<MusicianOfTrack> list = musicanMapper.getMusicianOfTrack(lcodeList);
		return list;
	}
}
