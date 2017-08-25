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
<meta name="apple-itunes-app" content="app-id=1001444595,app-argument=classicat://theme/${theme.id }" />
<title>${theme.cname }</title>
<script type="text/javascript">
var lcode = "${lcode}";
</script>
<link type="text/css" rel="stylesheet" href="/css/wap/common-m.css">
<link type="text/css" rel="stylesheet" href="/css/wap/classicat-m.css">
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/download.js"></script>
<script type="text/javascript" src="/js/play/track-play.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="/js/weixinshare.js"></script>
<script type="text/javascript">
//微信分享支持
function weixin_share_spt(){
	var title = $("#themeName").html();
	var desc = $("#theme-remark").html();
	var link = window.location.href.split('#')[0]; // 分享链接
	var imgUrl = "${urlPrefix }${theme.img_min}";// 分享图标
	
	var weixin = ${wx};
	//调取分享方法
	shareWX(title, desc, link, imgUrl, weixin);
}
$(function(){
	var is_wx = is_weixin();
	if(is_wx){
		weixin_share_spt();
	}
	
	var player = new TrackPlayer();
	$(".song-play").click(function(){
		player.mp3_play(curIndex);
	});
	$(".song-pause").click(function(){
		player.mp3_pause();
	});
	$("#next").click(function(){
		player.next_play();
	});
	$(".mopen").click(function(){
		var url = "classicat://theme/${theme.id}/${lcode}";
		openApp(url);
	});
});
</script>
</head>
<body>
<p id="theme-remark" style="display:none;">${theme.remark }</p>
<div class="wrap">
	<div class="main">
		<div class="mcon">
			<div class="mleft">
				<div class="mh-con">
					<div class="song">
						<h1 id="themeName">${theme.cname }</h1>
						<div class="song-cd">
							<div><img src="${urlPrefix }${theme.img_min}" alt="" width="100%"></div>
							<a href="javascript:void(0)" class="song-btn song-play"></a>
							<a href="javascript:void(0)" class="song-btn song-pause" style="display:none;"></a>
						</div>
						<div class="song-info-box">
							<p class="clearfix">
								<span id="played">00:00</span>
								<b>|</b>
								<span id="total">00:00</span>
								<a href="javascript:void(0)" id="next"></a>
							</p>
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
					<div class="mh-bt-con">
						<div class="mh-bt-site" style="padding:0;">
							<p class="dl"><a href="/kuke/classicat/index" target="_blank">下载客户端，好音乐一手掌握。</a></p>
						</div>
					</div>
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
</html>