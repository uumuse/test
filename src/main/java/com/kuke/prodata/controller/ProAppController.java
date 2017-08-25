package com.kuke.prodata.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kuke.core.base.BaseController;
import com.kuke.core.theme.bean.Theme;
import com.kuke.prodata.service.IProAppService;
import com.kuke.util.ImgUrlConst;

@Controller
@RequestMapping("/kuke/classicat")
public class ProAppController extends BaseController {
	@Autowired
	private IProAppService proAppService;
	
	@RequestMapping("/record/{themeId}")
	public ModelAndView showRecord(@PathVariable Long themeId, HttpServletRequest request){
		Theme theme = proAppService.getThemeForRecord(themeId);
		request.setAttribute("theme", theme);
		request.setAttribute("urlPrefix", ImgUrlConst.APP_IMG_URL);
		
		weixinShare(request);
		return new ModelAndView("/digital-record.jsp");
	}
	
	@RequestMapping("/fm/{fmId}")
	public ModelAndView showFm(@PathVariable Long fmId, HttpServletRequest request){
		Theme theme = proAppService.getThemeForFm(fmId);
		request.setAttribute("theme", theme);
		request.setAttribute("urlPrefix", ImgUrlConst.APP_IMG_URL);
		
		weixinShare(request);
		return new ModelAndView("/fm.jsp");
	}
	
	@RequestMapping("/track/{fmId}")
	public ModelAndView showTrack(@PathVariable Long fmId, HttpServletRequest request){
		Theme theme = proAppService.getThemeForFm(fmId);
		request.setAttribute("theme", theme);
		request.setAttribute("urlPrefix", ImgUrlConst.APP_IMG_URL);
		request.setAttribute("lcode", request.getParameter("lcode"));
		
		weixinShare(request);
		ModelAndView modelAndView = new ModelAndView("/track.jsp");
		return modelAndView;
	}
	
}
