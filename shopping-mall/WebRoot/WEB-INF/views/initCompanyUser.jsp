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
			userName: {
				required: true,
				maxlength:30,
				feature:true,
				remote:{
				     url:"companyUser/checkUserName.json",  
	                 type:"post",  
	                 dataType:"html",  
	                 data:{  
	                	 userName:function(){return $("#userName").val();}  
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
			passWord: {
				required:true,
				maxlength:30
			},
			passWordRepeat:{
				required:true,
				maxlength:30,
				equalTo:"#passWord"
			},
			contactName:{
				required:true,
				maxlength:20
			},
			cTel:{
				required:true,
				maxlength:20,
				tel:true
			},
			cellPhone: {
				required:true,
				maxlength:11,
				phone:true,
			},
			contactMail:{
				required:true,
				email:true,
				maxlength:50
			},
			companyName:{
				maxlength:50
			},
			companyAddress:{
				maxlength:100
			}
		},
		messages: {
			userName:{
				required: "用户名不可为空!",
				maxlength: "用户最大长度为30位!",
				feature:"用户名只能由数字字母组成!"
			},
			passWord: {
				required: "密码不可为空!",
				maxlength: "密码最大长度为30位!"
			},
			passWordRepeat:{
				required: "密码不可为空!",
				maxlength: "密码最大长度为30位!",
				equalTo:"俩次输入的密码不一致!" 
			},
			contactName:{
				required: "联系人姓名不可为空!",
				maxlength: "联系人姓名最大长度为20位!"
			},
			cTel:{
				required: "固定电话不可为空!",
				maxlength: "固定电话最大长度为20位!",
				tel:"固定电话格式不正确!"
			},
			cellPhone:{
				required: "手机号码不可为空!",
				maxlength: "手机号码最大长度为11位!",
				phone:"手机号码格式不正确!"
			},
			contactMail:{
				required:"联系人邮箱不可为空!",
				email:"联系人邮箱格式不正确!",
				maxlength:"联系人邮箱最大长度为50位!"
			},
			companyName:{
				maxlength:"公司名称最大长度50!"
			},
			companyAddress:{
				maxlength:"公司地址最大长度100!"
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
	        <li><a href="user/initUser.shtml">个人用户</a></li>
	        <li class="curr">企业用户</li>
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
	<form id="formcompany" action="companyUser/saveCompanyUser.shtml" method="post">
		<table align="center" cellspacing="0" style="width:100%;">	
					<tbody>
					<tr>
						<td class='cp-infotitle' colspan='2'><h3>账户信息</h3></td>
					</tr> 
					<tr>
						<td class="right"><font color='red'>*</font>用户名:</td>
						<td class="cleft"><input type="text" id="userName" name="userName" class="text tip" title="用户名由30位数字字母组成"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>请设置密码:</td>
						<td class="cleft"> <input type="password" id="passWord" name="passWord" class="text tip" title="密码最大长度为30位"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>请确认密码:</td>
						<td class="cleft"><input  type="password" name="passWordRepeat" id="passWordRepeat" class="text tip" title="密码最大长度为30位"></td>
					</tr>
					<tr>
						<td class='cp-infotitle' colspan='2'><h3>联系人信息</h3></td>
					</tr> 
					<tr>
						<td class="right"><font color='red'>*</font>联系人姓名:</td>
						<td class="cleft"><input type="text" id="contactName" name="contactName" class="text tip" title="用户名由30位数字字母组成"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>所在部门:</td>
						<td class="cleft">
							<select rel="select" id="deptName" name="deptName"style="height:28px;">
					             <option value="1">办公室</option>
					           	 <option value="2">市场部</option>
					             <option value="3">采购部</option>
					             <option value="4">技术部</option>
					             <option value="5">人力资源</option>
					             <option value="6">其他</option>
				            </select>
				      	</td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>固定电话:</td>
						<td class="cleft"><input type="text" id="cTel" name="cTel" class="text tip" title="固定电话格式为010-56349857!"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>手机:</td>
						<td class="cleft"><input type="text" id="cellPhone" name="cellPhone" class="text tip" title="手机格式为131****1234!"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>联系人邮箱:</td>
						<td class="cleft"><input type="text" id="contactMail" name="contactMail" class="text tip" title="邮箱格式为pangzg1234@163.com!"></td>
					</tr>
					<tr>
						<td class='cp-infotitle' colspan='2'><h3>公司信息</h3></td>
					</tr> 
					<tr>
						<td class="right"><font color='red'>*</font>公司名称:</td>
						<td class="cleft"><input type="text" id="companyName" name="companyName" class="text tip" title="公司名称最大长度为50位"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>公司地址:</td>
						<td class="cleft"><input type="text" id="companyAddress" name="companyAddress" class="text tip" title="公司地址最大长度为100位"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>企业人数:</td>
						<td class="cleft">
							<select rel="select" id="companyPeoNum" name="companyPeoNum"style="height:28px;">
					            <option value="1">1-49</option>
					            <option value="2">50-99</option>
					            <option value="3">100-499</option>
					            <option value="4">500-999</option>
					            <option value="5">1000以上</option>
				            </select>
            			</td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>公司行业:</td>
						<td class="cleft">
							<select rel="select" id="companyTrade" name="companyTrade"style="height:28px;">
				              	<option value="-1">请选择</option>
					            <option value="1">计算机硬件及网络设备</option>
					            <option value="2">计算机软件</option>
					            <option value="3">IT服务（系统/数据/维护）/多领域经营</option>
					            <option value="4">互联网/电子商务</option>
					            <option value="5">网络游戏</option>
					            <option value="6">通讯（设备/运营/增值服务）</option>
					            <option value="7">电子技术/半导体/集成电路</option>
					            <option value="8">仪器仪表及工业自动化</option>
					            <option value="9">金融/银行/投资/基金/证券</option>
					            <option value="10">保险</option>
					            <option value="11">房地产/建筑/建材/工程</option>
					            <option value="12">家居/室内设计/装饰装潢</option>
					            <option value="13">物业管理/商业中心</option>
					            <option value="14">广告/会展/公关/市场推广</option>
					            <option value="15">媒体/出版/影视/文化/艺术</option>
					            <option value="16">印刷/包装/造纸</option>
					            <option value="17">咨询/管理产业/法律/财会</option>
					            <option value="18">教育/培训</option>
					            <option value="19">检验/检测/认证</option>
					            <option value="20">中介服务</option>
					            <option value="21">贸易/进出口</option>
					            <option value="22">零售/批发</option>
					            <option value="23">快速消费品（食品/饮料/烟酒/化妆品</option>
					            <option value="24">耐用消费品（服装服饰/纺织/皮革/家具/家电）</option>
					            <option value="25">办公用品及设备</option>
					            <option value="26">礼品/玩具/工艺美术/收藏品</option>
					            <option value="27">大型设备/机电设备/重工业</option>
					            <option value="28">加工制造（原料加工/模具）</option>
					            <option value="29">汽车/摩托车（制造/维护/配件/销售/服务）</option>
					            <option value="30">交通/运输/物流</option>
					            <option value="31">医药/生物工程</option>
					            <option value="32">医疗/护理/美容/保健</option>
					            <option value="33">医疗设备/器械</option>
					            <option value="34">酒店/餐饮</option>
					            <option value="35">娱乐/体育/休闲</option>
					            <option value="36">旅游/度假</option>
					            <option value="37">石油/石化/化工</option>
					            <option value="38">能源/矿产/采掘/冶炼</option>
					            <option value="39">电气/电力/水利</option>
					            <option value="40">航空/航天</option>
					            <option value="41">学术/科研</option>
					            <option value="42">政府/公共事业/非盈利机构</option>
					            <option value="43">环保</option>
					            <option value="44">农/林/牧/渔</option>
					            <option value="45">跨领域经营</option>
					            <option value="46">其它</option>
				            </select>
            			</td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>公司性质:</td>
						<td class="cleft">
							<select rel="select" id="companyType" name="companyType" style="height:28px;">
				              	<option value="1">政府机关/事业单位</option>
					            <option value="2">国营</option>
					            <option value="3">私营</option>
					            <option value="4">中外合资</option>
					            <option value="5">外资</option>
					            <option value="6">其他</option>
				            </select>
            			</td>
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