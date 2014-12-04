<%@ page language="java" import="java.util.*,com.sunsharelaw.bg.domain.*" pageEncoding="utf-8"%>

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
	<link rel="icon" href="image/favicon.ico" >
	<link rel="shortcut icon" href="image/favicon.ico" >
	<style type="text/css">
		.p{
			font-size:14px;
		}
	</style>
  </head>
  <%
	Company company = (Company) session.getAttribute("companyInfo");
	String user_name = company.getAdmin_username();
%>
<script type="text/javascript">
var currentTime = "";
function showTime(){
	currentTime = window.setInterval("acquireTime()", 1000);
}

function acquireTime(){
	arrayDay = ["日","一","二","三","四","五","六"];
	today = new Date();
	with(today){
		document.getElementById("showTime").value = toLocaleString()+"     星期"+arrayDay[getDay()];
	}
}
</script>
  <body onload="showTime();">
    <div class="container">
<div class="page-header">
	<p>
		 <i class="fa fa-home fa-lg"></i>&nbsp; 主页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>欢迎您：<%=user_name %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-clock-o fa-lg"></i>&nbsp;&nbsp;&nbsp;&nbsp;<input class="form-control-static" id="showTime" style="border:0;background:transparent;outline:medium;width:30%"></input></small> 
	</p>
</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row">
				<div class="col-md-4">
					<div class="thumbnail">
				
						<img alt="" src="http://lorempixel.com/600/200/people" />	
						<div class="caption">
							<h3>
								公司信息
							</h3>
							<p style="font-size:14px">
								设置微信公众平台关注欢迎内容
							</p>
							<p>
								<i class="fa fa-send"></i><a class="btn" href="SetupCompanyInfo?action=showcompanyinfo">点击进入&gt;</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="thumbnail">
						<img alt="" src="http://lorempixel.com/600/200/city" />
						<div class="caption">
							<h3>
								菜单信息
							</h3>
							<p style="font-size:14px">
								设置微信公众平台菜单内容
							</p>
							<p>
								<i class="fa fa-send"></i><a class="btn" href="SetupMenuInfo?action=showmenuoneinfo">点击进入&gt;</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="thumbnail">
						<img alt="" src="http://lorempixel.com/600/200/sports" />
						<div class="caption">
							<h3>
								消息回复
							</h3>
							<p style="font-size:14px">
								设置微信公众平台点击菜单回复内容
							</p>
							<p>
								<i class="fa fa-send"></i><a class="btn" href="SetupReponseMsgInfo?action=showresponsemsginfo">点击进入&gt;</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
  </body>
</html>
