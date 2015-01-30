/*
分页初始化
id：对应p的id值
*/
function initPageDiv(id){
	//拼装分页工具栏
	var str = "";
	str += "<div id=\"div_page\" class=\"quotes\">";
	str += "<a name=\"_prevP\" class=\"cursor\">上一页</a><span></span>";
	str += "<span>";
	str += "第<input name=\"_inputP\" type=\"text\" size=\"3\" value=\"0\"/>页";
	str += "/共<span name=\"_totalSizeP\">0</span>页";
	str += "<a name=\"_goP\" class=\"cursor\">go</a>";
	str += "</span>";
	str += "<a name=\"_nextP\" class=\"cursor\">下一页</a>";
	
	$("#"+id+"").html(str);
}

/*
更新pageDiv的显示及事件触发
curPage：当前页
totalPage：总页数
totalSize：数据总条数
pageSize：每页显示数
functionName：分页方法名 function(pageNo) 
divId: 更新的pageDiv的id值
*/
function updatePageDiv(curPage, totalPage, totalSize, pageSize,functionName,divId){
	if(curPage<1){
		curPage=1;
	}else if(curPage>totalPage){
		curPage=totalPage;
	}
	
	$element=$("#"+divId+"");
	$element.find('input[name=_inputP]').val(curPage);
	$element.find('span[name=_totalSizeP]').empty().html(totalPage);
	
	eval( "var _function = " + functionName );
	
	//添加事件
	if(curPage==1){
		$element.find('a[name=_prevP]').unbind();
	}else{
		$element.find('a[name=_prevP]').unbind().bind('click', function() { _function(curPage-1); });
	}
	
	if(curPage==totalPage){
		$element.find('a[name=_nextP]').unbind();
	}else{
		$element.find('a[name=_nextP]').unbind().bind('click', function() { _function(curPage+1); });
	}
	$element.find('a[name=_goP]').unbind().bind('click', function() {
		var pageNo=$element.find('input[name=_inputP]').val();
		if(pageNo<1){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		_function(pageNo); 
	});
}

/*
将json对象转换为字符串 
*/
function JsonToStr(o) {  
	var arr = [];  
	var fmt = function(s) {  
	if (typeof s == 'object' && s != null) return JsonToStr(s);  
		return /^(string|number)$/.test(typeof s) ? "'" + s + "'" : s;  
	}  
	for (var i in o) arr.push("'" + i + "':" + fmt(o[i]));  
	return '{' + arr.join(',') + '}';  
}

/*
 * 全选
 * 全选的复选框id 必须为要勾选的复选框的name前加上"all_"
 */
function checkAll(name){
	var all="all_"+name;
	$("#"+all+"").change(function (){
		 if($("#"+all+"").attr("checked")){ // check all
			   $("input[name="+name+"]").each(function(){
				   $(this).attr("checked",true);
			   });
		 }else{
			   $("input[name="+name+"]").each(function(){
				   $(this).attr("checked",false);
			   });
		 }
	})
}

/*
 * 获取name对应的checkbox的val，并以，号分隔
 */
function eachCheckBox(name){
	var a="";
	$("input[type=\"checkbox\"][name=\""+name+"\"]:checked").each(function() {
		a +=$(this).val()+",";   
	});
	return a;
}
String.prototype.endWith=function(str){
	  if(str==null||str==""||this.length==0||str.length>this.length)
	    return false;
	  if(this.substring(this.length-str.length)==str)
	    return true;
	  else
	    return false;
	  return true;
}
String.prototype.replaceAll = function(s1,s2) { 
    return this.replace(new RegExp(s1,"gm"),s2); 
}
function eachRaidoBox(name){
	var a="";
	$("input[type=\"radio\"][name=\""+name+"\"]:checked").each(function() {
		a =$(this).val();   
	});
	return a;
}

function formatMoney(money){
	if(money == null){
		return "";
	}
	money = money+"";
	if(money.indexOf(".")==-1){
		money = money+".00";
	}
	if(money.substring(money.indexOf(".")+1,money.length).length==1){
		money = money+"0";
	}
	return money;
}

