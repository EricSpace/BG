<%@ page language="java"
	import="java.util.*,com.sunsharelaw.bg.domain.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="CSS/bootstrap.css">
<link rel="icon" href="image/favicon.ico" >
<link rel="shortcut icon" href="image/favicon.ico" >
</head>
<%
	Company company = (Company) session.getAttribute("companyInfo");
	String user_name = company.getAdmin_username();
%>

<body>
	<table width="100%" class="table">
		<tr>

			<td width="40% style="vertical-align:middle;">欢迎您：<%=user_name%>　<a href="index.jsp" >注销</a> <a href="GoHomePage" >主页</a>
			</td>

			<td widht="60" align="right">
	
			<a href="SetupCompanyInfo?action=showcompanyinfo" class="btn btn-primary">设置公司信息</a>  <a href="SetupMenuInfo?action=showmenuoneinfo"" class="btn btn-primary">设置菜单信息</a>  <a href="SetupReponseMsgInfo?action=showresponsemsginfo" class="btn btn-warning active">设置消息回复</a>
			</td>
		</tr>
	</table>
</body>
</html>
