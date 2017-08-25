package com.kuke.core.track.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuke.core.track.bean.Track;

public interface TrackMapper {
	/**
	 * 根据内容Id获得综合内容包的信息
	 * @param pro_app_id
	 * @return
	 */
	public List<Track> getTrackListByThemeId(@Param("themeId") Integer themeId);
	
	/**
	 * 获得所有的单曲 lcode
	 * @return
	 */
	public List<String> getLcodeList(@Param("offset") Integer offset, @Param("rows") Integer rows);
	
	/**
	 * 根据 lcode 获得单曲
	 * @param lcode
	 * @return
	 */
	public Track getTrackByLcode(@Param("lcode")String lcode);
	
	/**
	 * 批量获得单曲
	 * @param lcodes
	 * @return
	 */
	public List<Track> getTrackListByLcodes(@Param("lcodes")List<String> lcodes);
}
