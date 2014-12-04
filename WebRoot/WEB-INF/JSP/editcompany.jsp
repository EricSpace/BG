<%@ page language="java" import="java.util.*,com.sunsharelaw.bg.domain.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <meta http-equiv=Content-Type content="text/html;charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/bootstrap.css">
	<link rel="icon" href="image/favicon.ico" >
	<link rel="shortcut icon" href="image/favicon.ico" >
  </head>
  
<script type="text/javascript">
function checkRequiredInput(){
	content = document.getElementById("subscribecontents");
	if(content.value==null||content.value.length==0){
		alert("注意：关注回复内容不能为空!");
		return false;
	}else{
		return true;
	}
}
</script>
  <%
	Company company = (Company) session.getAttribute("companyInfo");
	String welcome_content = (String)session.getAttribute("company_welcome_content");
%>
  
  <body>
  <div class="page-header">
	<p>
		 <i class="fa  fa-university"></i>&nbsp;&nbsp;公司信息
	</p>
</div>
<form role="form" action="SetupCompanyInfo?action=updatecompinfo" method="post" onsubmit="return checkRequiredInput()">

  <div class="form-group">
    <p>公司名称</p>
    <input type="text" disabled="disabled" class="form-control" id="companyname" value="<%=company.getCompany_name()%>"/>
  </div>
  <div class="form-group">
    <p>关注回复内容<font color='#FF0000'><strong>*</strong></font></p>
    <input type="text" name="welcomecontent" class="form-control" id="subscribecontents" value="<%=welcome_content%>" placeholder="请输入关注的回复信息"/>
  </div>
  
  <input type="submit" value="保存" class="btn btn-success" />
  <a href="SetupCompanyInfo?action=showcompanyinfo" class="btn btn-info">取消</a>
</form>
 
  </body>
</html>
