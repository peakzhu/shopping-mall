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
function changeframe2(url) {
	var aAccountId=$("#aAccountId").val();
	if(aAccountId!=null&&aAccountId!=""){
		url="login/getLiuyan.shtml"
	}
	$(window.parent.document).find("#MainContent").attr("src", url);
}
function changeframe1() {
	$(window.parent.document).find("#MainContent").attr("src", "login/getMain.shtml");
	$(window.parent.document).find("#LeftContent").attr("src", "login/getLeft.shtml");
}
</script>
</head>
<body>
		 <div class="top">
			<div class="nav">
			  <div class="left"><img src="static/images/logo.png" width="106" height="75" /></div>
			  <div class="right">
				<ul>
				  <li class="txt"onclick="changeframe1()"><a href="javascript:void(0);">首页</a></li>
				  <li><img src="static/images/shu.png" width="1" height="13" /></li>
				  <li class="txt"onclick="changeframe('login/getYewu.shtml')"><a href="javascript:void(0);">业务介绍</a></li>
				  <li><img src="static/images/shu.png" width="1" height="13" /></li>
				  <li class="txt"onclick="changeframe('login/getChangjianwenti.shtml')"><a href="javascript:void(0);">常见问题</a></li>
				  <li><img src="static/images/shu.png" width="1" height="13" /></li>
				  <li class="txt"onclick="changeframe('login/getYonghuzhinan.shtml')"><a href="javascript:void(0);">使用指南</a></li>
				  <li><img src="static/images/shu.png" width="1" height="13" /></li>
				  <li class="txt"onclick="changeframe2('login/getYijian.shtml')"><a href="javascript:void(0);">意见箱</a></li>
				</ul>
			  </div>
			</div>
		 </div>
		<input id="aAccountId" type="hidden" value="${sessionScope.aAccountId }">
		 <div class="banner"><a href="javascript:void(0);"><img src="static/images/banner.png" width="1024" height="212" /></a></div>
</body>
</html>
