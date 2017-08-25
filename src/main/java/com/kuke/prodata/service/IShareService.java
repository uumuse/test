package com.kuke.prodata.service;

import java.util.List;
import java.util.Map;

public interface IShareService {
	
	public List<Map<String, Object>> getTrackInfo(String lcode,String workid,String itemcode);

}
