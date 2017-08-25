window.classicat = new Object();
classicat.ios = "https://itunes.apple.com/app/id1001444595";
classicat.itunes = "https://itunes.apple.com/app/id1001444595";
classicat.android = "http://static.kuke.com/android/kkmusicfm3nd.apk";

function classicatDownload(){
	var is_wx = is_weixin();
	if(browser.versions.ios){
		if(is_wx){
			window.location = "http://mp.weixin.qq.com/mp/redirect?url=" + encodeURI("http://a.app.qq.com/o/simple.jsp?pkgname=com.kkmusicfm");
			//window.location = "http://a.app.qq.com/o/dom/micro/jump.html?jump=http%3A%2F%2Fitunes.apple.com%2Fapp%2Fid1001444595%26tmast%3A%2F%2F";
		}
		else{
			window.location = classicat.ios;
		}
	}
	else if(browser.versions.android){
		if(is_wx){
			showpop();
		}
		else{
			window.location = classicat.android;
		}
	}
	else{
		window.location = classicat.android;
	}
}