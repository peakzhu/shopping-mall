<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人用户</title>
<link href="static/css/layout1.css" rel="stylesheet" type="text/css">
<link href="static/css/style01.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="static/javascript/jquery142.js"></script>
<script type="text/javascript" src="static/javascript/jquery.validate.js"></script>
<script type="text/javascript" src="static/javascript/common.js"></script>
<script type="text/javascript" src="static/javascript/checkOperate.js"></script>
<script type="text/javascript">
	$(document).ready(function(){	
		$("#showDiv").show();
		$("#updateDiv").hide();
	});
	function initCompanyUser(){
		var from =$("#formcompany");
		from.submit();
	}
	$().ready(function() {
		$("#formcompany").validate({
			onsubmit:true,
			rules:{
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
	function updateDiv(type){
		if(type==1){
			$("#showDiv").hide();
			$("#updateDiv").show();
		}else{
			$("#showDiv").show();
			$("#updateDiv").hide();
		}
	}
</script>
</head>
	<body style='background:#ffffff'>
	<div  id="showDiv">
		<table align="center" cellspacing="0" style="width:500px;">	
			<tbody>
				<tr>
					<td colspan='2'><h3>企业账户信息</h3></td>
				</tr> 
				<tr>
					<td class="right">用户名:</td>
					<td class="cleft">${user.userName=='null'?'':user.userName}</td>
				</tr>
				<tr>
					<td class="right">联系人姓名:</td>
					<td class="cleft">${user.contactName=='null'?'':user.contactName}</td>
				</tr>
				<tr>
					<td class="right">所在部门:</td>
					<td class="cleft">${user.deptName='null'?'':user.deptName}</td>
				</tr>
				<tr>
					<td class="right">固定电话:</td>
					<td class="cleft">${user.cTel=='null'?'':user.cTel}</td>
				</tr>
				<tr>
					<td class="right">手机:</td>
					<td class="cleft">${user.cellPhone=='null'?'':user.cellPhone}</td>
				</tr>
				<tr>
					<td class="right">联系人邮箱:</td>
					<td class="cleft">${user.contactMail=='null'?'':user.contactMail}</td>
				</tr>
				<tr>
					<td class='cp-infotitle' colspan='2'><h3>公司信息</h3></td>
				</tr> 
				<tr>
					<td class="right">公司名称:</td>
					<td class="cleft">${user.companyName=='null'?'':user.companyName}</td>
				</tr>
				<tr>
					<td class="right">公司地址:</td>
					<td class="cleft">${user.companyAddress=='null'?'':user.companyAddress}</td>
				</tr>
				<tr>
					<td class="right">企业人数:</td>
					<td class="cleft">${user.companyPeoNum=='null'?'':user.companyPeoNum}</td>
				</tr>
				<tr>
					<td class="right">公司行业:</td>
					<td class="cleft">${user.companyTrade=='null'?'':user.companyTrade}</td>
				</tr>
				<tr>
					<td class="right"><input class="button" type="button" onclick="updateDiv(1)"  value="编辑"></td>
					<td class="cleft"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div  id="updateDiv">
		<form id="formcompany" action="user/updateUser.shtml" method="post">
			<input type="hidden" id="id" name="id"  value="${user.id=='null'?'':user.id }">
			<table align="center" cellspacing="0" width="500px">	
				<tbody>
					<tr>
						<td colspan='2'><h3>账户信息</h3></td>
					</tr> 
					<tr>
						<td class="right"><font color='red'>*</font>用户名:</td>
						<td class="cleft">${user.userName=='null'?'':user.userName}</td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>联系人姓名:</td>
						<td class="cleft"><input type="text" id="contactName" name="contactName"value="${user.contactName=='null'?'':user.contactName}" class="text tip" title="用户名由30位数字字母组成"></td>
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
						<td class="cleft"><input type="text" id="cTel" name="cTel" value="${user.cTel=='null'?'':user.cTel}" class="text tip" title="固定电话格式为010-56349857!"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>手机:</td>
						<td class="cleft"><input type="text" id="cellPhone" name="cellPhone" value="${user.cellPhone=='null'?'':user.cellPhone}" class="text tip" title="手机格式为131****1234!"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>联系人邮箱:</td>
						<td class="cleft"><input type="text" id="contactMail" name="contactMail" value="${user.contactMail=='null'?'':user.contactMail}" class="text tip" title="邮箱格式为pangzg1234@163.com!"></td>
					</tr>
					<tr>
						<td class='cp-infotitle' colspan='2'><h3>公司信息</h3></td>
					</tr> 
					<tr>
						<td class="right"><font color='red'>*</font>公司名称:</td>
						<td class="cleft"><input type="text" id="companyName" name="companyName" value="${user.companyName=='null'?'':user.companyName}" class="text tip" title="公司名称最大长度为50位"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>公司地址:</td>
						<td class="cleft"><input type="text" id="companyAddress" name="companyAddress" value="${user.companyAddress=='null'?'':user.companyAddress}" class="text tip" title="公司地址最大长度为100位"></td>
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
						<td class="right"><input class="button" type="submit"  value="保存"></td>
						<td class="cleft"><input class="button" type="button"  onclick="updateDiv(2)"  value="返回"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	 <script type="text/javascript" src="static/javascript/jquery.poshytip.min.js"></script>
	</body>
</html>