<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-itunes-app" content="app-id=1001444595,app-argument=classicat://postcard/${album.id }" />
<title>${album.name }</title>
<link type="text/css" rel="stylesheet" href="/css/wap/common-m.css">
<link type="text/css" rel="stylesheet" href="/css/wap/classicat-m.css">
<link rel="stylesheet" type="text/css" href="/css/wap/wow.css" />
<script type="text/javascript">var playType = "${album.play_type}"</script>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/download.js"></script>
<script type="text/javascript" src="/js/play/music-album-play.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="/js/weixinshare.js"></script>
<script type="text/javascript">
//微信分享支持
function weixin_share_spt(){
	var title = $("#albumName").html();
	var desc = $(".kp-info dl").html();
	var link = window.location.href.split('#')[0]; // 分享链接
	var imgUrl = "${urlPrefix }${album.default_cover }";// 分享图标
	var weixin = ${wx};
	//调取分享方法
	shareWX(title, desc, link, imgUrl, weixin);
}
$(function(){
	//相册简介处理
	var albumDesc = $("#album-desc").html();
	if(albumDesc.length > 80){
		albumDesc = albumDesc.substring(0, 80) + "...";
	}
	$("#album-desc").html(albumDesc);
	
	//微信分享
	var is_wx = is_weixin();
	if(is_wx){
		weixin_share_spt();
	}
	
	var player = new MusicAlbumPlayer();
	$(".kp-play").click(function(){
		player.mp3_play();
	});
	$(".kp-pause").click(function(){
		player.mp3_pause();
	});
	//播放
	$(".mh-play").click(function(){
		var index = $(this).attr("serial");
		player.mp3_play(index);
	});
	//暂停
	$(".mh-pause").click(function(){
		player.mp3_pause();
	});
	$(".mopen").click(function(){
		var url = "classicat://postcard/${album.id}";
		openApp(url);
	});
});
</script>
</head>
<body>
<div class="wrap">
	<div class="main">
		<div class="mcon">
			<div class="mleft">
				<div class="mh-con">
					<div class="kp">
						<div class="kp-top">
							<h1 id="albumName">${album.name }</h1>
							<img src="/images/wap/logo.png" alt="" width="57" height="17">
						</div>
						<div class="kp-play-box">
							<div id="wowslider-container1">
								<div class="ws_images">
									<ul>
										<c:forEach items="${album.coverList}" var="cover" varStatus="status">
											<li>
												<img width="100%" src="${urlPrefix }${cover }" alt="${status.index }" title="${status.index }" id="wows1_${status.index }">
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<a href="javascript:void(0)" class="kp-btn kp-play"></a>
							<a href="javascript:void(0)" class="kp-btn kp-pause" style="display:none;"></a>
						</div>
						<div class="kp-info">
							<dl id="album-desc">
								${album.album_desc }
							</dl>
						</div>
					</div>
				</div>
				<div class="mh-bt">
					<div class="mh-bt-top"></div>
					<div class="mh-bt-con">
						<div class="mh-bt-site" style="border-bottom: 1px solid #d5d5d5;">
							<h2 style="border-bottom:1px solid #d5d5d5;">音乐列表</h2>
							<c:forEach items="${album.trackList}" var="track" varStatus="status">
								<c:choose>
									<c:when test="${status.last == true }">
										<div class="mh-playlist mbb0 clearfix" l_code="${track.l_code }" item_code="${track.item_code }">
											<div class="mh-btn">
												<a href="javascript:void(0)" class="mh-play play-contr" id="play-${track.l_code }"></a>
												<a href="javascript:void(0)" class="mh-pause play-contr" id="pause-${track.l_code }" style="display: none;"></a>
											</div>
											<div class="mh-pro">
												<dl>
													<dt>${track.title }</dt>
													<dd>${track.musician }</dd>
												</dl>
												<em>${status.index + 1 }.</em> <span id="cur-${track.l_code }" style="display: none;"></span>
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<div class="mh-playlist clearfix" l_code="${track.l_code }" item_code="${track.item_code }">
											<div class="mh-btn">
												<a href="javascript:void(0)" class="mh-play play-contr" id="play-${track.l_code }"></a> 
												<a href="javascript:void(0)" class="mh-pause play-contr" id="pause-${track.l_code }" style="display: none;"></a>
											</div>
											<div class="mh-pro">
												<dl>
													<dt>${track.title }</dt>
													<dd>${track.musician }</dd>
												</dl>
												<em>${status.index + 1 }.</em> <span id="cur-${track.l_code }" style="display: none;"></span>
											</div>
										</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<p class="dl" style="border-bottom:none;"><a href="/kuke/classicat/index" target="_blank">下载客户端，自制音乐卡片，让音乐替你传情~</a></p>
						</div>
					</div>
					<div class="mh-bt-bottom"></div>
				</div>
			</div>
			<jsp:include page="classicat-download.jsp"></jsp:include>
		</div>
		<div class="cbox-foot">
			<p><em>@</em>库客音乐&nbsp;&nbsp;京ICP证030879号</p>
			<p class="p1">Copyright kuke.com&nbsp;&nbsp;All rights reserved</p>
		</div>
	</div>
</div>
<jsp:include page="download-float.jsp"></jsp:include>
<audio src="/mp3/load.mp3" id="playerxEnvXYXWHbCc"> 您的浏览器不支持audio 标签。</audio>
</body>
<script type="text/javascript" src="/js/wowslider.js"></script>
<script type="text/javascript" src="/js/effects.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</html>