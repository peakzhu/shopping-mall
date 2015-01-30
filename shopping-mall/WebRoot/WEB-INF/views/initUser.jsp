<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业用户注册</title>
<link type="text/css" rel="stylesheet" href="static/css/passport.base.css">
<link type="text/css" rel="stylesheet" href="static/css/regist.company.css">
<link href="static/css/layout1.css" rel="stylesheet" type="text/css">
<link href="static/css/style01.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="static/javascript/jquery142.js"></script>
<script type="text/javascript" src="static/javascript/jquery.validate.js"></script>
<script type="text/javascript" src="static/javascript/common.js"></script>
<script type="text/javascript" src="static/javascript/checkOperate.js"></script>
<script type="text/javascript">
$(document).ready(function(){	
	
});
function initCompanyUser(){
	var from =$("#formcompany");
	from.submit();
}
$().ready(function() {
	$("#formcompany").validate({
		onsubmit:true,
		rules:{
			loginName: {
				required: true,
				maxlength:30,
				feature:true,
				remote:{
				     url:"user/checkLoginName.json",  
	                 type:"post",  
	                 dataType:"html",  
	                 data:{  
	                	 loginName:function(){return $("#loginName").val();}  
	                 },  
	                 dataFilter: function(data, type) {  
	                	var date=eval("(" + data + ")").data;
	                    if(date==false){
	                    	return "用户名重复!";
	                    }else if(date==true){
	                    	return true;
	                    }
	                 }
				}
			},
			loginPassWord: {
				required:true,
				maxlength:30
			},
			passWordRepeat:{
				required:true,
				maxlength:30,
				equalTo:"#loginPassWord" 
			},
			phone: {
				required:true,
				maxlength:11,
				phone:true,
			},
			email:{
				required:true,
				email:true,
				maxlength:50
			},
		},
		messages: {
			loginName:{
				required: "用户名不可为空!",
				maxlength: "用户最大长度为30位!",
				feature:"用户名只能由数字字母组成!"
			},
			loginPassWord: {
				required: "密码不可为空!",
				maxlength: "密码最大长度为30位!"
			},
			passWordRepeat: {
				required: "密码不可为空!",
				maxlength: "密码最大长度为30位!",
				equalTo:"俩次输入的密码不一致!" 
			},
			phone:{
				required: "手机号码不可为空!",
				maxlength: "手机号码最大长度为11位!",
				number:"手机号码格式不正确!"
			},
			email:{
				required:"联系人邮箱不可为空!",
				email:"联系人邮箱格式不正确!",
				maxlength:"联系人邮箱最大长度为50位!"
			},
		},
		submitHandler: function(form) { 
			initCompanyUser();
		}
	});
});
function login(){
	window.location.href="login.shtml";
}
</script>
</head>
	<body>
	<div id="shortcut-2013">
	    <div class="w">
	        <ul class="fl lh">
	            <li class="fore1 ld"><b></b><a href="javascript:addToFavorite()" rel="nofollow">收藏京东</a></li>
	        </ul>
	        <ul class="fr lh">
	            <li class="fore1" id="loginbar">您好！欢迎来到京东！<a href="javascript:login()">[登录]</a>&nbsp;<a href="javascript:#">[免费注册]</a></li>
	            <li class="fore2 ld">
	                <s></s>
	                <a href="http://jd2008.jd.com/JdHome/OrderList.aspx" rel="nofollow">我的订单</a>
	            </li>
	            <li class="fore3 ld">
	                <s></s>
	                <a href="http://app.jd.com/" target="_blank">手机京东</a>
	            </li>
	            <li class="fore4 ld menu" id="biz-service" data-widget="dropdown">
	                <s></s>
	                <span class="outline"></span>
	                <span class="blank"></span>
	                客户服务
	                <b></b>
	
	                <div class="dd">
	                    <div><a href="http://help.jd.com/help/question-61.html" target="_blank">常见问题</a></div>
	                    <div><a href="http://myjd.jd.com/repair/orderlist.action" target="_blank" rel="nofollow">售后服务</a>
	                    </div>
	                    <div><a href="http://chat.jd.com/jdchat/custom.action" target="_blank" rel="nofollow">在线客服</a></div>
	                    <div><a href="http://myjd.jd.com/opinion/list.action" target="_blank" rel="nofollow">投诉中心</a></div>
	                    <div><a href="http://www.jd.com/contact/service.html" target="_blank">客服邮箱</a></div>
	                </div>
	            </li>
	            <li class="fore5 ld menu" id="site-nav" data-widget="dropdown">
	                <s></s>
	                <span class="outline"></span>
	                <span class="blank"></span>
	                网站导航
	                <b></b>
	
	                <div class="dd lh">
	                    <dl class="item fore1">
	                        <dt>特色栏目</dt>
	                        <dd>
	                            <div><a target="_blank" href="http://my.jd.com/personal/guess.html">为我推荐</a></div>
	                            <div><a target="_blank" href="http://shipingou.jd.com/">视频购物</a></div>
	                            <div><a target="_blank" href="http://club.jd.com/">京东社区</a></div>
	                            <div><a target="_blank" href="http://xiaoyuan.jd.com/">校园频道</a></div>
	                            <div><a target="_blank" href="http://read.jd.com/">在线读书</a></div>
	                            <div><a target="_blank" href="http://diy.jd.com/">装机大师</a></div>
	                            <div><a target="_blank" href="http://market.jd.com/giftcard/">礼品卡</a></div>
	                        </dd>
	                    </dl>
	                    <dl class="item fore2">
	                        <dt>企业服务</dt>
	                        <dd>
	                            <div><a target="_blank" href="http://market.jd.com/giftcard/company/default.aspx">企业客户</a>
	                            </div>
	                            <div><a target="_blank" href="http://sale.jd.com/p10997.html">办公直通车</a></div>
	                        </dd>
	                    </dl>
	                    <dl class="item fore3">
	                        <dt>旗下网站</dt>
	                        <dd>
	                            <div><a target="_blank" href="http://www.360top.com/">360TOP</a></div>
	                            <div><a target="_blank" href="http://www.minitiao.com/">迷你挑</a></div>
	                            <div><a target="_blank" href="http://en.360buy.com/">English Site</a></div>
	                        </dd>
	                    </dl>
	                </div>
	            </li>
	        </ul>
	        <span class="clr"></span>
	    </div>
	</div>
	
	<div class="w" id="logo">
	    <div><a href="http://www.jd.com/"><img src="./注册-企业用户_files/logo-2013.png" alt="pandas商城" width="170" height="60"></a> <b></b>
	    </div>
	</div>
	
	<div class="w" id="regist">
	<div class="mt">
	    <ul class="tab">
	        <li class="curr">个人用户</li>
	        <li><a href="companyUser/initCompanyUser.shtml">企业用户</a></li>
	    </ul>
	    <div class="extra">
	        <span>我已经注册，现在就&nbsp;<a href="login.shtml" class="flk13">登录</a></span>
	    </div>
	</div>
	<div class="mc">
	
	<div id="superior">
	    <dl>
	        <dt>专享服务</dt>
	        <dd>        
	            1. 采购流程化；<br>
				2. 价格透明化；<br>
				3. 服务一体化；<br>
				4. 信息系统化；
	        </dd>
	    </dl>
	
	    <dl>
	        <dt>四大特权</dt>
	        <dd>        	
				1. 专属VIP客服，专属客户经理；<br>
				2. 专属采购频道，专属活动特权；<br>
				3. 采购合同签订，增值税票开具；<br>
				4. 批量采购，产品定制需求；<br>
				<b>为您提供全方位的服务！</b>
	        </dd>
	    </dl>
	
	    <dl>
	        <dt>服务须知</dt>
	        <dd>
				我们的审核时限为24小时（工作日），遇法定节假日顺延。<br>
				如您对企业用户注册有疑问，或有批量采购需求，<br>
				请拨打企业专享热线：400-656-0055或<a href="http://giftcard.jd.com/company/index" target="_blank" class="flk13">留言咨询</a>。
	        </dd>
	    </dl>
	</div>
	<form id="formcompany" action="user/saveUser.shtml" method="post">
		<table align="center" cellspacing="0" style="width:100%;">	
					<tbody>
					<tr>
						<td class='cp-infotitle' colspan='2'><h3>账户信息</h3></td>
					</tr> 
					<tr>
						<td class="right"><font color='red'>*</font>用户名:</td>
						<td class="cleft"><input type="text" id="loginName" name="loginName" class="text tip" title="用户名由30位数字字母组成"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>请设置密码:</td>
						<td class="cleft"> <input type="password" id="loginPassWord" name="loginPassWord" class="text tip" title="密码最大长度为30位"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>请确认密码:</td>
						<td class="cleft"><input  type="password" name="passWordRepeat" id="passWordRepeat" class="text tip" title="密码最大长度为30位"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>手机:</td>
						<td class="cleft"><input type="text" id="phone" name="phone" class="text tip" title="手机格式为131****1234!"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>邮箱:</td>
						<td class="cleft"><input type="text" id="email" name="email" class="text tip" title="邮箱格式为pangzg1234@163.com!"></td>
					</tr>
					<tr>
						<td class="right" colspan='2'  style="text-align:center"><input type="submit" class="btn-img btn-regist" id="registsubmit" value="立即注册"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	</div>
	<div class="w">
	    <div id="footer-2013">
	        <div class="links"><a rel="nofollow" target="_blank" href="http://www.jd.com/intro/about.aspx">关于我们</a>|<a rel="nofollow" target="_blank" href="http://www.jd.com/contact/">联系我们</a>|<a rel="nofollow" target="_blank" href="http://zhaopin.jd.com/">人才招聘</a>|<a rel="nofollow" target="_blank" href="http://www.jd.com/contact/joinin.aspx">商家入驻</a>|<a rel="nofollow" target="_blank" href="http://www.jd.com/intro/service.aspx">广告服务</a>|<a rel="nofollow" target="_blank" href="http://app.jd.com/">手机京东</a>|<a target="_blank" href="http://club.jd.com/links.aspx">友情链接</a>|<a target="_blank" href="http://cps.jd.com/">销售联盟</a>|<a href="http://club.jd.com/" target="_blank">京东社区</a>|<a href="http://gongyi.jd.com/" target="_blank">京东公益</a></div>
	        <div class="copyright">Copyright&#169;2004-2014&nbsp;&nbsp;京东JD.com&nbsp;版权所有</div>
	    </div>
	</div>
	 <script type="text/javascript" src="static/javascript/jquery.poshytip.min.js"></script>
	</body>
</html>