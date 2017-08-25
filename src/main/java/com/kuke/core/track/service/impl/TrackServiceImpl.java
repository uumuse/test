package com.kuke.core.track.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuke.cache.annotation.MultiKeyCache;
import com.kuke.cache.annotation.OneKeyCache;
import com.kuke.core.track.bean.Track;
import com.kuke.core.track.mapper.TrackMapper;
import com.kuke.core.track.service.ITrackService;

@Service
public class TrackServiceImpl implements ITrackService {
	@Autowired
	private TrackMapper trackMapper;
	
	@Override
	@OneKeyCache(keyPrefix="theme-track")
	public List<Track> getTrackListByThemeId(Long themeId) {
		List<Track> list = trackMapper.getTrackListByThemeId(themeId.intValue());
		return list;
	}
	
	@Override
	public List<String> getLcodeList(Integer offset, Integer rows) {
		return trackMapper.getLcodeList(offset, rows);
	}

	@Override
	@OneKeyCache(cacheName="musicCache",keyPrefix="track")
	public Track getTrackByLcode(String lcode) {
		return trackMapper.getTrackByLcode(lcode);
	}

	@Override
	@MultiKeyCache(cacheName="musicCache",keyPrefix="track")
	public List<Track> getTrackListByLcodes(List<String> lcodes) {
		if(CollectionUtils.isEmpty(lcodes)){
			return new ArrayList<Track>();
		}
		List<Track> list = trackMapper.getTrackListByLcodes(lcodes);
		return list;
	}
	
}
