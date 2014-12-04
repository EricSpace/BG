<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

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
  </head>
<%
 	String resultMsg = (String)request.getAttribute("change_pwd_result");
%>
  <body>
  <div class="page-header">
	<p>
		 <i class="fa fa-check-circle fa-lg"></i>&nbsp;&nbsp;密码修改成功
	</p>
</div>
	<div>
		<p><font style="font-weight:bold;"><%=resultMsg %></font></p>
		<br><a href="SetupCompanyInfo?action=showeditpwd"><font style="font-size:16px;">点此返回</font></a>
	</div>
 
  </body>
</html>
