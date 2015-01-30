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
<style type="text/css">
	.left{
		width:25%;
		height:500px;
		float:left;
	}
	.center{
		width:75%;
		height:500px;
		float:right;
	}
</style>
</head>
<body>
	<div class="box">
			<iframe id="TopContent" src="<%= request.getContextPath() %>/getTop.shtml" width="100%" height="160px" scrolling="no" marginwidth="0" marginheight="0" frameborder="0"></iframe>
			<div class="left">
				<iframe id="LeftContent" src="<%= request.getContextPath() %>/getUserLeft.shtml" width="320" height="100%"  scrolling="no" marginwidth=0 marginheight=0  frameborder="0"></iframe>
			</div>
			<div class="center">
				<iframe id="MainContent" src="<%= request.getContextPath() %>/user/userManager.shtml" width="100%" height="100%"  scrolling="no" marginwidth=0 marginheight=0  frameborder="0"></iframe>
			</div>
			<iframe id="TopContent" src="<%= request.getContextPath() %>/getBottom.shtml" width="100%" height="300px" scrolling="no" marginwidth="0" marginheight="0" frameborder="0"></iframe>
	</div>
</body>
</html>


