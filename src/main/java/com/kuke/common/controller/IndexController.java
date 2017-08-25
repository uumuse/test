package com.kuke.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/kuke/classicat/")
public class IndexController {
	
	@RequestMapping("index")
	public ModelAndView index(){
		return new ModelAndView("/index.jsp");
	}
}
