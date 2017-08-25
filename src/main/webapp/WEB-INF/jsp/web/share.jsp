<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>单曲分享</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link href="../../../css/init.css" rel="stylesheet">
<link href="../../../css/dym.css" rel="stylesheet" id="device">
<script type="text/javascript" src="../../../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../../../js/play/TrackPlayer.js"></script>
<script type="text/javascript" src="../../../js/common.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="../../../js/weixinshare.js"></script>
</head>
<body>
<div class="wrap dpn" id="PC"><!-- PC端单曲分享 -->
	<div class="main">
		<div class="mbox clear">
			<div class="mright">
				<a href="index.html">
					<div class="qrbox">
						<div class="qr"><img src="../../../images/qr.png" width="180" height="180" alt=""></div>
					</div>
				</a>
				<div class="dl clear">
					<div class="dl-list">
						<div><a href="javascript:void(0)" class="dl-iphone" id="ios_download"></a></div>
						<p>版本 1.0.4（14.9MB）</p>
					</div>
					<div class="dl-list">
						<div><a href="javascript:void(0)" class="dl-android" id="android_download"></a></div>
						<p>版本 4.1.0（4.8MB）</p>
					</div>
				</div>
			</div>
			<div class="mleft">
				<div class="cd-pic"><img src="${track.img }" alt="">
					<a href="javascript:void(0)" class="cd-btn cd-play" title="播放" id="cdPlay"></a>
					<a href="javascript:void(0)" class="cd-btn cd-pause" title="暂停" style="display:none;" id="cdPause"></a>
				</div>
				<div class="cd-title">
					<p>${track.title }</p>
				</div>
				<div class="saomiao" id="saomiao">
					<a href="javascript:void(0)">扫描到手机上</a>
					<div class="s-qr dpn" id="sqr"><img src="../../../images/qr.png" width="180" height="180" alt=""></div>
				</div>
			</div>
		</div>
		<div class="foot">
			<p><em>@</em><span>库客音乐</span><span>京ICP证030879号</span><span>Copyright kuke.com All rights reserved</span></p>
		</div>
	</div>
</div>

<div class="wrap dpn" id="Mobile"><!-- 移动端单曲分享 -->
	<div class="dlbox">
		<h1>对眼猫 让音乐找到你</h1>          
		<a href="javascript:void(0)" id="mdl">马上下载</a>
	</div>
	<div class="cdbox">
		<div class="cd-pic1"><img src="${track.img }" width="128" height="128">
			<a href="javascript:void(0)" class="cd-btn1 cd-play1" title="播放" id="cdPlay1" ></a>
			<a href="javascript:void(0)" class="cd-btn1 cd-pause1" title="暂停" style="display:none;" id="cdPause1" ></a>
		</div>
		<div class="cd-title1">
			<p>${track.title }</p>
		</div>
	</div>
	<div class="qrbox1">
		<div class="qrbox1-site clear">
			<div class="qrbox-bg1 qrbox1-left"><img src="../../../images/qr-m.png" alt="" width="66" height="66"></div>
			<div class="qrbox1-right">
				<dl>
					<dt>扫描二维码下载</dt>
					<dd><em>@</em><span>库客音乐</span><span>京ICP证030879号</span><span>Copyright kuke.com</span><span>All rights reserved</span></dd>
				</dl>
			</div>
		</div>
	</div>
	<div id="pop-bg" style="z-index:1;position:fixed;"></div>
	<div id="popup" style="z-index:2;"><img width="100%" alt="" src="http://kuke.com/hd/yuncd/images/notice.png"></div>
</div>
<script>
function weixin_share_spt(){
	var title = "${track.title }";
	var desc =  '${track.musician }';
	var link = window.location.href.split('#')[0]; // 分享链接
	var imgUrl = '${track.img }';// 分享图标
	
	var weixin = ${wx};
	//调取分享方法
	shareWX(title, desc, link, imgUrl, weixin);
}
$(function(){
	var player = new TrackPlayer();
	(function(player){
		var item_code = "${track.item_code }";
		var l_code = "${track.l_code }";
		var labelid = "${track.labelid }";
		var array = new Array();
		array.push(l_code);
		array.push(item_code);
		array.push(labelid);
		player.item_l_code_array.push(array);
	})(player);
	//player.mp3_play(0);
	
	//播放
	$(".cd-play,.cd-play1").on("click", function(){
		player.mp3_play();
	});
	
// 	//暂停
	$(".cd-pause,.cd-pause1").on("click", function(){
		player.mp3_pause();
	});
	
	//微信分享
	var is_wx = is_weixin();
	if(is_wx){
		weixin_share_spt();
	}

});


function G(id){
	return document.getElementById(id);
}

G("ios_download").onclick=function(){
	location.href="https://itunes.apple.com/app/id1001444595"
}

G("android_download").onclick=function(){
	location.href="http://static.kuke.com/android/kkmusicfm3nd.apk"
}
var ua = navigator.platform;
var pc = /macintel|macppc|mac68k|linux i|x11|android/i.test(ua);  
if(!pc){
	G("device").href = "../../../css/dym-m.css";
	G("PC").style.display = "none";
	G("Mobile").style.display = "block";
}else{
	G("device").href = "../../../css/dym.css";
	G("PC").style.display = "block";
	G("Mobile").style.display = "none";
}
G("saomiao").onmouseover = function(){
	G("sqr").style.display = "block";
}
G("saomiao").onmouseout = function(){
	G("sqr").style.display = "none";
}
G("cdPlay").onclick = function(){
	this.style.display = "none";
	G("cdPause").style.display = "block";
}
G("cdPause").onclick = function(){
	this.style.display = "none";
	G("cdPlay").style.display = "block";
}
G("cdPlay1").onclick = function(){
	this.style.display = "none";
	G("cdPause1").style.display = "block";
}
G("cdPause1").onclick = function(){
	this.style.display = "none";
	G("cdPlay1").style.display = "block";
}


var isIPhone = /iPhone/i.test(navigator.userAgent);
var isIPad = /iPad/i.test(navigator.userAgent);
var isAndroid = /android/i.test(navigator.userAgent);
var btndl = document.getElementById("mdl");
//var btnAndroid = document.getElementById("bt19");
//if(isIPhone || isIPad){
//	btnIOS.style.display = "inline-block";
	// IOS 下载地址
//	btnIOS.href = encodeURI("https://itunes.apple.com/cn/app/ku-ke-yin-le/id730228198?mt=8");
//}
//if(isAndroid){
//	btnAndroid.style.display = "inline-block";
	// Indroid 下载地址
//	btnAndroid.href = "http://static.kuke.com/android/kukemusic.apk";
//	btnAndroid.onclick = is_weixn;
//	G("btndl").onclick =function(){
//		location.href="http://static.kuke.com/android/kkmusicfm3nd.apk";
//	}
//}
//if(!/win32|macintel/i.test(navagator.platform)){
	if(isAndroid){
		btndl.onclick =function(){
			location.href="http://static.kuke.com/android/kkmusicfm3nd.apk";
		}
	}
	if(isIPhone){
		btndl.onclick =function(){
			location.href="https://itunes.apple.com/app/id1001444595";
		}
	}
	if(/micromessenger/i.test(navigator.userAgent)){
		btndl.onclick =function(){
			showpop();
		}
	}
	G("pop-bg").onclick = G("popup").onclick = hidepop;
//}
function showpop(){
	document.getElementById('pop-bg').style.display = 'block';
	document.getElementById('popup').style.display = 'block';
}
function hidepop(){
	document.getElementById('pop-bg').style.display = 'none';
	document.getElementById('popup').style.display = 'none';
}
</script>
<audio src="/mp3/load.mp3" id="playerxEnvXYXWHbCc">您的浏览器不支持 audio 标签。</audio>
</body>
</html>