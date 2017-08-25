package com.kuke.core.theme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuke.cache.annotation.OneKeyCache;
import com.kuke.core.theme.bean.Theme;
import com.kuke.core.theme.mapper.ThemeMapper;
import com.kuke.core.theme.service.IThemeService;

@Service
public class ThemeServiceImpl implements IThemeService {
	@Autowired
	private ThemeMapper themeMapper;
	
	@Override
	@OneKeyCache(keyPrefix = "class-theme")
	public List<Theme> getThemeByClazzId(Long clazzId) {
		return themeMapper.getThemesByClazzId(clazzId);
	}
	
	@Override
	public List<Long> getThemeIdsByClazzId(Long clazzId) {
		return themeMapper.getThemeIdsByClazzId(clazzId);
	}

	@Override
	public List<Long> getAllThemeId() {
		return themeMapper.getAllThemeId();
	}

	@Override
	@OneKeyCache(keyPrefix = "theme")
	public Theme getThemeById(Long themeId) {
		return themeMapper.getThemeById(themeId);
	}
}
