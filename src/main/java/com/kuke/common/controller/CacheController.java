package com.kuke.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuke.cache.service.ICacheService;
import com.kuke.common.service.ICacheDataService;

@Controller
@RequestMapping("/kuke/classicat/cache")
public class CacheController {
	@Autowired
	private ICacheDataService cacheDataService;
	@Autowired
	private ICacheService enCacheService;
	
	@ResponseBody
	@RequestMapping("theme")
	public Object cacheTheme(){
		cacheDataService.cacheTheme();
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("cata")
	public Object cacheCataloguebio(){
		cacheDataService.cacheCata();
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("work")
	public Object cacheWork(){
		cacheDataService.cacheWork();
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("track")
	public Object cacheTrack(){
		cacheDataService.cacheTrack();
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/temp/clean")
	public Object cleanTempCache(){
		enCacheService.clean("tempCache");
		return "success";
	}
}
