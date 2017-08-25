package com.kuke.core.cataloguebio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuke.cache.annotation.MultiKeyCache;
import com.kuke.cache.annotation.OneKeyCache;
import com.kuke.core.cataloguebio.bean.Cataloguebio;
import com.kuke.core.cataloguebio.mapper.CataloguebioMapper;
import com.kuke.core.cataloguebio.service.ICataloguebioService;

@Service
public class CataloguebioServiceImpl implements ICataloguebioService{
	@Autowired
	private CataloguebioMapper cataloguebioMapper;
	
	@Override
	public List<String> getItemCodeList(Integer offset, Integer rows) {
		return cataloguebioMapper.getItemCodeList(offset, rows);
	}

	@Override
	@MultiKeyCache(cacheName="musicCache", keyPrefix="cataloguebio")
	public List<Cataloguebio> getCataloguebioList(List<String> itemCodeList) {
		return cataloguebioMapper.getCataloguebioList(itemCodeList);
	}

	@Override
	@OneKeyCache(cacheName="musicCache", keyPrefix="cataloguebio")
	public Cataloguebio getCataloguebioById(String itemCode) {
		Cataloguebio cataloguebio = cataloguebioMapper.getCataloguebioById(itemCode);
		return cataloguebio;
	}
	
}
