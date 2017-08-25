package com.kuke.card.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuke.card.bean.MusicAlbum;

public interface MusicAlbumMapper {

	public MusicAlbum getMusicAlbumById(@Param("id") Long id);
	
	public List<String> getMusicAlbumRefLcodeList(@Param("albumId") Long albumId);
	
	public List<String> getMusicAlbumRefCoverList(@Param("albumId") Long albumId);
}
