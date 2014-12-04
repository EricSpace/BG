<%@ page language="java"
	import="java.util.*,com.sunsharelaw.bg.domain.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv=Content-Type content="text/html;charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"	href="CSS/fontawesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css"	href="CSS/bootstrap/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"	href="CSS/bootstrap/css/bootstrap.css">
<link rel="icon" href="image/favicon.ico" >
<link rel="shortcut icon" href="image/favicon.ico" >
<script type="text/javascript" src="JS/menuone.js" charset="utf-8"></script>
</head>

<%
	ArrayList<Menu> allMenu = new ArrayList<Menu>();
	allMenu = (ArrayList<Menu>) request.getAttribute("menu_one_list");
%>

<body>

<div class="page-header">
	<p>
		 <i class="fa fa-reorder"></i>&nbsp;&nbsp;一级菜单
	</p>
</div>
	<div align="left">
		<form action="" method="post" id="menu_one_form">
			<table class="table table-striped table-bordered">
				<tr >
					<th><div class="text" style=" text-align:center;padding: 15px; font-size:20px;font-weight:bold">#</div>
					</th>
					<th><div class="text" style=" text-align:center;padding: 15px; font-size:20px;">菜单名称</div>
					</th>
					<th><div class="text" style=" text-align:center;"></div>
					</th>
				</tr>
				<%
					Menu menu = new Menu();

					for (int i = 0; i < allMenu.size(); i++) {
						menu = (Menu) allMenu.get(i);
				%>
				<tr>
					<td width="20%"><div class="text" style=" text-align:center;"><font style="font-size:18px;font-weight:bold"><%=i+1 %></font></div></td>
					<td width ="60%"><div class="text" style=" text-align:center;"><font style="font-size:18px"><%=menu.getName()%></font></div></td>
					<td width="20%"><a class="btn btn-primary btn-block" title="修改" onclick="show('<%=menu.getRow_id()%>','<%=menu.getName()%>')"><i class="fa fa-pencil fa-lg"></i></a></td>
				</tr>

				<%
					}
				%>
			</table>
			<div id="menupopupone" class='form-group'></div>
		</form>
	</div>


</body>
</html>
