<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>商城</title>

<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/index.css">

<style>
/*注释*/
#searchDiv{
position:absolute;
top:-43px;
left:50px;
}
#searchTip{
display:block;
color: #AAAAAA;
height:35px;
line-height:35px;
margin-top:4px;
margin-bottom: -31px;
margin-right:10px;
}
#keyWord{
height:35px;
line-height:35px;
background: transparent;
width: 305px;
position:relative;
right:50px;
right:50px\9;
*right:10px;
top:-5px;
} 

</style>
<script type="text/javascript">

$(function(){	
	initPage(); 
	bind_method();
	changeSearch();
})


//左侧列表移入移出效果
function trmall_tree_mouse(){
	$('.trmall_news li').mouseover(function(){
		//$(this).css({background:'#7ac6f8'});
		$(this).children('div').css({display:'block'});
		$(this).children('span').children('i').css({background:'url(images/next_white.png) no-repeat left top'});
		$(this).children('span').children('a').css({color:'#fff'});
																			 
	});
	$('.trmall_news li').mouseout(function(){
		$(this).children('div').css({display:'none'});	
		//$(this).css({background:'none'});
		$(this).children('span').children('a').css({color:'#333'});	
		$(this).children('span').children('i').css({background:'url(images/next_gray.png) no-repeat left top'});
			
	});
};



function bind_method(){
	$("#keyWord").focus(function(){
		$("#keyWord").css("background","#FFFFFF");
	});
	$("#keyWord").blur(function(){
		if($("#keyWord").val()==""){
			$("#keyWord").css("background","transparent");
		}
	});
	$('.trmall_top').on('click','#top_notifier',function(){
		parent.location.href="#";
	});
	$('.trmall_top').on('click','#top_logout',function(){
		parent.location.href="#";
	});
	$("input[name='searchType']").click(function(){
		changeSearch();
	});
	

	$('#searchButton').click(function(){
		if(user!= null){
			$('#queryForm').submit();
		}else{
			window.location.href="#";
		}
	});
	$('.cartbox').hover(function(){
		initShopCart();
		$('.cart_list').show();	
		$('.cartbox ul').addClass('cart_hover');
		$('.cartbox ul li b').addClass('cart_up');
	},function(){
		$('.cart_list').hide();
		$('.cartbox ul').removeClass('cart_hover');
		$('.cartbox ul li b').removeClass('cart_up');
	})
}


function changeSearch(){
	if($("input[name='searchType']:checked").val()=='shop'){
		$('.tramll_frame span').text('店铺');
		$("#queryForm").attr('action','#');
	}else{
		$('.tramll_frame span').text('商品');
		$("#queryForm").attr('action','#');
	}
}

function initPage(){
	$('.items').hover(function(){
		$(this).find('a').animate({left:'-10px'},500);						  
	},function(){
		$(this).find('a').animate({left:'0px'},500);	
	})
	$('.nav_list li').hover(function(){
		$(this).children().show();						  
	},function(){
		$(this).find('span').hide()	
	})	
}

var timeout = 300;
var trmall_closetimer = 0;
var trmall_ddmenuitem = 0;
function mopen(id)
{	
	trmall_mcancelclosetime();
	if(trmall_ddmenuitem) trmall_ddmenuitem.style.visibility = 'hidden';

	trmall_ddmenuitem = document.getElementById(id);
	trmall_ddmenuitem.style.visibility = 'visible';

}
function mclose()
{
	if(trmall_ddmenuitem) trmall_ddmenuitem.style.visibility = 'hidden';
}
function trmall_mclosetime()
{
	trmall_closetimer = window.setTimeout(mclose, timeout);
}
function trmall_mcancelclosetime()
{
	if(trmall_closetimer)
	{
		window.clearTimeout(trmall_closetimer);
		trmall_closetimer = null;
	}
}
document.onclick = mclose; 

</script>
</head>
<body>
<!-- ware -->
<div class="trmall_ware">
	<div class="trmall_top">
    </div>
     <div class="trmall_topright">
       <ul class="trmall_sddm">
				<li>您好，欢迎来到xx商城。请&nbsp;<a href="#">登陆 | </a></li>
				<li><a href="#">&nbsp;注册 | </a><div></div></li>
				<li><a href="#">&nbsp;我的订单 | </a></li>
				<li><a href="#" onmouseover="mopen('m1')" onmouseout="trmall_mclosetime()">&nbsp;服务中心 | </a>
				  <div id="m1" onmouseover="trmall_mcancelclosetime()" onmouseout="trmall_mclosetime()">
					<a href="#">帮助中心</a>
					<a href="#">在线客服</a>
					<a href="#">投诉中心</a>
					<a href="#">客服邮箱</a>
					</div>
				</li>
				<li><a href="#" onmouseover="mopen('m2')" onmouseout="trmall_mclosetime()">&nbsp;收藏夹 </a>
				  <div id="m2" onmouseover="trmall_mcancelclosetime()" onmouseout="trmall_mclosetime()">
					<a href="#">收藏的宝贝</a>
					<a href="#">收藏的店铺</a>
					</div>
				</li>
			</ul>
      </div>
	<div class="clear"></div>
<!-- 头部搜索 -->
<div class="trmall_head">
		<div class="trmall_heimg f_left">
			<a href="/CUCooperate">
			<!-- <img src="/CUCooperate/images/jygoods_02.png" alt="农校对接服务网"/> -->	
			</a>
		</div>
		<div class="trmall_hcenter f_left">
			<form id="queryForm" method="post" onsubmit="return mySubmit(false)">
				<span class="trmall_search">
				<p class="trmall_segoods"><input type="radio" name="searchType" value="goods" checked="checked"/>搜索商品</p>
				<p><input type="radio" name="searchType"  value="shop" />搜索店铺</p>
				</span>
				<div class="clear"></div>
				<div class="tramll_frame f_left"  >
					<span style="margin-left:10px; ">商品</span>
					<div style="position:relative;">	
					<div id="searchDiv">
						<label id="searchTip">请输入关键字</label>
						<input type="text" id="keyWord" name="keyWord" value=""/>
					</div>
					</div>
				</div>
				<div class="tramll_seframe f_left"><a id="searchButton" href="#">搜 索</a></div>
			</form>
			<div class="clear"></div>
			<div class="tramall_goods">
			
				<a href="#">雪地靴</a>
				<a href="#">羽绒服</a>
				<a href="#">皮鞋</a>
				<a href="#">打底裤</a>
				<a href="#">运动装</a>
				<a href="#">零食</a>
			</div>
		</div>
		<div class="cartbox">
		   <ul>
		      <li><span> <em class="cart_bg"><a id="details_carnum">0</a></em><a href="#" onclick="javascript:window.open('#');">购物车</a></span><b class="cart_bg"></b></li>
		   </ul>
		   <div class="cart_list" id="cart_list">
		   		<p>购物中还<font class="cart_none">没有商品</font>，赶紧选购吧！</p>
		   
		   </div>
		</div>
</div>
<div class="clear"></div>
   <!-- nav -->
	<div class="tramall_nav">
		<ul style="position:relative;" class="nav_list">
			<li class="tramall_index">所有商品分类</li>
			<li class="tramall_scsy"><a href="/CUCooperate/">首页</a></li>
			<li><a href="#">服装城</a></li>
			<li><a href="#">食品</a></li>
			<li><a href="#">团购</a></li>
			<li><a href="#">团购</a></li>
			<li><a href="#">团购</a></li>
		</ul>
	</div>
	<!-- nav_over -->
	<div class="clear"></div>
	<!-- content1 -->
	<div class="trmall_ware">
		<!-- goodsimg -->
		<div class="trmall_cimg">
			<div class="FocusPic">
				<div class="content" id="main-trmall_cimg">
					<div class="changeDiv">
					<a href="#" title=""><img src="<%=basePath %>/image/1.jpg" alt="" width="868" height="460" /></a>
					<a href="#" title=""><img src="<%=basePath %>/image/2.jpg" alt="" width="868" height="460" /></a>
					<a href="#" title=""><img src="<%=basePath %>/image/3.jpg" alt="" width="868" height="460" /></a>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript"> 
		$(function(){
			new trmall_cimg("#main-trmall_cimg","cur",370,220,1);//焦点图
		})
		function $jquery(id){return document.getElementById(id)};
		</script>
		<!-- goodsimg_over -->
		<!-- news -->
		<div class="trmall_news">
		  <ul>
		   <li><span><a style="color: rgb(51, 51, 51);" href="javascript:;">女装、男装、童装</a></span></li>
		   <li><span><a href="javascript:;">户外运动</a></span></li>
		   <li><span><a style="color: rgb(51, 51, 51);" href="javascript:;">电脑、办公</a></span></li>
		   <li><span><a style="color: rgb(51, 51, 51);" href="javascript:;">手机、数码</a></span></li>
		   <li><span><a href="javascript:;">家居、家具、家装、厨具</a></span></li>
		   <li><span><a style="color: rgb(51, 51, 51);" href="javascript:;">个人护肤</a></span></li>
		   <li><span><a style="color: rgb(51, 51, 51);" href="javascript:;">箱包、钟表、奢侈品</a></span></li>
		   <li><span><a href="javascript:;">家居、家具、家装、厨具</a></span></li>
		   <li><span><a style="color: rgb(51, 51, 51);" href="javascript:;">母婴、玩具</a></span></li>
		   <li><span><a style="color: rgb(51, 51, 51);" href="javascript:;">食品饮料、酒类、生鲜</a></span></li>
		   <li><span><a href="javascript:;">营养保健</a></span></li>
		   <li><span><a style="color: rgb(51, 51, 51);" href="javascript:;">彩票、旅游</a></span></li>
		  </ul>
		</div>
		<!-- news_over -->
			
	</div>
	<!-- content1_over -->
	
	<div class="clear"></div>

	<!-- content_over2 -->
	<div class="trmall_ware">
		<!-- ranking -->
		<div class="trmall_ranking">
			<div class="trmall_rkname"><p class="trmall_rktxt">热销排行</p></div>
			<div class="trmall_rkgoods">
				<span>
				<p></p>
				<p><a href="#">水晶吊坠</a></p>
				<p>¥99.00</p>
				<!--  <p class="trmall_rkprice">¥60.00</P>-->
				<p>时尚，高贵，大气，诠释唯美气质。送给自己，送给朋友一个完美的礼物。</p>
				</span>
				<span class="trmall_rkgoodsimg"><a href="#"><img src="<%=basePath %>/image/2.jpg"  /></a></span>
			</div>
			<div class="trmall_rkgoods">
				<span>
				<p></p>
				<p><a href="#">手提单肩包</a></p>
				<p>¥129.90</p>
				<p>真皮女士新版单肩手提包包，新款上市，百搭的风格</p>
				</span>
				<span class="trmall_rkgoodsimg"><a href="#"><img src="<%=basePath %>/image/3.jpg"  /></a></span>
			</div>
		   <div class="trmall_rkgoods">
				<span>
				<p><a href="#">韩后</a></p>
				<p>¥298.00</p>
				<p>韩后化妆品套装正品 乳清蛋白菁彩限量礼盒 美白补水保湿面部护理</p>
				</span>
				<span class="trmall_rkgoodsimg"><a href="#"><img src="<%=basePath %>/image/4.jpg"  /></a></span>
			</div>
		</div>
		<!-- ranking_over -->
		
		<!-- groom -->
		<div class="trmall_rkgroom">
			<p class="trmall_rkshop"><a href="#">推荐商品</a></p>
			<div class="trmall_grgoods trmall_blod">
			   <p></p>
				<!-- goods -->
				<div class="items w-bg">
					
					<a class="s-img" href="#" target="_blank">
					<img class="err-product" width="193" height="165" alt="" src="<%=basePath %>/image/5.jpg">
					</a>
				</div>
				<!-- goods -->
				<!-- goods2 -->
				<div class="items w-bg">
					<a class="s-img" href="#" target="_blank">
					<img class="err-product" width="193" height="165" alt="" src="<%=basePath %>/image/6.jpg">
					</a>
				</div>
				<!-- goods2 -->
				<!-- goods3 -->
				<div class="items w-bg">
					<a class="s-img" href="#" target="_blank">
					<img class="err-product" width="193" height="165" alt="" src="<%=basePath %>/image/1.jpg">
					</a>
				</div>
				<!-- goods3 -->
				<!-- goods -->
				<div class="items w-bg">
					<a class="s-img" href="#" target="_blank">
					<img class="err-product" width="193" height="165" alt="" src="<%=basePath %>/image/2.jpg">
					</a>
				</div>
				<!-- goods -->
				<!-- goods2 -->
				<div class="items w-bg">
					<a class="s-img" href="#" target="_blank">
					<img class="err-product" width="193" height="165" alt="" src="<%=basePath %>/image/3.jpg">
					</a>
				</div>
				<!-- goods2 -->
				<!-- goods3 -->
				<div class="items w-bg">
					<a class="s-img" href="#" target="_blank">
					<img class="err-product" width="193" height="165" alt="" src="<%=basePath %>/image/4.jpg">
					</a>
				</div>
				<!-- goods3 -->
				<!-- goods -->
				<div class="items w-bg">
					<a class="s-img" href="#" target="_blank">
					<img class="err-product" width="193" height="165" alt="" src="<%=basePath %>/image/5.jpg">
					</a>
				</div>
				<!-- goods -->
				<!-- goods2 -->
				<div class="items w-bg">
					<a class="s-img" href="#" target="_blank">
					<img class="err-product" width="193" height="165" alt="" src="<%=basePath %>/image/6.jpg">
					</a>
				</div>
				<!-- goods2 -->
				<!-- goods3 -->
				<div class="items w-bg">
					<a class="s-img" href="#" target="_blank">
					<img class="err-product" width="193" height="165" alt="" src="<%=basePath %>/image/1.jpg">
					</a>
				</div>
				<!-- goods3 -->
			</div>

		</div>
		<!-- groom_over -->
	</div>
	<!-- content_over2 over -->
	
	<div class="clear"></div>
	
   <!-- bottom -->
	<div class="trmall_bottom">
	<span>
	<p>
	<a href="#"> 关于我们 | </a>
	<a href="#">友情链接 |  </a>
	<a href="#"> 联系我们  |  </a>
	<a href="#"> 公司介绍 </a>
	</p>
	<p>电话：010-01234567 邮箱：123@136.com</p>
	<p>地址：北京市海淀区xx路xx大厦xx层xx室</p>
	</span>
	</div>
	<!-- bottom over-->
	</div>
<!-- ware over-->

</body>
</html>