<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>泰常--菜单信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css"	href="CSS/fontawesome/css/font-awesome.css">
	<link rel="stylesheet" type="text/css"	href="CSS/bootstrap/css/bootstrap-theme.css">
	<link rel="stylesheet" type="text/css"	href="CSS/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" 	href="CSS/bodybg1.css">
	<link rel="icon" href="image/favicon.ico" >
	<link rel="shortcut icon" href="image/favicon.ico" >
  </head>
  
  <body class="body">
       <div><jsp:include flush="true" page="head.jsp"></jsp:include></div>
<div><br></div>

  <div class="container">
   <div class="jumbotron" >

			<div class="page-header">
				<p>
					<i class="fa fa-reorder"></i>&nbsp;&nbsp;二级菜单
				</p>
			</div>
<div class="row">
		<div class="col-md-4"><jsp:include flush="true" page="editmenutwo_a.jsp"></jsp:include></div>
		<div class="col-md-4"><jsp:include flush="true" page="editmenutwo_b.jsp"></jsp:include></div>
		<div class="col-md-4"><jsp:include flush="true" page="editmenutwo_c.jsp"></jsp:include></div>
		
</div>
	</div>
	</div>
  </body>
</html>
