/** 检查手机，邮箱格式的js */

/**
 * 检验手机格式
 */
function checkPhone(phone){
	var tphone=/^1(([3][0-9])|([4][7])|([5][01236789])|([8][0256789]))[0-9]{8}$/;
	var partten = /^\d{7,8}$/;

	if(phone == null || phone==""){
		return false;
	}
	 
	if(tphone.test(phone)==false){
		return false;
	}
	return true;
}

/**
 * 检验邮箱格式
 * @param mail
 * @returns {Boolean}
 */
function checkMail(mail){
	var myreg = /^([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+@([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+.[a-za-z]{2,3}$/;
	if(mail == null || mail == ""){
		return false;
	}
	if(!myreg.test(mail)){
	     return false;
	}
	return true;
}

/**
 * 检验固话格式
 * @param tel
 */
function checkTel(tel){
	var tphone=/^1(([3][0-9])|([4][7])|([5][01236789])|([8][0256789]))[0-9]{8}$/;
	var phone =/^((0\d{2,3})[-,\s])(\d{7,8})(-(\d{3,}))?$/
	if(tel == null || tel == ""){
		return false;
	}
	if(tphone.test(tel)){
		return true;
	}
	
	if(phone.test(tel)){
		return true;
	}
	return false;
}

function checkNumber(num){
	var reg =  /^\d+$/;
	if(!reg.test(num)){
		return false;
	}
	return true;
}