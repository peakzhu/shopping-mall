<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="<%= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>panda平台</title>
<script type="text/javascript" src="static/javascript/jquery142.js"></script>
<link href="static/css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
	.left{
		width:30%;
		height:100%;
		float:left;
	}
	.center{
		width:70%;
		height:100%;
		float:right;
	}
</style>
</head>
<body>
	<div class="box">
			<iframe id="TopContent" target="_parent" src="<%= request.getContextPath() %>/login/getTop.shtml" width="100%" height="300px" scrolling="no" marginwidth="0" marginheight="0" frameborder="0"></iframe>
			<div class="left">
				<iframe id="LeftContent" src="<%= request.getContextPath() %>/login/getLeft.shtml" width="100%" height="100%"  scrolling="no" marginwidth=0 marginheight=0  frameborder="0"></iframe>
			</div>
			<div class="center">
				<iframe id="MainContent" src="<%= request.getContextPath() %>/login/getMain.shtml" width="100%" height="100%"  scrolling="no" marginwidth=0 marginheight=0  frameborder="0"></iframe>
			</div>
	</div>
</body>
</html>


