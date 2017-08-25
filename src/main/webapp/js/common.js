var browser={
	versions:function(){
		var u = navigator.userAgent, app = navigator.appVersion;
		return {         //移动终端浏览器版本信息
			trident: u.indexOf('Trident') > -1, //IE内核
			presto: u.indexOf('Presto') > -1, //opera内核
			webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
			gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
			mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
			ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
			android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或uc浏览器
			iPhone: u.indexOf('iPhone') > -1 , //是否为iPhone或者QQHD浏览器
			iPad: u.indexOf('iPad') > -1, //是否iPad
			webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
		};
	}(),
	
	language:(navigator.browserLanguage || navigator.language).toLowerCase()
}

/**
 * 获得平台类型
 */
function getPlatform (){
	if(browser.versions.ios){
		return "ios";
	}
	else if(browser.versions.android){
		return "android";
	}
	else{
		return "pc";
	}
}

/**
 * 判断是否是用微信打开
 * @returns
 */
function is_weixin(){
	var ua = navigator.userAgent.toLowerCase();
	if(ua.match(/MicroMessenger/i) == "micromessenger"){
		return true;
	}
	else{
		return false;
	}
}

/**
 * 打开手机上安装的app
 * @param url
 */
function openApp(url){
	if(is_weixin()){
		showpop();
		return;
	}
	var start = Date.now();
	var t = 1000;
	var hasApp = true;
	
	var ifr = $('<iframe id="ifr" style="display:none;"></iframe>');
	ifr.attr('src', url);
	$('body').append(ifr);
	
	setTimeout(function(){
		var end = Date.now();
		if(end - start < t + 2000){
			hasApp = false;
		}
	}, t);
	
	setTimeout(function(){
		if(!hasApp){
			var flag = confirm("你还未安装对眼猫FM,是否立即安装?");
			if(flag){
				classicatDownload();
			}
		}
	}, t);
}