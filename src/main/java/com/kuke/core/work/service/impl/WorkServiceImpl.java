package com.kuke.core.work.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuke.cache.annotation.MultiKeyCache;
import com.kuke.core.work.bean.Work;
import com.kuke.core.work.bean.WorkKey;
import com.kuke.core.work.mapper.WorkMapper;
import com.kuke.core.work.service.IWorkService;

@Service
public class WorkServiceImpl implements IWorkService {
	@Autowired
	private WorkMapper workMapper;
	
	@Override
	public List<WorkKey> getWorkKeyList(Integer offset, Integer rows) {
		return workMapper.getWorkKeyList(offset, rows);
	}

	@Override
	@MultiKeyCache(cacheName = "musicCache", keyPrefix = "work")
	public List<Work> getWorkList(List<WorkKey> workKeyList) {
		return workMapper.getWorkList(workKeyList);
	}

}
