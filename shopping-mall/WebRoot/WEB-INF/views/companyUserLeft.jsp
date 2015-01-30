<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="<%= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
<body>
	<div id="container" style='height:700px;'>
		<div class="w">
			<div id="myjd-shortcut">
				<dl class="myjd-set">
					<dd>
						<a href="#"><span>个人信息</span></a>
						<a href=""><span>账户安全</span></a>
						<a href=""><span>我的级别</span></a>
						<a href=""><span>收货地址</span></a>
						<a href=""><span>分享绑定</span></a>
						<a href=""><span>邮件订阅</span></a>
						<a href=""><span>消费记录</span></a>
						<a href=""><span>应用授权</span></a>
						<a href=""><span>快捷支付</span></a>
						<a href=""><span>增票资质</span></a>
					</dd>
				</dl>
			</div>
			<div id="main">
				<div id="left" class="g-3-5 c-0">
					<div id="menu-new">
						<dl><dt id="_MYJD_setting">设置</dt>
							<dd class="fore1"><div class="item" id="_MYJD_info"><a>个人信息</a></div></dd>
							<dd class="fore2"><div class="item curr" id="_MYJD_safe"><a>账户安全</a></div></dd>
							<dd class="fore3"><div class="item" id="_MYJD_grade"><a>我的级别</a></div></dd>
							<dd class="fore4"><div class="item" id="_MYJD_add"><a>收货地址</a></div></dd>
							<dd class="fore5"><div class="item" id="_MYJD_share"><a>分享绑定</a></div></dd>
							<dd class="fore6"><div class="item" id="_MYJD_rss"><a>邮件订阅</a></div></dd>
							<dd class="fore7"><div class="item" id="_MYJD_recor"><a>消费记录</a></div></dd>
							<dd class="fore8"><div class="item" id="_MYJD_app"><a>应用授权</a></div></dd>
							<dd class="fore9"><div class="item" id="_MYJD_pay"><a>快捷支付</a></div></dd>
							<dd class="fore10 last "><div class="item" id="_MYJD_zpzz"><a>增票资质</a></div></dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>