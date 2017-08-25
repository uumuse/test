package com.kuke.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuke.core.cataloguebio.bean.Cataloguebio;
import com.kuke.core.cataloguebio.service.ICataloguebioService;
import com.kuke.util.TrackUtil;

@Controller
@RequestMapping("/kuke/classicat/common/")
public class TrackSrcController {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private ICataloguebioService cataloguebioService;
	
	@ResponseBody
	@RequestMapping("getTrackSrc")
	public Object getTracSrc(HttpServletRequest request){
		String l_code = request.getParameter("l_code");
		String item_code = request.getParameter("item_code");
		String stream_code = "192";
		
		Cataloguebio cataloguebio = cataloguebioService.getCataloguebioById(item_code);
		String labelid = cataloguebio.getLabelid();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("playurl", TrackUtil.getTrackSrc(stream_code, l_code, labelid, item_code));
		log.debug("曲目播放路径：" + TrackUtil.getTrackSrc(stream_code, l_code, labelid, item_code));
		return String.valueOf(JSONObject.fromObject(map));
	}
}
