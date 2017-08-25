package com.kuke.card.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kuke.card.bean.MusicAlbum;
import com.kuke.card.service.IMusicAlbumService;
import com.kuke.core.base.BaseController;
import com.kuke.util.ImgUrlConst;

@Controller
@RequestMapping("/kuke/classicat")
public class MusicAlbumController extends BaseController {
	@Autowired
	private IMusicAlbumService musicAlbumService;

	@RequestMapping("/musicalbum/{albumId}")
	public ModelAndView show(@PathVariable Long albumId, HttpServletRequest request) {
		MusicAlbum musicAlbum = musicAlbumService.getMusicAlbumById(albumId);
		request.setAttribute("album", musicAlbum);
		request.setAttribute("urlPrefix", ImgUrlConst.APP_IMG_URL);

		weixinShare(request);
		return new ModelAndView("/music-album.jsp");
	}
}
