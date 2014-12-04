function show(rowid,menuname) {
	var x = event.clientX;
	var y = event.clientY;

	document.getElementById("menupopupone").style.top = y + 50;
	document.getElementById("menupopupone").style.left = x + 100;
	document.getElementById("menupopupone").style.visibility = "visible";
//	var formDiv = "<form action='' method='post'>";
//	
//	formDiv += "<div class='form-group'>";
//	formDiv += "<label for='companyname'>一级菜单名称<font color='#FF0000'><strong>*</strong></font></label><br><br>";
//	formDiv +="<input style='display:none' type='text' value='"+rowid+"' name='menuonerowid'/>";
//	formDiv += "<input type='text' class='form-control' id='menuonename' name='menuonename' value='"+menuname+"' placeholder='请输入菜单名称'/>";
//	formDiv += "<br><input type='button' value='保存' class='btn btn-success' onclick='save()'/>";
//	formDiv += "  <input type='button' value='取消' class='btn btn-info' onclick='hide()' /></div></form>";
	
	var formDiv = "<div class='form-group'>";
	formDiv += "<label for='companyname'>一级菜单名称<font color='#FF0000'><strong>*</strong></font></label><br><br>";
	formDiv +="<input style='display:none' type='text' value='"+rowid+"' name='menuonerowid'/>";
	formDiv += "<input type='text' class='form-control' id='menuonename' name='menuonename' value='"+menuname+"' placeholder='请输入菜单名称'/>";
	formDiv += "<br><input type='button' value='保存' class='btn btn-success' onclick='save()'/>";
	formDiv += "  <input type='button' value='取消' class='btn btn-info' onclick='hide()' /></div>";
	
	document.getElementById("menupopupone").innerHTML = formDiv;
}

function showsub_a(rowid,menuname) {
	hideAll();

	document.getElementById("menupopupone_a").style.visibility = "visible";
	var formDiv = "<div class='form-group'>";
	formDiv += "<label for='companyname'>二级菜单名称<font color='#FF0000'><strong>*</strong></font></label><br><br>";
	formDiv +="<input style='display:none' type='text' value='"+rowid+"' name='menuonerowid'/>";
	formDiv += "<input type='text' class='form-control' id='menuonename' name='menuonename' value='"+menuname+"' placeholder='请输入菜单名称'/>";
	formDiv += "<br><input type='button' value='保存' class='btn btn-success' onclick='savetwo_a()'/>";
	formDiv += "  <input type='button' value='取消' class='btn btn-info' onclick='hideAll()' /></div>";
	document.getElementById("menupopupone_a").innerHTML = formDiv;
}

function showsub_b(rowid,menuname) {
	hideAll();

	document.getElementById("menupopupone_b").style.visibility = "visible";
	var formDiv = "<div class='form-group'>";
	formDiv += "<label for='companyname'>二级菜单名称<font color='#FF0000'><strong>*</strong></font></label><br><br>";
	formDiv +="<input style='display:none' type='text' value='"+rowid+"' name='menuonerowid'/>";
	formDiv += "<input type='text' class='form-control' id='menuonename' name='menuonename' value='"+menuname+"' placeholder='请输入菜单名称'/>";
	formDiv += "<br><input type='button' value='保存' class='btn btn-success' onclick='savetwo_b()'/>";
	formDiv += "  <input type='button' value='取消' class='btn btn-info' onclick='hideAll()' /></div>";
	document.getElementById("menupopupone_b").innerHTML = formDiv;
}

function showsub_c(rowid,menuname) {
	hideAll();

	document.getElementById("menupopupone_c").style.visibility = "visible";
	var formDiv = "<div class='form-group' sytle='width:500'>";
	formDiv += "<label for='companyname'>二级菜单名称<font color='#FF0000'><strong>*</strong></font></label><br><br>";
	formDiv +="<input style='display:none' type='text' value='"+rowid+"' name='menuonerowid'/>";
	formDiv += "<input type='text' class='form-control' id='menuonename' name='menuonename' value='"+menuname+"' placeholder='请输入菜单名称'/>";
	formDiv += "<br><input type='button' value='保存' class='btn btn-success' onclick='savetwo_c()'/>";
	formDiv += "  <input type='button' value='取消' class='btn btn-info' onclick='hideAll()' /></div>";
	document.getElementById("menupopupone_c").innerHTML = formDiv;
}


function hide() {
	document.getElementById("menupopupone").style.visibility = "hidden";

}

function hideAll() {
	if(document.getElementById("menupopupone_a")!=null){
		document.getElementById("menupopupone_a").style.visibility = "hidden";
	}
	if(document.getElementById("menupopupone_b")!=null){
		document.getElementById("menupopupone_b").style.visibility = "hidden";
	}
	if(document.getElementById("menupopupone_c")!=null){
		document.getElementById("menupopupone_c").style.visibility = "hidden";
	}	
}

function cancel(){
	location.reload();
}


function save() {
	
	content = document.getElementById("menuonename");
	if(content.value==null||content.value.length==0){
		alert("注意：一级菜单名称不能为空!");
		return;
	}
	
	document.getElementById("menupopupone").style.visibility = "hidden";
	document.getElementById("menu_one_form").action = "SetupMenuInfo?action=updatemenuinfo";
	document.getElementById("menu_one_form").submit();
}

function savetwo_a() {
	
	content = document.getElementById("menuonename");
	if(content.value==null||content.value.length==0){
		alert("注意：二级菜单名称不能为空!");
		return;
	}
	
	document.getElementById("menupopupone_a").style.visibility = "hidden";
	document.getElementById("sub_menu_two_form_a").action = "SetupMenuInfo?action=updatemenutwoinfo";
	document.getElementById("sub_menu_two_form_a").submit();
}

function savetwo_b() {
	
	content = document.getElementById("menuonename");
	if(content.value==null||content.value.length==0){
		alert("注意：二级菜单名称不能为空!");
		return;
	}
	
	document.getElementById("menupopupone_b").style.visibility = "hidden";
	document.getElementById("sub_menu_two_form_b").action = "SetupMenuInfo?action=updatemenutwoinfo";
	document.getElementById("sub_menu_two_form_b").submit();
}

function savetwo_c() {
	
	content = document.getElementById("menuonename");
	if(content.value==null||content.value.length==0){
		alert("注意：二级菜单名称不能为空!");
		return;
	}
	
	document.getElementById("menupopupone_c").style.visibility = "hidden";
	document.getElementById("sub_menu_two_form_c").action = "SetupMenuInfo?action=updatemenutwoinfo";
	document.getElementById("sub_menu_two_form_c").submit();
}
