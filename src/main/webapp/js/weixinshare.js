//$("head").append("<script type=\"text/javascript\" src=\"http://res.wx.qq.com/open/js/jweixin-1.0.0.js\"></script>");

//新版微信分享抽取方法
function shareWX(title, desc, link, imgUrl, weixin) {
	wx.config({
		debug : false,
		appId : weixin.appId,
		signature : weixin.signature,
		nonceStr : weixin.noncestr,
		timestamp : weixin.timestamp,
		// jsApiList填入的是当前需要使用的接口
		jsApiList : [ 'onMenuShareTimeline', 'onMenuShareAppMessage' ]
	});
	// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
	wx.ready(function() {
		// 分享给朋友
		wx.onMenuShareAppMessage({
			title : title, // 分享标题
			desc : desc, // 分享描述
			link : link, // 分享链接
			imgUrl : imgUrl, // 分享图标
			// dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
			trigger : function(res) {
				// 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			},
			success : function(res) {
			},
			cancel : function(res) {
			},
			fail : function(res) {
				alert(JSON.stringify(res));
			}
		});
		// 分享到朋友圈
		wx.onMenuShareTimeline({
			title : title, // 分享标题
			link : link, // 分享链接
			imgUrl : imgUrl, // 分享图标
			success : function(res) {
			},
			fail : function(res) {
			}
		});
	});
}