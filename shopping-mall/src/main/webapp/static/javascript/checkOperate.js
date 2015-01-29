function checkOperate(){
	var curId=parent.C.CURPOWER;
	var powerOperate = parent.C.POWEROPERATE;
	for(var i=0;i<powerOperate.length;i++){
		if(checkEqual(powerOperate[i],curId)){
			showBtn(powerOperate[i]);
		}else{
			//if(checkSub(powerOperate[i], curId)){
			//	break;
			//}
		}
	}
}

function checkEqual(powerOperate,curId){
	if(powerOperate.powerId==curId){
		return true;
	}else{
		return false;
	}
}

function showBtn(powerOperate){
	var operate = powerOperate.operate;
	if(operate == null || operate.length==0){
		return ;
	}
	for(var i=0;i<operate.length;i++){
		$("body [operate="+operate[i].operateId+"]").show();
	}
}