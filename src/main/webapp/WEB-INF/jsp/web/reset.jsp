<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>密码重置</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link href="../../../css/init.css" rel="stylesheet">
<link href="../../../css/dym.css" rel="stylesheet" id="device">
<script type="text/javascript" src="../../../js/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="main">
	<div class="resetbox clear">
		<div class="sleft">
			<h1>对眼猫密码重置</h1>
			<form action="/kuke/classicat/resetPassword">
				<table cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<input type="text" placeholder="密码" class="st01" name="password" id="password">
							<span id="errorNew" style="display:block;height:40px;line-height:40px;"></span>
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" placeholder="确认密码" class="st01" name="rePassword" id="rePassword">
							<span id="errorCNew" style="display:block;height:40px;line-height:40px;"></span>
						</td>
					</tr>
					<input type="hidden" name="email" id="email" value="${email}"   ></input>
					<tr>
						<td><input type="button"  value="提 交" href="javascript:void(0)" onclick="updatePassword()" class="st02"></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="sright"><img src="../../../images/logo.png" alt=""></div>
	</div>
</div>
</body>
<script>
    function isLengthInRange(obj, min, max){
    	slen=getLength(obj);
    	if (slen < min){
    		return false;
    	}else if (slen > max){
    		return false;
    	}else{
    		return true;
    	}
    }
    var obj='';
    function getLength(obj){
    	return obj.replace(/[^x00-xff]/g,"01").length;
    	}
	function checkCPwd() {
		 var message = "";
			var position="";
			opt = true;
		    var newPass = $("#password").val();
			var newCPass = $("#rePassword").val();
			
		if (newPass != newCPass) {
			message = error7;
			position="errorCNew";
			opt = false;
		}
		if (!isLengthInRange(newCPass, 6, 16)) {
			message = error5_1;
			position="errorCNew";
			opt = false;
		}
		if (!isLengthInRange(newPass, 6, 16)) {
			message = error5;
			position="errorNew";
			opt = false;
		}
		
		if (!opt) {
			$("#"+position).html(returnErrorHtml(message));
		} else {
			$("#errorNew").html(returnSureHtml(message));
			$("#errorCNew").html(returnSureHtml(message));
		}
		return opt;
	}
	
	function returnErrorHtml(message) {
		if (null != message) {
			var html = "";
			html += '<span style="color:red;font-size:12px;">' + message + '</span>';
		}
		return html;
	}
	
	function returnSureHtml() {
	}
	
	function updatePassword(){
		var res = checkCPwd();
	    var newPass = $("#password").val();
		var newCPass = $("#rePassword").val();
		var email = "${email}";
		if(res){
			jQuery.ajax({
				type : "POST",
				url : "/kuke/classicat/resetPassword",
				dataType : "json",
				// async:true,
				data : {
					'email' : email,
					'password' : newPass,
					'rePassword' : newCPass
				},
				success : function(res,textStatus) {
					if (res.flag=="true") {
						$("#errorNew").html('');
						$("#errorCNew").html('');
						$("#password").val('');
						$("#rePassword").val('');
						alert("密码修改成功。");
					}else{
						alert(res.msg);
					}
				},
				error : function(textStatus,errorThrown) {
					alert(errorThrown+ "服务器错误！");
				}
			});
		}
	}
	var error1 = "注册失败，请稍后再试！";
	var error2 = "请详细填写必填项！"
	var error3 = "可输入4-16个英文或者2-8个汉字"
	var error4 = "昵称只能由字母、数字或汉字组成！"
	var error5 = "密码长度应该在6-16位字符之间！"
	var error5_1 = "密码长度应该在6-16位字符之间！"
	var error6 = "密码只能由字母和数字组成！"
	var error7 = "两次输入的密码不一致，请重新输入！"
	var error8 = "邮箱地址格式不正确！"	
	var error9 = "昵称名已经存在，请重新输入！"
	var error10 = "邮箱已被使用，请您更换其他邮箱 ！"
	var error11 = "验证码错误！"
	var error12 = "用户名或密码错误！"
	var error13 = "发送失败，请稍后再试！"
	var error14 = "邮箱地址不正确！"

	var error15 = "请填写用户名！";
	var error16 = "请填写密码！";
	var error17 = "请填验证码！";
</script>
</html>