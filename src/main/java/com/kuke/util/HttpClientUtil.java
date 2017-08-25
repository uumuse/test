package com.kuke.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpClientUtil {
	
	static Logger  logger = LoggerFactory.getLogger(HttpClientUtil.class);
	
	public static String executePost(String url, Map<String, String> params){
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		if(params != null && !params.isEmpty()){
			for(String key: params.keySet()){
				method.addParameter(new NameValuePair(key, params.get(key)));
			}
		}
		
		String result = "";
		try {
			client.executeMethod(method);
			result = method.getResponseBodyAsString();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			method.releaseConnection();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("lcodes", "0181dx_01|0181dx_02");
		String url = "http://api.kuke.com/api/music/track/list.json";
		String result = HttpClientUtil.executePost(url, params);
		System.out.println(result);
		
	}
}
