package com.kuke.core.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import com.kuke.util.WxUtil;

public class BaseController {
	protected void weixinShare(HttpServletRequest request){
		String url = String.valueOf(request.getRequestURL());
		String query = request.getQueryString();
		if(query!=null){
			url += "?"+query;
		}
		Long timeStamp = System.currentTimeMillis()/1000;
		Map<String, Object> weixin = WxUtil.getSignature(WxUtil.getJsapiTicket(), WxUtil.getRandomStrNum(13), timeStamp.toString(), url);
		request.setAttribute("wx", JSONObject.fromObject(weixin));
	}
}
