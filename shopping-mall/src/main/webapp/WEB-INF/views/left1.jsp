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
<link href="static/css/style8.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function changeframe(url) {
	$(window.parent.document).find("#MainContent").attr("src", url);
}
function index() {
	$(window.parent.document).find("#MainContent").attr("src", "login/getMain.shtml");
	$(window.parent.document).find("#LeftContent").attr("src", "login/getLeft.shtml");
	$(window.parent.document).find("#TopContent").attr("src", "login/getTop.shtml");
}
function lgout(){
	$.post("login/lgout.json",function(data) {
			if(data=="OK"){
				index();
			}else{
				alert("后台运行出错!");
			}
		})
}
</script>
</head>
<body>
	 <div class="main">
       <div class="zuo">
         <h3>通讯录</h3>
             <ul>
               <li onclick="changeframe('login/getSuoyoulianxi.shtml')"><img src="static/images/icon6.png" width="4" height="8" /><span><a href="javascript:void(0);">所有联系人</a></span></li>
               <li onclick="changeframe('login/getQunzhu.shtml')"><img src="static/images/icon6.png" width="4" height="8" /><span><a href="javascript:void(0);">群组管理</a></span></li>
               <li onclick="changeframe('login/getChazhao.shtml')"><img src="static/images/icon6.png" width="4" height="8" /><span><a href="javascript:void(0);">查找联系人</a></span></li>
               <li onclick="changeframe('login/getKuaijie.shtml')"><img src="static/images/icon6.png" width="4" height="8" /><span><a href="javascript:void(0);">快捷导入</a></span></li>
               <li onclick="changeframe('login/getTianjia.shtml')"><img src="static/images/icon6.png" width="4" height="8" /><span><a href="javascript:void(0);">添加联系人</a></span></li>
             </ul >
         <h3 class="bg">个人信息</h3>
             <ul class="fg">
               <li onclick="changeframe('login/getXinxiweihu.shtml')"><img src="static/images/icon6.png" width="4" height="8" /><span><a href="javascript:void(0);">信息维护</a></span></li>
               <li onclick="changeframe('login/getMima.shtml')"><img src="static/images/icon6.png" width="4" height="8" /><span><a href="javascript:void(0);">密码修改</a></span></li>
               <li onclick="changeframe('login/getXiaohu.shtml')"><img src="static/images/icon6.png" width="4" height="8" /><span><a href="javascript:void(0);">用户销户</a></span></li>
             </ul>
         <h3 class="bh">留言板</h3>
             <ul class="kl">
               <li onclick="changeframe('login/getLiuyan.shtml')"><img src="static/images/icon6.png" width="4" height="8" /><span><a href="javascript:void(0);">我要留言</a></span></li>
             </ul>
             <p><img src="static/images/xian2.png" width="243" height="1" /></p>
             <p><a href="javascript:void(0);" onclick="lgout()">退出登录</a></p>
       </div>
	</div>
</body>
</html>
