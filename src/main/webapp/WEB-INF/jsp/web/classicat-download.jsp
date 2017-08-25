<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="mright">
	<div class="cbox">
		<div class="cbox-top clearfix">
			<div class="cbox-top-pic"><a href="/kuke/classicat/index"><img src="/images/web/cbox-top-pic.png" alt="" ></a></div>
			<div class="cbox-top-info">
				<dl>
					<dt>对眼猫</dt>
					<dd>您的音乐新宠</dd>
				</dl>
			</div>
		</div>
		<div class="cbox-bottom clearfix">
			<div class="cbox-bottom-qr"><img src="/images/web/qr.png" alt="" width="136" height="136"></div>
			<div class="cbox-bottom-btn">
				<a href="javascript:void(0)" class="cbtn-iphone">iPhone版下载</a>
				<a href="javascript:void(0)" class="cbtn-android">Android版下载</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="/js/download.js"></script>
<script type="text/javascript">
$(function(){
	$(".cbtn-iphone").click(function(){
		window.location = classicat.itunes;
	});
	
	$(".cbtn-android").click(function(){
		window.location = classicat.android;
	});
})
</script>