<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head bgcolor="#98DAF4">

<title>泰常微信管理平台-登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="icon" href="image/favicon.ico">
<link rel="shortcut icon" href="image/favicon.ico">

<link rel="stylesheet" type="text/css"
	href="CSS/fontawesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="CSS/bootstrap/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="CSS/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="CSS/loginpage.css">

</head>
<%
	String errMsg = "";
	if (request.getAttribute("loginErrMsg") != null) {
		errMsg = "<div class='text'><i class='fa fa-close fa-2x'></i>"
				+ request.getAttribute("loginErrMsg") + "</div>";
	}
%>
<body>

	<div id="login_form">
		<form action="UserLogin" method="post">
			<div class=center>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user fa-2x"></i>
					</span> <input id="username" name="username" class="form-control"
						type="text" placeholder="请输入用户名" />
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock fa-2x"></i>
					</span><input id="userpwd" name="userpwd" class="form-control"
						type="password" placeholder="请输入密码" />
				</div>
				<br>
				<div class="input-group">
					<input class="btn btn-primary" type="submit" placeholder="密码"
						value="登&nbsp;&nbsp;录" />
				</div>
				<div class="input-group" id="errMsg"><%=errMsg%></div>
			</div>
		</form>

	</div>

</body>
</html>
