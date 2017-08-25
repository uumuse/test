package com.kuke.core.musician.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.kuke.core.musician.bean.Musician;
import com.kuke.util.CollectionUtil;

public class MusicianUtil {
	private static Map<String, String> typeMap = new HashMap<String, String>();
	static {
		typeMap.put("0", "演奏家");
		typeMap.put("1", "作曲家");
		typeMap.put("2", "指挥家");
		typeMap.put("3", "合唱团");
		typeMap.put("4", "合奏团");
		typeMap.put("5", "管弦乐团");
		typeMap.put("6", "作词者");
		typeMap.put("7", "曲作家/编曲者");
	}
	
	/**
	 * 处理艺术家成 map<key, map<key: String>> 格式 例如：{"1":{"0": "Grieg, Edvard;"; "1":"Grieg, Edvard;"}}
	 * key表示 l_code 或者 workKey
	 */
	public static Map<String, Map<String, String>> processMusicianToMap(List<? extends Object> keyList, List<? extends Musician> musicianList) {
		Map<String, Map<String, List<String>>> musicianMap = processMusician(musicianList);
		Map<String, Map<String, String>> resultMap = processMusician(keyList, musicianMap);
		return resultMap;
	}
	
	/**
	 * 处理艺术家成 map<key, String> 格式 例如：{"1":"作曲家:Grieg, Edvard;"}
	 * key表示 l_code 或者 workKey
	 */
	public static Map<String, String> processMusicianToMap(List<? extends Object> keyList, List<? extends Musician> musicianList, String... musicianType) {
		Map<String, Map<String, List<String>>> musicianMap = processMusician(musicianList);
		Map<String, String> resultMap = processMusician(keyList, musicianMap, musicianType);
		return resultMap;
	}

	/**
	 * 处理艺术家成 map<key, map<musicianType, list<musicanName>>> 格式 key表示 l_code 或者
	 * workKey
	 */
	protected static Map<String, Map<String, List<String>>> processMusician(List<? extends Musician> musicianList) {
		Map<String, Map<String, List<String>>> result = new HashMap<String, Map<String, List<String>>>();
		for (Musician musician : musicianList) {
			String key = musician.getKeyId();
			String musicianType = musician.getMusicianType();
			String fullname = StringUtils.isNotBlank(musician.getFullname()) ? musician.getFullname() : null;

			Map<String, List<String>> subMap = result.get(key);
			if (subMap == null) {
				subMap = new HashMap<String, List<String>>();
				result.put(key, subMap);
			}

			List<String> nameList = subMap.get(musicianType);
			if (nameList == null) {
				nameList = new LinkedList<String>();
				subMap.put(musicianType, nameList);
			}

			nameList.add(fullname);
		}
		return result;
	}
	
	/**
	 * 处理艺术家成 map<key, map<key: String>> 格式 例如：{"1":{"0": "Grieg, Edvard;"; "1":"Grieg, Edvard;"}}
	 * key表示 l_code 或者 workKey
	 */
	protected static Map<String, Map<String, String>> processMusician(List<? extends Object> keyList, Map<String, Map<String, List<String>>> musicianMap) {
		Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>();
		for (Object key : keyList) {
			Map<String, List<String>> musicians = musicianMap.get(key.toString());
			if(musicians == null){
				musicians = new HashMap<String, List<String>>();
			}
			Map<String, String> subMap = new HashMap<String, String>();
			for(String type: musicians.keySet()){
				List<String> list = musicians.get(type);
				if(CollectionUtils.isNotEmpty(list)){
					subMap.put(type, CollectionUtil.join(list, ";"));
				}
				else{
					subMap.put(type, "");
				}
			}
			resultMap.put(key.toString(), subMap);
		}
		return resultMap;
	}

	/**
	 * 处理艺术家成 map<key, String> 格式 例如：{"1":"作曲家:Grieg, Edvard;"}
	 * key表示 l_code 或者 workKey
	 */
	protected static Map<String, String> processMusician(List<? extends Object> keyList, Map<String, Map<String, List<String>>> musicianMap, String... musicianType) {
		Map<String, String> resultMap = new HashMap<String, String>();
		for (Object key : keyList) {
			Map<String, List<String>> musicians = musicianMap.get(key.toString());
			if(musicians == null){
				musicians = new HashMap<String, List<String>>();
			}

			List<String> typeList = new LinkedList<String>();
			if (musicianType != null && musicianType.length > 0) {
				for (String type : musicianType) {
					typeList.add(type);
				}
			} else {
				Set<String> typeSet = musicians.keySet();
				for (String type : typeSet) {
					typeList.add(type);
				}
			}

			StringBuilder temp = new StringBuilder();
			for (String type : typeList) {
				if (musicians.keySet().contains(type)) {
					String musician = CollectionUtil.join(musicians.get(type), ";");
					temp.append(typeMap.get(type) + ":" + (StringUtils.isNotBlank(musician)? musician : "未知")).append(" ");
				} else {
					temp.append(typeMap.get(type) + ":未知 ");
				}
			}
			resultMap.put(key.toString(), temp.toString());
		}
		return resultMap;
	}
}
