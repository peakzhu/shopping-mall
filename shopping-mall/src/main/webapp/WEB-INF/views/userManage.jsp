<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link href="static/css/style01.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="static/javascript/jquery142.js"></script>
<script type="text/javascript" src="static/javascript/common.js"></script>
<script type="text/javascript" src="static/javascript/checkOperate.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	initPageDiv("pageP");
	page(1);
});
//分页
function page(pageNo){
	var loginName = $("#c_loginName").val();
	var nickName = $("#c_nickName").val();
	$.post("user/getUserPage.json", {"loginName":loginName,"nickName":nickName,"curPage":pageNo,"pageSize":1}, function(data) {
		createTable(eval("(" + data + ")"));
	});
}
function createTable(data){
	$page = data.data;
	$('#tbody_user').empty();
	var trStr ="<tr>";
	trStr += "<td class=\"tdtop\">主键id</td>";
	trStr += "<td class=\"tdtop\">登录名</td>";
	trStr += "<td class=\"tdtop\">登录密码</td>";
	trStr += "<td class=\"tdtop\">phone</td>";
	trStr += "<td class=\"tdtop\">email</td>";
	trStr += "</tr>";
	if(data.code==1 && $page.data.length>0){
		$.each($page.data, function(i, cellVaues) {
			trStr += "<tr>";
			trStr += "<td>";
			trStr += cellVaues.id==null?"":cellVaues.id;
			trStr += "</td>";
			trStr += "<td>";
			trStr += cellVaues.loginName==null?"":cellVaues.loginName;
			trStr += "</td>";	
			trStr += "<td>";
			trStr += cellVaues.loginPassWord==null?"":cellVaues.loginPassWord;
			trStr += "</td>";	
			trStr += "<td>";
			trStr += cellVaues.phone==null?"":cellVaues.phone;
			trStr += "</td>";	
			trStr += "<td>";
			trStr += cellVaues.email==null?"":cellVaues.email;
			trStr += "</td>";
			trStr += "</tr>";
		})
		updatePageDiv($page.pageNow, $page.totalPageCount, $page.totalCount, $page.pageSize,"page","pageP");
	}else{
		trStr += "<tr>";
		trStr += "<td class=\"spec\" style=\"text-align:center;\" colspan=\"9\">无数据</td>";
		trStr += "</tr>";
	}
	$('#tbody_user').append(trStr);
}
</script>
</head>
<body class="secWeb">
<div id="titleDiv"class="cp-title">
   <a>用户管理</a>
</div>
<div id="content">
    <div class="jquery_tab">
      <div id="topDiv"class="content_block">
      	<table>
        	<tr height="60px">
	        	<td>
					<span>
		            	<label for="operator-number">登录名</label>
		               	<label>
		                    <input id="c_loginName" class="input-small" />
		                </label>
					</span>
				</td>
				<td>
		            <span>
		                <label for="operator-number">用户昵称</label>
		               	<label>
		                    <input id="c_nickName" class="input-small" />
		                </label>
		            </span>
	          	</td>
            </tr>
	        <tr height="60px">
	           <td colspan="2">
		          <span>
		          	<input class="search"  value="搜索" type="button" onclick="page(1)"/>
		          </span>
		       </td>
	        <tr>
	     </table>
      </div>
      <div id="dataDiv" class="content_block">
            <h2 class="jquery_tab_title"></h2>
            <table id="table_liquid" cellspacing="0" style="color:black">
              <tbody id="tbody_user">
              	<!-- 此处为jquery数据填充区  -->
              </tbody>
            </table>
            <p id="pageP">
            </p>
      </div>
    </div>
</div>
</body>
</html>