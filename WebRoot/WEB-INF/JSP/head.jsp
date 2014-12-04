<%@ page language="java"
	import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"	href="CSS/fontawesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css"	href="CSS/bootstrap/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"	href="CSS/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"	href="CSS/headnav.css">
<link rel="icon" href="image/favicon.ico" >
<link rel="shortcut icon" href="image/favicon.ico" >
</head>

<body>

<div>
<ul class="top-level">
  <li><a href="GoHomePage">主页</a></li>
  <li><a href="SetupCompanyInfo?action=showcompanyinfo">公司信息</a>
  <li><a href="javascript:void(0)">菜单信息</a>
    <!-- dropdown menu first level -->
    <ul class="second-level">
      <li><a href="SetupMenuInfo?action=showmenuoneinfo">一级菜单</a></li>      
      <li><a href="SetupMenuInfo?action=showmenutwoinfo">二级菜单</a></li>
    </ul>
  </li>  
   <li><a href="SetupReponseMsgInfo?action=showresponsemsginfo">回复信息</a></li>
   <li><a href="javascript:void(0)">个人中心</a>
   	<ul class="second-level">
   		<li><a href="SetupCompanyInfo?action=showeditpwd">修改密码</a></li>
   		<li><a href="UserLogin?action=logout">退出系统</a></li>   		
   	</ul>
   	</li>
</ul>
</div>

</body>
</html>
