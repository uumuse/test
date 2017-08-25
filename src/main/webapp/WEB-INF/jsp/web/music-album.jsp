<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>${album.name }</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link type="text/css" rel="stylesheet" href="/css/web/common.css">
<link type="text/css" rel="stylesheet" href="/css/web/classicat.css">
<script type="text/javascript">var playType = "${album.play_type}"</script>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/play/music-album-play.js"></script>
<script type="text/javascript">
$(function(){
	//相册简介处理
	var albumDesc = $("#album-desc").html();
	if(albumDesc.length > 80){
		albumDesc = albumDesc.substring(0, 80) + "...";
	}
	$("#album-desc").html(albumDesc);
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
});
</script>
</head>
<body>
<div class="wrap">
	<div class="main">
		<div class="mcon clearfix">
			<jsp:include page="classicat-download.jsp"></jsp:include>
			<div class="mleft">
				<div class="mh-con">
					<div class="kp">
						<div class="kp-top">
							<h1>${album.name }</h1>
							<img src="/images/web/logo.png" alt="">
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
							<a href="javascript:void(0)" class="kp-btn kp-play" style="z-index"></a>
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
						<div class="mh-bt-site">
							<h2>音乐列表</h2>
							<c:forEach items="${album.trackList}" var="track" varStatus="status">
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
							</c:forEach>
							<p class="dl"><a href="/kuke/classicat/index" target="_blank">下载客户端，自制音乐卡片，让音乐替你传情~</a></p>
						</div>
					</div>
					<div class="mh-bt-bottom"></div>
				</div>
			</div>
		</div>
		<div class="cbox-foot">
			<p><span><em>@</em>库客音乐</span><span>京ICP证030879号 Copyright kuke.com</span><span>All rights reserved</span></p>
		</div>
	</div>
</div>
<audio src="/mp3/load.mp3" id="playerxEnvXYXWHbCc"> 您的浏览器不支持audio 标签。</audio>
</body>
<script type="text/javascript" src="/js/wowslider.js"></script>
<script type="text/javascript" src="/js/effects.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</html>