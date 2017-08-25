package com.kuke.core.cataloguebio.service;

import java.util.List;

import com.kuke.core.cataloguebio.bean.Cataloguebio;

public interface ICataloguebioService {
	
	public List<String> getItemCodeList(Integer offset, Integer rows);
	
	public List<Cataloguebio> getCataloguebioList(List<String> itemCodeList);
	
	public Cataloguebio getCataloguebioById(String itemCode);
}
