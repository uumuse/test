<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>${track.ctitle }</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link type="text/css" rel="stylesheet" href="/css/web/common.css">
<link type="text/css" rel="stylesheet" href="/css/web/classicat.css">
<script type="text/javascript">
var lcode = "${lcode}";
</script>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/play/track-play.js"></script>
<script type="text/javascript">
$(function(){
	var flag = true;
	var player = new TrackPlayer();
	player.current_i = curIndex;//解决页面加载后没有触发播放直接下一曲时调到第一曲的问题
	$(".song-play").click(function(){
		if(flag){
			player.mp3_play(curIndex);
			flag = false;
		}
		else{
			player.mp3_play();
		}
	});
	$(".song-pause").click(function(){
		player.mp3_pause();
	});
	$("#next").click(function(){
		player.next_play();
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
					<div class="song">
						<h1>${theme.cname }</h1>
						<div class="song-cd">
							<div><img src="${urlPrefix }${theme.img_min}" alt="" width="450" height="450"></div>
							<a href="javascript:void(0)" class="song-btn song-play"></a>
							<a href="javascript:void(0)" class="song-btn song-pause" style="display:none;"></a>
						</div>
						<div class="song-info-box">
							<p class="clearfix"><span id="played">00:00</span><b>|</b><span id="total">00:00</span><a href="javascript:void(0)" id="next"></a></p>
							<div class="song-info">
								<c:forEach items="${theme.trackList}" var="track" varStatus="status">
									<c:choose>
										<c:when test="${track.l_code == lcode}">
											<dl id="${track.l_code }">
												<input type="hidden" class="track-info" l_code="${track.l_code }" item_code="${track.item_code }" />
												<dt>${track.ctitle }</dt>
												<dd>${track.musician }</dd>
												<dd class="m2">${track.work.ctitle }</dd>
											</dl>
										</c:when>
										<c:otherwise>
											<dl id="${track.l_code }" style="display:none;">
												<input type="hidden" class="track-info" l_code="${track.l_code }" item_code="${track.item_code }" />
												<dt>${track.ctitle }</dt>
												<dd>${track.musician }</dd>
												<dd class="m2">${track.work.ctitle }</dd>
											</dl>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="mh-bt">
					<div class="mh-bt-top"></div>
					<div class="mh-bt-con">
						<div class="mh-bt-site">
							<p class="dl" style="border-top:none;"><a href="/kuke/classicat/index" target="_blank">下载客户端，好音乐一手掌握。</a></p>
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
</html>