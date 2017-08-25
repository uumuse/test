package com.kuke.prodata.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuke.core.base.BaseController;
import com.kuke.prodata.service.impl.ShareService;
import com.kuke.resetPassword.service.impl.ResetPasswordService;


@Controller
@RequestMapping("/kuke/classicat")
public class ShareController extends BaseController {
	
	@Autowired
	private ShareService shareService;
	
	@Autowired
	private ResetPasswordService resetPasswordService;
	
	/***
	 * 对眼猫首页
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("/index_new.jsp");
	}
	
	/***
	 * 单曲分享
	 * @param l_code
	 * @param workid
	 * @param item_code
	 * @param request
	 * @return
	 */
    @RequestMapping("/trackInfo")
//    @ResponseBody
	public ModelAndView shareTrack(String l_code,String workid,String item_code,HttpServletRequest request){
    	List<Map<String, Object>> list = shareService.getTrackInfo(l_code, workid, item_code);
    	if(!list.isEmpty()){
    		weixinShare(request);
    		request.setAttribute("track", list.get(0));
    		return	new ModelAndView("/share.jsp");
    	}else{
    		return null;
    	}
	}
    
    @RequestMapping("/reset")
    public ModelAndView reset(HttpServletRequest request){
    	String email = request.getParameter("email");
    	request.setAttribute("email", email);
    	return new ModelAndView("/reset.jsp");
    }
    
    @RequestMapping("/resend")
    public ModelAndView resend(HttpServletRequest request){
    	return new ModelAndView("/resend.jsp");
    }
    
    @RequestMapping("/resetPassword")
    @ResponseBody
    public Object resetPassword(HttpServletRequest request){
    	Map<String, Object> map = new HashMap<String, Object>();
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String rePassword = request.getParameter("rePassword");
    	if(password.equals("")||rePassword.equals("")||(password.equals("")&&rePassword.equals(""))){
    		map.put("flag", false);
    		map.put("msg", "密码不能为空");
    	}
    	else if(!password.equals(rePassword)){
    		map.put("flag", false);
    		map.put("msg", "两次密码输入不一致");
    	}
    	if(password.equals(rePassword)&&!password.equals("")&&!rePassword.equals("")){
    		List<Map<String, String>> list = resetPasswordService.userList(email);
    		if(!list.isEmpty()){
    			String userId = String.valueOf(list.get(0).get("id"));
    			String originPassword = String.valueOf(list.get(0).get("password"));
    			if(originPassword.equals(password)){
    				map.put("flag", false);
    				map.put("msg", "密码未做修改");
    			}else{
    				try {
    					resetPasswordService.resetUser(userId,password);
    					map.put("flag", true);
    					map.put("msg", "重置成功");
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		}else{
    			map.put("flag", false);
				map.put("msg", "邮箱不存在");
    		}
    	}
    	return map;
//    	request.setAttribute("msg", JSONObject.fromObject(map));
//    	return new ModelAndView("/reset.jsp");
    }
}
