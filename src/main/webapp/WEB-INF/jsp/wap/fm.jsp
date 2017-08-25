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
<link type="text/css" rel="stylesheet" href="/css/wap/common-m.css">
<link type="text/css" rel="stylesheet" href="/css/wap/classicat-m.css">
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/download.js"></script>
<script type="text/javascript" src="/js/play/fm-play.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="/js/weixinshare.js"></script>
<script type="text/javascript">
//微信分享支持
function weixin_share_spt(){
	var title = $("#themeName").html();
	var desc = $(".mh-info").find("p").html();
	var link = window.location.href.split('#')[0]; // 分享链接
	var imgUrl = "${urlPrefix }${theme.img_min}";// 分享图标
	
	var weixin = ${wx};
	//调取分享方法
	shareWX(title, desc, link, imgUrl, weixin);
}
$(function(){
	//兆赫简介长度处理
	var remark = $("#remark").html();
	if(remark.length > 80){
		remark = remark.substring(0,80) + "...";
	}
	$("#remark").html(remark)
	
	//微信分享
	var is_wx = is_weixin();
	if(is_wx){
		weixin_share_spt();
	}
	
	var player = new FmPlayer();
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
	$(".mh-play").click(function(){
		var index = $(this).attr("serial");
		player.mp3_play(index);
	});
	//暂停
	$(".mh-pause").click(function(){
		player.mp3_pause();
	});
	
	$(".mopen").click(function(){
		var url = "classicat://theme/${theme.id}";
		openApp(url);
	});
	
});
</script>
</head>
<body>
<div class="wrap">
	<div class="main">
		<div class="mcon clearfix">
			<div class="mleft">
				<div class="mh-con">
					<div class="mh-con-site">
						<h1 id="themeName">${theme.cname }</h1>
						<div class="mh-pic-box">
							<div class="mh-pic"><img src="${urlPrefix }${theme.img_min}" alt="" width="100%"></div>
							<div class="mh-pic-bg"></div>
							<a href="javascript:void(0)" class="mh-pic-btn mh-pic-play"></a>
							<a href="javascript:void(0)" class="mh-pic-btn mh-pic-pause" style="display:none;"></a>
							<a href="javascript:void(0)" class="mh-pic-next"></a>
						</div>
						<div class="mh-info">
							<p id="remark">${theme.remark }</p>
						</div>
					</div>
				</div>
				<div class="mh-bt">
					<div class="mh-bt-top"></div>
					<div class="mh-bt-con">
						<div class="mh-bt-site" style="border-bottom:1px solid #d5d5d5;">
							<h2>正在播放</h2>
							<c:forEach items="${theme.trackList}" var="track" varStatus="status">
								<c:choose>
									<c:when test="${status.first == true }">
										<div class="mh-playlist mbb1 clearfix" id="mh-playlist-${track.l_code }" l_code="${track.l_code }" item_code="${track.item_code }">
											<div class="mh-btn">
												<a href="javascript:void(0)" class="mh-play play-contr" id="play-${track.l_code }"></a>
												<a href="javascript:void(0)" class="mh-pause play-contr" id="pause-${track.l_code }" style="display:none;"></a>
											</div>
											<div class="mh-pro">
												<dl class="st01">
													<dt>${track.ctitle }</dt>
													<dd>${track.musician }</dd>
												</dl>
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<div class="mh-playlist mbb1 clearfix" id="mh-playlist-${track.l_code }" l_code="${track.l_code }" item_code="${track.item_code }" style="display:none;">
											<div class="mh-btn">
												<a href="javascript:void(0)" class="mh-play play-contr" id="play-${track.l_code }"></a>
												<a href="javascript:void(0)" class="mh-pause play-contr" id="pause-${track.l_code }" style="display:none;"></a>
											</div>
											<div class="mh-pro">
												<dl class="st01">
													<dt>${track.ctitle }</dt>
													<dd>${track.musician }</dd>
												</dl>
											</div>
										</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<p class="dl" style="border-bottom:none;"><a href="/kuke/classicat/index" target="_blank">下载客户端，查看更多兆赫详情。</a></p>
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
</html>