<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>对眼猫FM首页</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link href="../../../css/init.css" rel="stylesheet">
<link href="" rel="stylesheet" id="device">
<script type="text/javascript" src="../../../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../../../js/jquery.qrcode.min.js"></script>
</head>
<body>
<div class="wrap dpn" id="PC" style="background:#ffffff url(/images/infobox-bg.jpg) repeat-x 0 540px;"><!-- PC端首页 -->
	<div class="main">
		<div class="mbox pb48 clear">
			<div class="mright">
				<div class="qrbox">
					<div class="qr"><img src="../../../images/qr.png" width="180" height="180" alt="" id="qrcode"></div>
				</div>
				<div class="dl clear">
					<div class="dl-list">
						<div><a href="javascript:void(0)" class="dl-iphone" id="ios_download"></a></div>
						<p>版本 1.0.4（14.9MB）</p>
					</div>
					<div class="dl-list">
						<div><a href="javascript:void(0)" class="dl-android" id="android_download"></a></div>
						<p>版本 5.0.0（3.98MB）</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="infobox">
		<div class="main">
			<ul class="infolist clear">
				<li><img src="../../../images/info1.png" alt=""></li>
				<li><img src="../../../images/info2.png" alt=""></li>
				<li><img src="../../../images/info3.png" alt=""></li>
			</ul>
			<div class="foot s1">
				<p><em>@</em><span>库客音乐</span><span>京ICP证030879号</span><span>Copyright kuke.com All rights reserved</span></p>
			</div>
		</div>
	</div>
	<img src="../../../images/a1.png" alt="" class="a1">
	<img src="../../../images/a2.png" alt="" class="a2">
	<img src="../../../images/a3.png" alt="" class="a3">
</div>

<div class="wrap pt54 dpn" id="Mobile"><!-- 移动端首页 -->
	<div class="bg" id="bg"></div>
	<div class="dlbox" style="width:92%;margin:0 auto;border:1px solid #b4b4b4;border-radius:5px;">
		<h1>对眼猫 让音乐找到你</h1>
		<a href="javascript:void(0)" id="mdownload">马上下载</a>
	</div>
	<div class="swipe">
		<ul class="clear" id="swipe">
			<li><img src="../../../images/swipe01.png" alt="" width="239"></li>
			<li><img src="../../../images/swipe02.png" alt="" width="239"></li>
			<li><img src="../../../images/swipe03.png" alt="" width="239"></li>
		</ul>
	</div>
	<p class="foot"><em>@</em><span>库客音乐</span><span>京ICP证030879号</span><span>Copyright kuke.com</span><span>All rights reserved</span></p>
	<div id="pop-bg" style="z-index:1;position:fixed;"></div>
	<div id="popup" style="z-index:2;"><img width="100%" alt="" src="http://kuke.com/hd/yuncd/images/notice.png"></div>
</div>
<script>
G("pop-bg").onclick = G("popup").onclick = hidepop;
function G(id){
	return document.getElementById(id);
}

G("ios_download").onclick=function(){
	location.href="https://itunes.apple.com/app/id1001444595"
}

G("android_download").onclick=function(){
	//location.href="http://static.kuke.com/android/kkmusicfm3nd.apk"
	location.href="http://static.kuke.com/android/kkmusicfm.apk";
}

var ua = navigator.platform;
var pc = /win32|macintel|macintosh|android/i.test(navigator.platform);
if(!pc){
	G("device").href = "../../../css/dym-m.css";
	G("PC").style.display = "none";
	G("Mobile").style.display = "block";
	swipeNum();
}else{
	G("device").href = "../../../css/dym.css";
	G("PC").style.display = "block";
	G("Mobile").style.display = "none";
}
var ua1 = navigator.userAgent;
var isWeixin = /micromessenger/i.test(ua1);
var isAndroid = /android/i.test(ua1);
var isIphone = /ipod|iphone|ipad/i.test(ua1);
if(isWeixin){
	G('mdownload').onclick = function(){
		showpop();
	}
}else{
	if(isAndroid){
		G('mdownload').onclick = function(){
			location.href="http://static.kuke.com/android/kkmusicfm.apk";
		}
	}else if(isIphone){
		G('mdownload').onclick = function(){
			location.href="https://itunes.apple.com/app/id1001444595"
		}
	}
}

var swipeY;
function swipeNum(){ //左右滑动
	G("swipe").ontouchstart = function(event){
		var	touch =	event.targetTouches[0]; //touches数组对象获得屏幕上所有的touch，取第一个touch
		startPos = {x:touch.pageX,y:touch.pageY,time:+new Date}; //取第一个touch的坐标值
		isScrolling	= 0; //这个参数判断是垂直滚动还是水平滚动
		swipeY = true;
	}
	G("swipe").ontouchmove = function(event){
		if(event.targetTouches.length <	1 || event.scale &&	event.scale	!==	1){
			return false;
		}
		var	touch =	event.targetTouches[0];
		endPos = {x:touch.pageX	- startPos.x,y:touch.pageY - startPos.y};
		isScrolling	= Math.abs(endPos.x) < Math.abs(endPos.y) ?	1 : 0; //isScrolling为1时，表示纵向滑动，0为横向滑动
		if(isScrolling === 0){
			event.stopPropagation();
			event.preventDefault(); //阻止触摸事件的默认行为，即阻止滚屏
			swipeY = false;
		}
	}
	var index = 0;
	var swipelist = document.getElementById("swipe").getElementsByTagName("li");
	var len = swipelist.length;
	G("swipe").ontouchend = function(event){
		var	duration = +new	Date - startPos.time; //滑动的持续时间
		if(Number(duration)	> 10){
			
			//判断是左移还是右移，当偏移量大于10时执行
			var moveNum = G("swipe").children[0].clientWidth;
			var moveSpeed = 1;
			if(endPos.x	> 10){ //向右滑动
				swipeY = false;
				if(screen.width <= G("swipe").clientWidth){
					if(index == 1){
						G("swipe").style.transform = "translate(" + 0 + "px,0)";
						G("swipe").style.webkitTransform = "translate(" + 0 + "px,0)";
						G("swipe").style.mozTransform = "translate(" + 0  + "px,0)";
						G("swipe").style.transitionDuration = moveSpeed + "s";
						G("swipe").style.webkitTransitionDuration = moveSpeed + "s";
						G("swipe").style.mozTransitionDuration = moveSpeed + "s";
						index = 0;
					}
					if(index == 2){
						G("swipe").style.transform = "translate(" + -moveNum + "px,0)";
						G("swipe").style.webkitTransform = "translate(" + -moveNum + "px,0)";
						G("swipe").style.mozTransform = "translate(" + -moveNum  + "px,0)";
						G("swipe").style.transitionDuration = moveSpeed + "s";
						G("swipe").style.webkitTransitionDuration = moveSpeed + "s";
						G("swipe").style.mozTransitionDuration = moveSpeed + "s";
						index = 1;
					}
				}
			}else if(endPos.x <	-10){ //向左滑动
				swipeY = false;
				if(screen.width <= G("swipe").clientWidth){
					index++;
					if(index == 3){
						index = 2;
					}
					G("swipe").style.transform = "translate(" + -moveNum*index + "px,0)";
					G("swipe").style.webkitTransform = "translate(" + -moveNum*index + "px,0)";
					G("swipe").style.mozTransform = "translate(" + -moveNum*index  + "px,0)";
					G("swipe").style.transitionDuration = moveSpeed + "s";
					G("swipe").style.webkitTransitionDuration = moveSpeed + "s";
					G("swipe").style.mozTransitionDuration = moveSpeed + "s";
				}
			}
		}
	}
}

var ua1 = navigator.userAgent;
var isWeixin = /micromessenger/i.test(ua1);
var isAndroid = /android/i.test(ua1);
var isIphone = /ipod|iphone|ipad/i.test(ua1);
if(isWeixin){
	G('mdownload').onclick = function(){
		showpop();
	}
}else{
	if(isAndroid){
		G('mdownload').onclick = function(){
			location.href="http://static.kuke.com/android/kkmusicfm.apk";
		}
	}else if(isIphone){
		G('mdownload').onclick = function(){
			location.href="https://itunes.apple.com/app/id1001444595"
		}
	}
}
function showpop(){
	document.getElementById('pop-bg').style.display = 'block';
	document.getElementById('popup').style.display = 'block';
}
function hidepop(){
	document.getElementById('pop-bg').style.display = 'none';
	document.getElementById('popup').style.display = 'none';
}
</script>
</body>
</html>