function oldPwdValueChange(){
	var oldPwd = document.getElementById("inputOldPwd");
	if(oldPwd.value!=""){
		var oldPwdDiv = document.getElementById("oldpwddiv");
		oldPwdDiv.className = "col-sm-8 input-group has-success has-feedback";
		var oldPwdSan = document.getElementById("oldpwdspan");
		oldPwdSan.className = "glyphicon glyphicon-ok form-control-feedback";
		oldPwdSan.style.display="block";
	}
}

function newPwdValueChange(){
	var newPwd = document.getElementById("inputNewPwd");
	if(newPwd.value!=""){
		var newPwdDiv = document.getElementById("newpwddiv");
		newPwdDiv.className = "col-sm-8 input-group has-success has-feedback";
		var newPwdSan = document.getElementById("newpwdspan");
		newPwdSan.className = "glyphicon glyphicon-ok form-control-feedback";
		newPwdSan.style.display="block";
	}
}

function confirmPwdValueChange(){
	var confirmPwd = document.getElementById("inputConfrimNewPwd");
	if(confirmPwd.value!=""){
		var confirmPwdDiv = document.getElementById("confirmpwddiv");
		confirmPwdDiv.className = "col-sm-8 input-group has-success has-feedback";
		var confirmPwdSan = document.getElementById("confirmpwdspan");
		confirmPwdSan.className = "glyphicon glyphicon-ok form-control-feedback";
		confirmPwdSan.style.display="block";
	}
}

function validatePwd(){	
	var oldPwd = document.getElementById("inputOldPwd");
	var newPwd = document.getElementById("inputNewPwd");
	var confrimPwd = document.getElementById("inputConfrimNewPwd");
	var tip = document.getElementById("tip");
	
	var oldPwdDiv = document.getElementById("oldpwddiv");
	var newPwdDiv = document.getElementById("newpwddiv");
	var confirmPwdDiv = document.getElementById("confirmpwddiv");
	

//	alert(oldPwd.value);
	if(oldPwd.value==""){
		oldPwdDiv.className = "col-sm-8 input-group has-error has-feedback";
		var oldPwdSan = document.getElementById("oldpwdspan");
		oldPwdSan.className = "glyphicon glyphicon-remove form-control-feedback";
		oldPwdSan.style.display="block";
		tip.innerHTML = "请输入旧密码"; 
		
		return false;
	}
	
	if(newPwd.value==""){
		newPwdDiv.className = "col-sm-8 input-group has-error has-feedback";
		var newPwdSan = document.getElementById("newpwdspan");
		newPwdSan.style.display="block";
		tip.innerHTML = "请输入新密码"; 
		
		return false;
	}
	
	if(confrimPwd.value==""){
		confirmPwdDiv.className = "col-sm-8 input-group has-error has-feedback";
		var confirmPwdSan = document.getElementById("confirmpwdspan");
		confirmPwdSan.className = "glyphicon glyphicon-remove form-control-feedback";
		confirmPwdSan.style.display="block";
		tip.innerHTML = "请确认新密码"; 
		
		return false;
	}
	
	if(confrimPwd.value!=newPwd.value){
		confirmPwdDiv.className = "col-sm-8 input-group has-error has-feedback";
		var confirmPwdSan = document.getElementById("confirmpwdspan");
		confirmPwdSan.style.display="block";
		confirmPwdSan.className = "glyphicon glyphicon-remove form-control-feedback";
		tip.innerHTML = "新密码与确认密码不同，请检查后重试"; 
		
		return false;
	}
	

	if(oldPwd.value!=pd){
		oldPwdDiv.className = "col-sm-8 input-group has-error has-feedback";
		var oldPwdSan = document.getElementById("oldpwdspan");
		oldPwdSan.className = "glyphicon glyphicon-remove form-control-feedback";
		oldPwdSan.style.display="block";
		tip.innerHTML = "旧密码不正确，请检查后重试"; 
		
		return false;
	}
	
	return true;	
}