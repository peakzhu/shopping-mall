<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="<%= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>随身号码薄</title>
<script type="text/javascript" src="static/javascript/jquery142.js"></script>
<link href="static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function changeframe(url) {
	$(window.parent.document).find("#MainContent").attr("src", url);
}
function login(){
	var aUserName=$("#aUserName").val();
	var aWebPassWord=$("#aWebPassWord").val();
	$.post("account/login.json", {
		"aUserName" : aUserName,
		"aWebPassWord" : aWebPassWord
	}, function(data) {
		var da=eval("(" + data + ")");
		var code=da.code;
		if(code==1){
			$(window.parent.document).find("#LeftContent").attr("src", "login/getLeft1.shtml");
			$(window.parent.document).find("#MainContent").attr("src", "login/getYewu.shtml");
			$(window.parent.document).find("#TopContent").attr("src", "login/getTop.shtml");
		}else if(code==-100){
			alert("用户名错误!");
		}else if(code==-101){
			alert("密码错误!");
		}else if(code==2000){
			alert("用户名或密码为空")
		}
	})
}
function addUser(){
	window.open("../login/getZhuce.shtml","","titlebar=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=720,height=480");
}
function getPassWord(){
	window.open("../login/getZhanghao.shtml","","titlebar=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=720,height=230");
}
</script>
</head>
<body>
	<div class="main">
        <div class="zuo">
         <div class="ding">
           <p><img src="static/images/icon.png" width="26" height="23" />  用户登录：</p>
           <ul>
             <li>用户名：<input class="search" id="aUserName" type="text" /></li>
             <li>密&nbsp;&nbsp;码：<input type="password" class="search" id="aWebPassWord" maxlength="15" /></li>
             <li class="wang"><a href="javascript:void(0);" onclick="getPassWord()">忘记密码 >></a></li>
             <li class="btn"><a href="javascript:void(0);" onclick="login()">登录</a>    <a href="javascript:void(0);" onclick="addUser()">注册</a></li>
           </ul>
         </div>
         
         <div class="ding1">
           <p><img src="static/images/icon2_03.png" width="22" height="23" />  最新动态：</p>
           <p class="p1">116114-0号键 随身号簿全程语音操作超大容量、永不丢失查找便捷、私密性强。资费标准：电话本500条以下功能费3元/月，电
           话本500条以上功能费5元/月。通过随身号簿呼出电话按照市话收费长途每分钟加收0.3元信息费。</p>
         </div>
         <div class="ding2">
           <p><img src="static/images/icon3.png" width="17" height="24" />  客户服务：</p>
           <p class="p1">客 户 热 线：10060</p>
         </div>
	</div>
	</div>
</body>
</html>
