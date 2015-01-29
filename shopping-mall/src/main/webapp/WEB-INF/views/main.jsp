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
<link href="static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function changeframe(type) {
	if(type==1){
		$(window.parent.document).find("#MainContent").attr("src", "login/getYonghuzhinan.shtml");
	}else{
		$(window.parent.document).find("#MainContent").attr("src", "login/getChangjianwenti.shtml");
	}
}
	
</script>
</head>
<body>
	<div class="main">
	 <div class="you">
          <div class="shang">
            <ul>
              <li class="li"><img src="static/images/icon4.png" width="25" height="20" />  随身号簿业务:</li>
              <li><img src="static/images/xian.png" width="672" height="1" /></li>
              <li class="img"><a href="javascript:void(0);"><img src="static/images/img.png" width="637" height="224" /></a></li>
            </ul>
          </div>
          
          <div class="center">
            <ul>
              <li class="li"><img src="static/images/icon5.png" width="28" height="24" />  随身号簿操作流程:</li>
              <li><img src="static/images/xian.png" width="672" height="1" /></li>
              <li class="img"></li>
            </ul>
            <ul class="img3">
              <li><a href="javascript:void(0);" onclick="changeframe(1)"><img src="static/images/img2.png" width="175" height="106" /></a></li>
              <li><a href="javascript:void(0);" onclick="changeframe(1)"><img src="static/images/img3.png" width="175" height="106" /></a></li>
              <li><a href="javascript:void(0);" onclick="changeframe(1)"><img src="static/images/img4.png" width="156" height="111" /></a></li>
            </ul>
          </div>
          
          <div class="bottom">
           <h3 class="li"><img src="static/images/icon4.png" width="25" height="20" />  常见问题解答:</h3>
           <span><img src="static/images/xian.png" width="672" height="1" /></span>
            <ul>
              <li><a href="javascript:void(0);" onclick="changeframe(2)">1.问：用户使用其它电话是否可以使用自己的语音<br />电话本？</a></li>        
              <li><a href="javascript:void(0);" onclick="changeframe(2)">2.问：语音输入错误时应如何解决？</a></li>
              <li><a href="javascript:void(0);" onclick="changeframe(2)">3.问：使用随身号簿过程中哪些流程是需要通过<br />按键实现的？</a></li>
              <li><a href="javascript:void(0);" onclick="changeframe(2)">4.问：是否可以查询其它电话号中储存的联系人？</a></li>
              <li><a href="javascript:void(0);" onclick="changeframe(2)">5.问：为什么有时联报出联系人姓名，系统无法识<br />别？</a></li>
            </ul>
            <ul class="nuo">
              <li><a href="javascript:void(0);" onclick="changeframe(2)">6.问：如何进行开户、销户？</a></li>        
              <li><a href="javascript:void(0);" onclick="changeframe(2)">7.问：如何进行密码设置？</a></li>
              <li><a href="javascript:void(0);" onclick="changeframe(2)">8.问：如何进行用户资料的删除或修改？</a> </li>
              <li><a href="javascript:void(0);" onclick="changeframe(2)">9.问：系统是否识别多音字？</a></li>
              <li><a href="javascript:void(0);" onclick="changeframe(2)">10.问：为什么下载批量导入的文件模板在编辑完<br />成后，无法导入？</a></li>
            </ul>
          </div>
        </div>
       </div>
</body>
</html>
