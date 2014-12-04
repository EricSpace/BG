var rspMsgId = null;
var selectedMenuName = null;
var operation = "update";

function setMsgId(msgId){
	rspMsgId = msgId;
}

function setSelectedMenuName(menuname){
	selectedMenuName = menuname;
}

function confirmDelete(msgId,menuname)
{
	document.getElementById("delMenuId").value = menuname;
	document.getElementById('confirmDelPop').style.display='block';
	document.getElementById('fade').style.display='block';
	setMsgId(msgId);
}


function show(rowid,menuname,title,description,pic_url,content_url) {
	
	setSelectedMenuName(menuname);
	document.getElementById("menupopupone").style.visibility = "visible";
	
	var formDiv = "<div>";
	formDiv += "<br><br><br>";
	formDiv += "<table class='table table-hover'>";	

	formDiv += "<tr class='row'><th colspan='4'>";
	formDiv += "<div class='text' style='text-align:left;'>维护返回消息内容</div>";
	formDiv += "</th></tr>";
	
	formDiv += "<tr class='row'>";
	formDiv += "<td width='5%'><div class='text' style='text-align:left;'>菜单名称<font color='#FF0000'><strong>*</strong></font></div></td>";
	formDiv += "<td width='40%'><select class='form-control' id='select_menu_list' placeholder='请输入标题'></select></td>";
	
	formDiv += "<td width='5%'><div class='text' style='text-align:right;'>标题<font color='#FF0000'><strong>*</strong></font></div></td>";
	formDiv += "<td width='40%'><input type='text' class='form-control' id='msgtitle' name='msgtitle' value='"+title+"' placeholder='请输入标题'/></td>";
	formDiv += "</tr>";
	
	formDiv += "<tr class='row'>";
	formDiv += "<td class='col-md-1'><div class='text' style='text-align:left;'>摘要内容</div></td>";
	formDiv += "<td colspan='3'><div class='text' style='text-align:left;'><input type='text' class='form-control' name='msgdescription' value='"+description+"' placeholder='请输入摘要内容'/></div></td>";
	formDiv += "</tr>";
	
	formDiv += "<tr class='row'>";
	formDiv += "<td class='col-md-1'><div class='text' style='text-align:left;'>封面来源</div></td>";
	formDiv += "<td colspan='3'><div class='text' style='text-align:left;'><input type='text' class='form-control' name='msgpic' value='"+pic_url+"' placeholder='请输入图片来源信息'/></div></td>";
	formDiv += "</tr>";
	
	formDiv += "<tr class='row'>";
	formDiv += "<td><div class='text' style='text-align:left;'>正文来源<font color='#FF0000'><strong>*</strong></font></div></td>";
	formDiv += "<td colspan='3'><div class='text' style='text-align:left;'><input type='text' class='form-control' id='msgcontent' name='msgcontent' value='"+content_url+"' placeholder='请输入图片来源信息'/></div></td>";
	formDiv += "</tr>";
	
	formDiv += "<tr class='row'>";
	formDiv += "<td colspan='3'><input type='button' value='保存' class='btn btn-success' onclick='save()'/>";
	formDiv += "&nbsp;&nbsp;<input type='button' value='取消' class='btn btn-info' onclick='hide()' /></td>";
	formDiv += "</tr>";
	
	formDiv += "</table>";
	
	formDiv += "<input style='display:none' id='selected_menu_item' name='selected_menu_item' type='text' />";
	formDiv += "<input style='display:none' name='msg_row_id' type='text' value='"+rowid+"'/>";
	formDiv += "</div>";

	
	document.getElementById("menupopupone").innerHTML = formDiv;
	setMsgId(rowid);
	addMenuList();
	
}


function hide() {
	document.getElementById("menupopupone").style.visibility = "hidden";

}

function hidePopup(){
	document.getElementById('confirmDelPop').style.display='none';
	document.getElementById('fade').style.display='none';

}

function addMenuList(){
	
	var jsonStr = document.getElementById("jsoninput").value;
//	alert(jsonStr);
	
	var jsonarray =eval("("+jsonStr+")"); 
	
	var selectid=document.getElementById("select_menu_list");
    selectid.options.length=0;
    selectid[0] = new Option("-----请选择菜单-----","");

	for(var i=0;i<jsonarray.length;i++){
		
		for(var key in jsonarray[i]){
			 selectid[i+1]=new Option(jsonarray[i]["name"],jsonarray[i]["menu_id"]);
			 if(selectedMenuName!=null){
				 if(selectedMenuName==jsonarray[i]["name"]){
					 selectid[i+1].selected = true;
				 }
			 }
	     }
		
		if(selectedMenuName==null||selectedMenuName==""){
			selectid[0].selected = true;
			operation = "add";
		}
	}
}

function cancel(){
	location.reload();
}

function deleteMsg(){
	hidePopup();
	
    document.getElementById("rsp_msg_form").action = "SetupReponseMsgInfo?action=deleterspmsginfo&rspmsgrowid='"+rspMsgId+"'";
    document.getElementById("rsp_msg_form").submit();
	
}

function save() {

	var str = document.getElementById("select_menu_list");  
	document.getElementById("selected_menu_item").value = str.options[str.selectedIndex].value;
	var selectValue = document.getElementById("selected_menu_item").value;	
//	alert("selectValue:"+selectValue);
	if(selectValue.length==0||selectValue==""){
		alert("注意：请选择菜单名称!");
		return;
	}
	
	var titleValue = document.getElementById("msgtitle").value;	
//	alert("titleValue:"+titleValue);
	if(titleValue==null||titleValue.length==0||titleValue==""){
		alert("注意：标题内容不能为空!");
		return;
	}
	
	var contentValue = document.getElementById("msgcontent").value;	
	if(contentValue==null||contentValue.length==0||contentValue==""){
		alert("注意：正文来源不能为空!");
		return;
	}
 
	
	document.getElementById("menupopupone").style.visibility = "hidden";
	
	if(operation=="update"){
		document.getElementById("rsp_msg_form").action = "SetupReponseMsgInfo?action=updaterspmsginfo";
	}
	
	if(operation=="add"){
		document.getElementById("rsp_msg_form").action = "SetupReponseMsgInfo?action=addrspmsginfo";
	}

	document.getElementById("rsp_msg_form").submit();
}

