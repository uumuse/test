package com.kuke.prodata.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuke.prodata.mapper.ShareMapper;
import com.kuke.prodata.service.IShareService;

@Service
public class ShareService implements IShareService {

	@Autowired
	private ShareMapper shareMapper;
	
	@Override
	public List<Map<String, Object>> getTrackInfo(String lcode, String workid,
			String itemcode) {
		List<Map<String, Object>> list = shareMapper.getTrackInfo(lcode,workid,itemcode);
		List<Map<String, Object>> trackList = new LinkedList<Map<String,Object>>();
		Set<String> pkset = new HashSet<String>();
		for(Map<String, Object> data:list){
			String workPk = "('" + data.get("item_code") + "'," + data.get("workid") + ")";
			pkset.add(workPk);
			Map<String, Object> track = new HashMap<String, Object>();
			track.put("l_code", data.get("l_code"));
			track.put("workid", data.get("workid"));
			track.put("item_code", data.get("item_code"));
			track.put("labelid", data.get("labelid"));
			track.put("title", String.valueOf(data.get("title")).replace("'", "")+":"+String.valueOf(data.get("wtitle")).replace("'", ""));
			track.put("timing", data.get("timing"));
			String item_code = data.get("item_code").toString();
			track.put("img", "http://img.kuke.com/images/audio/cata/"+item_code.substring(0, 1)+"/"+item_code+".gif");
			
			trackList.add(track);
		}
		
		List<Map<String, Object>> musicanList = shareMapper.getMusiciansByWorkPkList(new ArrayList<String>(pkset));
		Map<String, String> musicanMap = getMusicanMap(musicanList);
		
		for(Map<String, Object> track: trackList){
			String workPk = track.get("item_code")+ "-" + track.get("workid");
			String musican = musicanMap.get(workPk);
			if(StringUtils.isEmpty(musican)){
				musican = String.valueOf("The Artist");
			}
			track.put("musician", musican);
			
		}
		return trackList;
	}

	
	private Map<String, String> getMusicanMap(List<Map<String, Object>> musicanList){
		Map<String, String> result = new HashMap<String, String>();
		
		Map<String, List<Map<String, Object>>> musicianMap = new HashMap<String, List<Map<String, Object>>>();
		for(Map<String, Object> musician: musicanList){
			String pk = musician.get("item_code").toString() + "-" + musician.get("workid");
			List<Map<String, Object>> list = musicianMap.get(pk);
			if(list == null){
				list = new LinkedList<Map<String,Object>>();
				musicianMap.put(pk, list);
			}
			list.add(musician);
		}
		
		for(String pk: musicianMap.keySet()){
			List<Map<String, Object>> musicians = musicianMap.get(pk);
			
			if(musicians != null && !musicians.isEmpty()){
				Map<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();
				for (Map<String, Object> musician : musicians) {
					int flag = Integer.valueOf(musician.get("flag").toString());
					String fullname = String.valueOf(musician.get("fullname"));
					
					if(map.get(flag) == null){
						map.put(flag, new HashSet<String>());
					}
					map.get(flag).add(fullname);
				}
				
				StringBuffer sb = new StringBuffer();
				
				if (map != null) {
					if(map.get(0) != null && StringUtils.isNotBlank(map.get(0).toString())){
						sb.append("Performer: " + joinSetVal(map.get(0)) + " ; ");
					}
					if(map.get(1)!=null && StringUtils.isNotBlank(map.get(1).toString())){
						sb.append("Composer: " + joinSetVal(map.get(1)) + " ; ");
					}
					if(map.get(6)!=null && StringUtils.isNotBlank(map.get(6).toString())){
						sb.append("Lyricist: " + joinSetVal(map.get(6)) + " ; ");
					}
					if(map.get(7)!=null && StringUtils.isNotBlank(map.get(7).toString())){
						sb.append("Arranger: " + joinSetVal(map.get(7)) + " ; ");
					}
				}
				
				result.put(pk, sb.toString());
			}
			else{
				result.put(pk, "暂无");
			}
		}
		return result;
	}
	
	private String joinSetVal(Set<String> set){
		StringBuffer buffer = new StringBuffer();
		for(String name: set){
			buffer.append(name + ";");
		}
		return buffer.substring(0, buffer.length() - 1);
	}
}
