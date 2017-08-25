package com.kuke.prodata.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuke.core.musician.bean.MusicianOfTrack;
import com.kuke.core.musician.service.IMusicianService;
import com.kuke.core.musician.util.MusicianUtil;
import com.kuke.core.theme.bean.Theme;
import com.kuke.core.theme.service.IThemeService;
import com.kuke.core.track.bean.Track;
import com.kuke.core.track.service.ITrackService;
import com.kuke.core.work.bean.Work;
import com.kuke.core.work.bean.WorkKey;
import com.kuke.core.work.service.IWorkService;
import com.kuke.prodata.service.IProAppService;

@Service
public class ProAppServiceImpl implements IProAppService{
	@Autowired
	private IThemeService themeService;
	@Autowired
	private ITrackService trackService;
	@Autowired
	private IWorkService workService;
	@Autowired
	private IMusicianService musicianService;
	
	@Override
	public Theme getThemeForRecord(Long themeId) {
		Theme theme = themeService.getThemeById(themeId);

		List<Track> trackList = trackService.getTrackListByThemeId(themeId);

		Set<String> lcodeSet = new HashSet<String>();
		Set<WorkKey> workKeySet = new HashSet<WorkKey>();
		for (Track track : trackList) {
			String item_code = track.getItem_code();
			Long workid = track.getWorkid();
			workKeySet.add(new WorkKey(item_code, workid));
			lcodeSet.add(track.getL_code());
		}
		List<String> lcodeList = new LinkedList<String>(lcodeSet);
		List<WorkKey> workKeyList = new LinkedList<WorkKey>(workKeySet);

		List<Work> workList = workService.getWorkList(workKeyList);

		List<MusicianOfTrack> musicianList = musicianService.getMusicianOfTrack(lcodeList);
		Map<String, String> musicianMap = MusicianUtil.processMusicianToMap(lcodeList, musicianList, "0");
		Map<String, Work> workMap = new LinkedHashMap<String, Work>();
		for (Work work : workList) {
			String workKey = work.getKeyId();
			workMap.put(workKey, work);
		}
		for (Track track : trackList) {
			track.setMusician(musicianMap.get(track.getL_code()));
			String workKey = track.getWorkKey().toString();
			Work work = workMap.get(workKey);
			List<Track> tracks = work.getTrackList();
			tracks.add(track);
		}
		theme.setWorkList(workList);
		return theme;
	}
	
	@Override
	public Theme getThemeForFm(Long themeId) {
		Theme theme = themeService.getThemeById(themeId);

		List<Track> trackList = trackService.getTrackListByThemeId(themeId);

		Set<String> lcodeSet = new HashSet<String>();
		Set<WorkKey> workKeyList = new HashSet<WorkKey>();
		for (Track track : trackList) {
			lcodeSet.add(track.getL_code());
			workKeyList.add(track.getWorkKey());
		}
		List<String> lcodeList = new LinkedList<String>(lcodeSet);

		List<MusicianOfTrack> musicianList = musicianService.getMusicianOfTrack(lcodeList);
		Map<String, String> musicianMap = MusicianUtil.processMusicianToMap(lcodeList, musicianList, "0");
		
		List<Work> workList = workService.getWorkList(new ArrayList<WorkKey>(workKeyList));
		Map<String, Work> workMap = new HashMap<String, Work>();
		for(Work work: workList){
			workMap.put(work.getKeyId(), work);
		}
		
		for (Track track : trackList) {
			if(StringUtils.isBlank(track.getCtitle())){
				track.setCtitle(track.getTitle());
			}
			track.setMusician(musicianMap.get(track.getL_code()));
			track.setWork(workMap.get(track.getWorkKey().toString()));
		}
		theme.setTrackList(trackList);
		return theme;
	}
}
