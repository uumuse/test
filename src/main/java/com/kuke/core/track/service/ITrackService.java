package com.kuke.core.track.service;

import java.util.List;

import com.kuke.core.track.bean.Track;

public interface ITrackService {
	/**
	 * 根据内容Id获得综合内容包的所有单曲
	 * @param pro_app_id
	 * @return
	 */
	public List<Track> getTrackListByThemeId(Long themeId);
	
	/**
	 * 获得所有的单曲 lcode
	 * @return
	 */
	public List<String> getLcodeList(Integer offset, Integer rows);
	
	/**
	 * 根据 lcode获得单曲
	 * @param lcode
	 * @return
	 */
	public Track getTrackByLcode(String lcode);
	
	/**
	 * 批量获得单曲
	 * @param lcodes
	 * @param musicianTypeList 需要获得的艺术家的类型，该参数为空表示不获取任何艺术家 
	 * @return
	 */
	public List<Track> getTrackListByLcodes(List<String> lcodes);
}
