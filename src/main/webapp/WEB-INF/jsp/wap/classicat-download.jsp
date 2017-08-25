<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="mright">
	<div class="cbox">
		<div class="cbox-top clearfix">
			<div class="cbox-top-pic"><a href="/kuke/classicat/index"><img src="/images/wap/cbox-top-pic.png" alt="" width="96" height="96"></a></div>
			<div class="cbox-top-info">
				<dl>
					<dt>对眼猫</dt>
					<dd>您的音乐新宠</dd>
				</dl>
			</div>
		</div>
		<div class="cbox-bottom clearfix">
			<div class="cbox-bottom-qr"><img src="/images/wap/qr.png" alt="" width="98" height="98"></div>
			<div class="cbox-bottom-btn">
				<a href="javascript:void(0)" class="cbtn-iphone" id="classicat-ios-download">iPhone版下载</a>
				<a href="javascript:void(0)" class="cbtn-android" id="classicat-adroid-download">Android版下载</a>
			</div>
		</div>
	</div>
</div>
<div id="pop-bg"></div>
<div id="popup"><img src="/images/wap/notice.png" width="100%" alt=""></div>
<script type="text/javascript">
$(function(){
	$("#classicat-ios-download").click(function(){
		if(browser.versions.android){
			return;
		}
		classicatDownload();
	});

	$("#classicat-adroid-download").click(function(){
		if(browser.versions.ios){
			return;
		}
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