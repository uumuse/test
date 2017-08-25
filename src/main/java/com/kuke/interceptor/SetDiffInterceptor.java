package com.kuke.interceptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 设备区分拦截器，区分移动设备和桌面电脑，移动折本访问跳转到wap下页面，桌面电脑访问跳转到web下页面
 * @author chenkuisheng
 *
 */
public class SetDiffInterceptor implements HandlerInterceptor {
	private Logger logger = Logger.getLogger(this.getClass());
	private Pattern tabletSetPtn = Pattern.compile("iTouch|iPad|Tablet|PAD", Pattern.CASE_INSENSITIVE);
	private Pattern phoneSetPtn = Pattern.compile("iPhone|Android|Mobile", Pattern.CASE_INSENSITIVE);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		logger.info(request.getRequestURL());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
		if(modelAndView != null){
			String viewName = modelAndView.getViewName();
			if(viewName.contains("redirect:")){
				return;
			}
			if(!viewName.startsWith("/")){
				viewName = "/" + viewName;
			}
			
			String userAgent = request.getHeader("user-agent");
			logger.info("user-agent: " + userAgent);
			Matcher tablet = tabletSetPtn.matcher(userAgent);
			Matcher phone = phoneSetPtn.matcher(userAgent);
			
			if(tablet.find()){
				modelAndView.setViewName("/web" + viewName);
			}
			else if(phone.find()){
				modelAndView.setViewName("/wap" + viewName);
			}
			else{
				modelAndView.setViewName("/web" + viewName);
			}
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
