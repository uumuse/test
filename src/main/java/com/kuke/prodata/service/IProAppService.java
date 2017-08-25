package com.kuke.prodata.service;

import com.kuke.core.theme.bean.Theme;

public interface IProAppService {
	/**
	 * 根据 ID 获得主题信息，主题下包括作品，作品下包含单曲
	 * @param themeId
	 * @return
	 */
	public Theme getThemeForRecord(Long themeId);
	
	/**
	 * 根据 ID 获得主题信息，主题只包含单曲
	 * @param themeId
	 * @return
	 */
	public Theme getThemeForFm(Long themeId);
}
