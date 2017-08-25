package com.kuke.core.theme.service;

import java.util.List;

import com.kuke.core.theme.bean.Theme;

public interface IThemeService {
	/**
	 * 获得classId下的所有主题
	 * @param clazzId
	 * @return
	 */
	public List<Theme> getThemeByClazzId(Long clazzId);
	
	/**
	 * 获得classId下的所有主题的唯一键
	 * @param clazzId
	 * @return
	 */
	public List<Long> getThemeIdsByClazzId(Long clazzId);
	
	/**
	 * 获得所有的主题ID
	 * @return
	 */
	public List<Long> getAllThemeId();
	
	/**
	 * 获得主题
	 * @param themeId
	 * @return
	 */
	public Theme getThemeById(Long themeId);
}
