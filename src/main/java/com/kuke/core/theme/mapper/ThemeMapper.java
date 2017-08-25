package com.kuke.core.theme.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuke.core.theme.bean.Theme;

public interface ThemeMapper {
	/**
	 * 获得classId下的所有主题
	 * @param clazzId
	 * @return
	 */
	public List<Theme> getThemesByClazzId(@Param("clazzId")Long clazzId);
	
	/**
	 * 获得classId下的所有主题的唯一键
	 * @param clazzId
	 * @return
	 */
	public List<Long> getThemeIdsByClazzId(@Param("clazzId")Long clazzId);
	
	/**
	 * 获得所有的主题ID
	 * @return
	 */
	public List<Long> getAllThemeId();
	
	/**
	 * 根据 ID 获得主题信息
	 * @param themeId
	 * @return
	 */
	public Theme getThemeById(@Param("themeId") Long themeId);
}
