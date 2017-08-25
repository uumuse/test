<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>${theme.cname }</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link type="text/css" rel="stylesheet" href="/css/web/common.css">
<link type="text/css" rel="stylesheet" href="/css/web/classicat.css">
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/play/record-play.js"></script>
<script type="text/javascript">
$(function(){
	var player = new RecordPlayer();
	$(".mh-pic-play").click(function(){
		player.mp3_play();
	});
	$(".mh-pic-pause").click(function(){
		player.mp3_pause();
	});
	$(".mh-pic-next").click(function(){
		player.next_play();
	});
	//播放
	$(".cd-play").click(function(){
		var index = $(this).attr("serial");
		player.mp3_play(index);
	});
	//暂停
	$(".cd-pause").click(function(){
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
					<div class="yp">
						<h1>${theme.cname }</h1>
						<div class="mh-pic-box">
							<div class="mh-pic"><img src="${urlPrefix }${theme.img_min}" alt="" width="176" height="176"></div>
							<div class="mh-pic-bg"></div>
							<a href="javascript:void(0)" class="mh-pic-btn mh-pic-play"></a>
							<a href="javascript:void(0)" class="mh-pic-btn mh-pic-pause" style="display:none;"></a>
							<a href="javascript:void(0)" class="mh-pic-next"></a>
						</div>
					</div>
				</div>
				<div class="mh-bt">
					<div class="mh-bt-top bg01"></div>
					<div class="mh-bt-con">
						<c:forEach items="${theme.workList}" var="work" varStatus="status">
							<div class="yp-site">
								<c:choose>
									<c:when test="${status.first == true }">
										<div class="yp-head y1">
											<p>${work.ctitle }</p>
										</div>
									</c:when>
									<c:otherwise>
										<div class="yp-head">
											<p>${work.ctitle }</p>
										</div>
									</c:otherwise>
								</c:choose>
								<div class="yp-site-list">
									<c:forEach items="${work.trackList}" var="track" varStatus="status">
										<div class="mh-playlist m4" l_code="${track.l_code }" item_code="${track.item_code }">
											<div class="mh-btn">
												<a href="javascript:void(0)" class="cd-play play-contr" id="play-${track.l_code }"></a>
												<a href="javascript:void(0)" class="cd-pause play-contr" id="pause-${track.l_code }"  style="display:none;"></a>
											</div>
											<div class="mh-pro">
												<dl>
													<dt>${track.ctitle }</dt>
													<dd>${track.musician }</dd>
												</dl>
												<em></em>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</c:forEach>
						<p class="dl pl02"><a href="/kuke/classicat/index" target="_blank">下载客户端，数字唱片一键收藏。</a></p>
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