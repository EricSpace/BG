<%@ page language="java" import="java.util.*,com.sunsharelaw.bg.domain.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<%
	String admin_pwd = (String)request.getAttribute("apd");
%>
    <meta http-equiv=Content-Type content="text/html;charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css"	href="CSS/fontawesome/css/font-awesome.css">
	<link rel="stylesheet" type="text/css"	href="CSS/bootstrap/css/bootstrap-theme.css">
	<link rel="stylesheet" type="text/css"	href="CSS/bootstrap/css/bootstrap.css">
	<link rel="icon" href="image/favicon.ico" >
	<link rel="shortcut icon" href="image/favicon.ico" >
	<script type="text/javascript">var pd = "<%=admin_pwd %>";</script>
	<script type="text/javascript" src="JS/changepwd.js"></script>
  </head>


  
  <body>
  <div class="page-header">
	<p>
		 <i class="fa fa fa-cog fa-spin"></i>&nbsp;&nbsp;修改密码
	</p>
</div>
<form class="form-horizontal" role="form" action="SetupCompanyInfo?action=editpwd" method="post" onsubmit="return validatePwd()">
  <div class="form-group" >
  <label for="oldpwd" class="col-sm-2 control-label">输入旧密码<font color='#FF0000'><strong>*</strong></font></label>

    <div id="oldpwddiv" class="col-sm-8 input-group">
    <div class="input-group-addon"><i class="fa fa-lock fa-lg"></i></div>
      <input id="inputOldPwd" type="password" class="form-control" placeholder="请输入旧密码" onchange="oldPwdValueChange()"/>

       <span id="oldpwdspan" style="display:none" class="glyphicon glyphicon-remove form-control-feedback"></span>

     
 	</div>

 	 
 	 
  </div>
 <div class="form-group">
  <label for="newpwd" class="col-sm-2 control-label">输入新密码<font color='#FF0000'><strong>*</strong></font></label>

    <div id="newpwddiv" class="col-sm-8 input-group">
     <div class="input-group-addon"><i class="fa fa-lock fa-lg"></i></div>
      <input id="inputNewPwd" type="password" class="form-control" placeholder="请输入新密码" onchange="newPwdValueChange()"/>
 		<span id="newpwdspan" style="display:none" class="glyphicon glyphicon-remove form-control-feedback"></span>
 	</div>
   </div>
<div class="form-group">
  <label for="confirmnewpwd" class="col-sm-2 control-label">确认新密码<font color='#FF0000'><strong>*</strong></label>

    <div id="confirmpwddiv"  class="col-sm-8 input-group">
    <div class="input-group-addon"><i class="fa fa-lock fa-lg"></i></div>
      <input  id="inputConfrimNewPwd" type="password" class="form-control" name="newPin" placeholder="请确认新密码" onchange="confirmPwdValueChange()"/>
<span id="confirmpwdspan" style="display:none" class="glyphicon glyphicon-remove form-control-feedback"></span>
 	</div>
   </div>
   
   <div class="form-group">
   <div class="col-sm-2"></div>
   <div class="col-sm-8">
   <span id="tip" style="color:red"></span>
   </div>
   </div>
   
  <div class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
  	  <input type="submit" value="保存" class="btn btn-success" />
  <a href="SetupCompanyInfo?action=showeditpwd" class="btn btn-info">取消</a>
  </div>  
  </div>

</form>
 
  </body>
</html>
