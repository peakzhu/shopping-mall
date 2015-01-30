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
<link type="text/css" rel="stylesheet" href="static/css/base.css">
<link type="text/css" rel="stylesheet" href="static/css/myjd.common.css">
<link type="text/css" rel="stylesheet" href="static/css/myjd.safe.css">
<script type="text/javascript">
function changeframe(url) {
	$(window.parent.document).find("#MainContent").attr("src", url);
}
</script>
</head>
<style>
	a{
		text-decoration:none;
		color:black;
	}
	a:hover {
		text-decoration:none;
		color:black;
	}
	
</style>
<body style="background: none repeat scroll 0 0 #f2f2f2;">

</body>
</html>
