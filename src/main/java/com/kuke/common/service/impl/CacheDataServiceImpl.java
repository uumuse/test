package com.kuke.common.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuke.common.service.ICacheDataService;
import com.kuke.core.cataloguebio.service.ICataloguebioService;
import com.kuke.core.musician.service.IMusicianService;
import com.kuke.core.theme.service.IThemeService;
import com.kuke.core.track.service.ITrackService;
import com.kuke.core.work.bean.WorkKey;
import com.kuke.core.work.service.IWorkService;

@Service
public class CacheDataServiceImpl implements ICacheDataService{
	@Autowired
	private IThemeService themeService;
	@Autowired
	private ICataloguebioService cataloguebioService;
	@Autowired
	private ITrackService trackService;
	@Autowired
	private IWorkService workService;
	@Autowired
	private IMusicianService musicianService;
	
	@Override
	public void cacheTheme() {
		List<Long> themeIds = themeService.getAllThemeId();
		for(Long themeId: themeIds){
			themeService.getThemeById(themeId);
		}
	}
	
	@Override
	public void cacheCata() {
		Integer offset = 0;
		Integer rows = 100;
		while(true){
			List<String> itemCodeList = cataloguebioService.getItemCodeList(offset, rows);
			if(CollectionUtils.isNotEmpty(itemCodeList) && itemCodeList.size() > 0){
				cataloguebioService.getCataloguebioList(itemCodeList);
			}
			else{
				break;
			}
			offset += rows;
		}
		
	}

	@Override
	public void cacheWork() {
		Integer offset = 0;
		Integer rows = 100;
		while(true){
			List<WorkKey> workKeyList = workService.getWorkKeyList(offset, rows);
			if(CollectionUtils.isNotEmpty(workKeyList) && workKeyList.size() > 0){
				workService.getWorkList(workKeyList);
				musicianService.getMusicianOfWork(workKeyList);
			}
			else{
				break;
			}
			offset += rows;
		}
	}

	@Override
	public void cacheTrack() {
		Integer offset = 0;
		Integer rows = 100;
		while(true){
			List<String> lcodeList = trackService.getLcodeList(offset, rows);
			if(CollectionUtils.isNotEmpty(lcodeList) && lcodeList.size() > 0){
				trackService.getTrackListByLcodes(lcodeList);
				musicianService.getMusicianOfTrack(lcodeList);
			}
			else{
				break;
			}
			offset += rows;
		}
	}
}
