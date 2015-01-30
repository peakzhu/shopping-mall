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
				nickName: {
					required: true,
					maxlength:6
				},
				address:{
					maxlength:50
				},
			},
			messages: {
				nickName:{
					required: "昵称不可为空!",
					maxlength: "用户最大长度为6位!"
				},
				address:{
					maxlength:"地址长度为50位!"
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
					<td colspan='2'><h3>账户信息</h3></td>
				</tr> 
				<tr>
					<td class="right">用户名:</td>
					<td class="cleft">${user.loginName=='null'?'':user.loginName}</td>
				</tr>
				<tr>
					<td class="right">昵称:</td>
					<td class="cleft">${user.nickName=='null'?'':user.nickName}</td>
				</tr>
				<tr>
					<td class="right">性别:</td>
					<td class="cleft">${user.sex=='1'?男:女}</td>
				</tr>
				<tr>
					<td class="right">生日:</td>
					<td class="cleft">${user.birthday=='null'?'':user.birthday}</td>
				</tr>
				<tr>
					<td class="right">手机:</td>
					<td class="cleft">${user.phone=='null'?'':user.phone}</td>
				</tr>
				<tr>
					<td class="right">邮箱:</td>
					<td class="cleft">${user.email=='null'?'':user.email}</td>
				</tr>
				<tr>
					<td class="right">地址:</td>
					<td class="cleft">${user.address=='null'?'':user.address}</td>
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
						<td class="cleft">${user.loginName=='null'?'':user.loginName}</td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>昵称:</td>
						<td class="cleft"><input type="text" id="nickName" name="nickName" value="${user.nickName=='null'?'':user.nickName}" class="text tip" title="昵称最多为6个字符"></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>性别:</td>
						<td class="cleft"><input type="radio" name='sex' value='1'>男<input type="radio" name='sex' value='2'>女</td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>生日:</td>
						<td class="cleft"><input type="text" name="birthday" value="${user.birthday=='null'?'':user.birthday}" class="input_time" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>手机:</td>
						<td class="cleft">${user.phone=='null'?'':user.phone}</td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>邮箱:</td>
						<td class="cleft">${user.email=='null'?'':user.email}</td>
					</tr>
					<tr>
						<td class="right"><font color='red'>*</font>地址:</td>
						<td class="cleft"><input type="text" id="address" name="address" value="${user.address=='null'?'':user.address}" class="text tip" title="地址最大长度为50个汉字"></td>
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