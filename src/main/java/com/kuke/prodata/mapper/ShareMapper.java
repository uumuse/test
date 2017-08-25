package com.kuke.prodata.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ShareMapper {
	
	public List<Map<String, Object>> getTrackInfo(@Param("lcode")String lcode,@Param("workid")String workid,@Param("itemcode")String itemcode);
	
	public List<Map<String,Object>> getMusiciansByWorkPkList(@Param("pkList")List<String> pkList);

}
