<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>对眼猫FM</title>
<meta http-equiv="keywords" content="对眼猫FM，对眼猫，胎教音乐，古典音乐,classical music, classical，中国古典音乐,古典音乐下载,古典音乐播放,古典音乐试听,中国音乐,民族音乐,民间音乐,轻音乐,儿童音乐,经典歌曲,舞曲,民族舞蹈,芭蕾,乐器,钢琴,二胡,琵琶,古筝,萨克斯,小提琴,吉他,乐谱,贝多芬,莫扎特,巴赫,FM,fm">
<meta name="description" content="对眼猫FM是库客音乐推出的一款国内主打古典音乐的非流行音乐播放电台,以非流行音乐服务者身份切入，满足个人用户对于大量古典音乐及个性化电台供用户在线收听。">
<link type="text/css" rel="stylesheet" href="/css/wap/common-m.css">
<link type="text/css" rel="stylesheet" href="/css/wap/classicat-m.css">
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/download.js"></script>
<script type="text/javascript">
$(function(){
	$("#download").click(function(){
		var is_wx = is_weixin();
		classicatDownload();
	});
	//滚动时调整遮罩层高度等于文档高度
	$("#pop-bg").height($(document).height());
	$(window).bind("scroll",function(){
		$("#pop-bg").height($(document).height());
	});
	
	//隐藏遮罩层
	$("#pop-bg").click(function(){
		hidepop();
	});
	
	$("#backBtn").click(function(){
		history.back();
	});
});

function showpop(){
	$("#pop-bg").css({"display": "block"});
	$("#popup").css({"display": "block"});
}

function hidepop(){
	$("#pop-bg").css({"display": "none"});
	$("#popup").css({"display": "none"});
}
</script>
</head>
<body class="bg01">
<div class="home">
	<div class="home-tit">
		<h1>对眼猫FM</h1>
		<a href="javascript:void(0)" id="backBtn"></a>
	</div>
	<div class="home-site">
		<img src="/images/wap/cbox-top-pic.png" alt="" width="75" height="75" class="home-site-head">
		<dl>
			<dt>对眼猫</dt>
			<dd>您的音乐新宠</dd>
		</dl>
		<a href="javascript:void(0)" id="download">立刻下载</a>
	</div>
	<div class="slide" id="slider">
		<ul class="clearfix" id="slidelist">
			<li><img src="/images/wap/slidepic01.png" alt="" width="196" height="349"></li>
			<li><img src="/images/wap/slidepic02.png" alt="" width="196" height="349"></li>
			<li><img src="/images/wap/slidepic03.png" alt="" width="196" height="349"></li>
		</ul>
	</div>
	<div class="home-foot">
		<p><img src="/images/wap/logo.png" alt="" width="40"> 库客出品</p>
		<p class="cp">Copyright kuke.com All Rights Reserved</p>
	</div>
</div>
<div id="pop-bg"></div>
<div id="popup"><img src="/images/wap/notice.png" width="100%" alt=""></div>
<script>
function G(id){
	return document.getElementById(id);
}
G("slider").ontouchstart = function(event){
	var	touch =	event.targetTouches[0]; //touches数组对象获得屏幕上所有的touch，取第一个touch
	startPos = {x:touch.pageX,y:touch.pageY,time:+new Date}; //取第一个touch的坐标值
	isScrolling	= 0; //这个参数判断是垂直滚动还是水平滚动
}
G("slider").ontouchmove = function(event){
	if(event.targetTouches.length >	1 || event.scale &&	event.scale	!==	1){
		return false;
	}
	var	touch =	event.targetTouches[0];
	endPos = {x:touch.pageX	- startPos.x,y:touch.pageY - startPos.y};
	isScrolling	= Math.abs(endPos.x) < Math.abs(endPos.y) ?	1 : 0; //isScrolling为1时，表示纵向滑动，0为横向滑动
	if(isScrolling === 0){
		event.preventDefault(); //阻止触摸事件的默认行为，即阻止滚屏
	}
}
var index = 0;
var slidelist = document.getElementById("slidelist").getElementsByTagName("li");
var len = slidelist.length;
G("slider").ontouchend = function(event){
	var	duration = +new	Date - startPos.time; //滑动的持续时间
	if(Number(duration)	> 10){
		//判断是左移还是右移，当偏移量大于10时执行
		if(endPos.x	> 10){ //向右滑动
			if(index == 0){
				index = 1;
			}
			index--;
			startMove(index);
		}else if(endPos.x <	-10){ //向左滑动
			if(index == len - 1){
				index = len - 2;
			}
			index++;
			startMove(index);
		}
	}
}
function startMove(index){
	var moveNum = -196;
	var moveSpeed = 0.5;
	var sWidth = screen.width;
	G("slidelist").style.transform = "translate(" + moveNum * index + "px,0)";
	G("slidelist").style.webkitTransform = "translate(" + moveNum * index + "px,0)";
	G("slidelist").style.mozTransform = "translate(" + moveNum * index + "px,0)";
	if(index == 2){
		moveNum1 = sWidth < 360 ? -300 : -260;
		G("slidelist").style.transform = "translate(" + moveNum1 + "px,0)";
		G("slidelist").style.webkitTransform = "translate(" + moveNum1 + "px,0)";
		G("slidelist").style.mozTransform = "translate(" + moveNum1 + "px,0)";
	}
	G("slidelist").style.transitionDuration = moveSpeed + "s";
	G("slidelist").style.webkitTransitionDuration = moveSpeed + "s";
	G("slidelist").style.mozTransitionDuration = moveSpeed + "s";
}
</script>
</body>
</html>