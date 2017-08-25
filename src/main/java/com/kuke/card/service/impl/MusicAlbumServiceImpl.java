package com.kuke.card.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuke.card.bean.MusicAlbum;
import com.kuke.card.mapper.MusicAlbumMapper;
import com.kuke.card.service.IMusicAlbumService;
import com.kuke.core.musician.bean.MusicianOfTrack;
import com.kuke.core.musician.service.IMusicianService;
import com.kuke.core.musician.util.MusicianUtil;
import com.kuke.core.track.bean.Track;
import com.kuke.core.track.service.ITrackService;

@Service
@Transactional(readOnly=true)
public class MusicAlbumServiceImpl implements IMusicAlbumService {
	@Autowired
	private ITrackService trackService;
	@Autowired
	private IMusicianService musicianService;
	@Autowired
	private MusicAlbumMapper musicAlbumMapper;
	
	@Override
	public MusicAlbum getMusicAlbumById(Long id) {
		MusicAlbum musicAlbum = musicAlbumMapper.getMusicAlbumById(id);
		List<String> coverList = musicAlbumMapper.getMusicAlbumRefCoverList(id);
		List<String> lcodes = musicAlbumMapper.getMusicAlbumRefLcodeList(id);
		
		List<Track> trackList = trackService.getTrackListByLcodes(lcodes);
		//获得单曲相关艺术家
		List<MusicianOfTrack> musicianList = musicianService.getMusicianOfTrack(lcodes);
		Map<String, String> musicianMap = MusicianUtil.processMusicianToMap(lcodes, musicianList, "0");
		for(Track track: trackList){
			track.setMusician(musicianMap.get(track.getL_code()));
		}
		
		musicAlbum.setCoverList(coverList);
		musicAlbum.setTrackList(trackList);
		
		return musicAlbum;
	}
	
}
