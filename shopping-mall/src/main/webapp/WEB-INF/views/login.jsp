<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<base
	href="<%=request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath()
					+ "/"%>>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Reflect Template">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<title>CP运营平台</title>
<link rel="stylesheet" href="static/css/style.css" type="text/css" media="screen">
<script src="static/javascript/jquery-1.9.1.js"></script>
<style type="text/css">
html {
	background: none repeat scroll 0 0 #484848;
}
</style>
<script type="text/javascript">
	function login() {
		var loginname = $('#loginname').val();
		var password = $('#password').val();
		var code = $('#code').val();
		var type =$("input[name='type'][checked]").val();
		if (name == null || name == '' || name == undefined) {
			$('#errormsg').html('请输入用户名');
			return false;
		}
		if (pass == null || pass == '' || pass == undefined) {
			$('#errormsg').html('请输入密码');
			return false;
		}
		if (code == null || code == '' || code == undefined) {
			$('#errormsg').html('请输入验证码');
			return false;
		}
		$.ajax({
			type:"POST",
			url:"user/login.json",
			data:{loginname:loginname,
				  password:password,
				  code:code,
				  type:type},
			async:false,
			dataType:"json",
			success:function(data){
				alert(data.res);
				window.location.href="everydayCheckError_initView.action";
			}
		});
	}
	$(document).ready(function() {
		$(document).keyup(function(event) {
			if (event.keyCode == 13) {
				login();
			}
		});
		$("#loginname").focus(function() {
			if ($("#loginname").val() == "用户名") {
				$("#loginname").val("");
			}
		});
	});
	function imgUpdate(){
		$("#imgCode").attr(
				"src",
				"/pandas/code/captcha-image?a="
				+ Math.floor(Math.random() * 100));
	}
	function initUser(){
		window.location.href="user/initUser.shtml";
	}
</script>
</head>
<body>
	<div class="bd_div">
		<img src="static/images/bglogin.jpg" />
	</div>
	<div class="content_all">
		<div class="help">
		</div>
			<form action="login/login.shtml" id="login-form" method="post">
				<div class="login_box" style="filter:alpha(opacity=50)">
					<div class="title">pandas平台登陆</div>
					<div class="password_tishi">
						<input type="radio" name='type' value='1'>个人<input type="radio" name='type' value='1'>企业&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					</div>
					<div class="username">
						<input class="form01" id="loginname" type="text" value="用户名" 
											placeholder="用户名" name="loginname"/>
					</div>
					<div class="password">
						<input class="form01" id="password" type="password" value="" name="password" />
					</div>
						<div class="password_tishi">
						<a class="black01" href="#"><font color="black">忘记密码了？</font></a>
					</div>
					<div class="password_tishi">
						<input type="text" id="code" name="code" placeholder="验证码"style="width: 120px; height: 22px; line-height: 22px; border: 1px solid #b2b2b2; float: left; padding: 9px 5px 7px; border-radius: 5px;" />
						<a class="black01" style="float: right;"><img id="imgCode" onclick="imgUpdate()"
							src="/pandas/code/captcha-image" width="100" height="40" /></a>
					</div>
					<div id="errormsg"
						style="color: red; margin-left: 45px; font-size: 12px;">${data.rspmsg}</div>
					<div class="btn">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="42" align="center" valign="middle" onclick="login();"
									style="cursor: pointer"><a><img
										src="static/images/login-btn.fw.png" width="110" height="38" /></a></td>
								<td height="42" align="center" valign="middle" onclick="initUser()"><img
									src="static/images/regist-btn.fw.png" width="110" height="38" /></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
</body>
</html>