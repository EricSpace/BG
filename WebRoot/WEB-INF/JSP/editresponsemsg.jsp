<%@ page language="java"
	import="java.util.*,com.sunsharelaw.bg.domain.*,net.sf.json.JSONArray" pageEncoding="utf-8"%>

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
<link rel="stylesheet" type="text/css" href="CSS/menuonepopup.css">
<link rel="icon" href="image/favicon.ico" >
<link rel="shortcut icon" href="image/favicon.ico" >
<script type="text/javascript" src="JS/rspmsg.js" charset="utf-8"></script>
</head>

<%
	ArrayList<ResponseMessage> allSplitRspMsg = new ArrayList<ResponseMessage>();
	allSplitRspMsg = (ArrayList<ResponseMessage>) request.getAttribute("response_msg_split_list");
	
	ArrayList<Menu> allMenulist = new ArrayList<Menu>();
	allMenulist = (ArrayList<Menu>) request.getAttribute("menu_select_list");
	
	String jsonList = (String)request.getAttribute("json_list"); 

	int pageCount = Integer.parseInt((String) request.getAttribute("pageCount"));
	int pageNow = Integer.parseInt((String) request.getAttribute("pageNow"));
	
	String preHrefDisable ="";
	String nextHrefDisable ="";
	if(pageNow==1){		
		preHrefDisable = "disabled='disabled'";
	}
	
	if(pageNow==pageCount){		
		nextHrefDisable = "disabled='disabled'";
	}
%>

<body>
	<div class="container" style="width:100%">
	<input style="display:none" id="jsoninput" type="text" value=<%=jsonList %> />
		<form action="" method="post" id="rsp_msg_form">
			<table class="table table-striped table-bordered">
				<tr>
					<th class="col-md-1"><div class="text" style=" text-align:center;">#</div>
					</th>
					<th class="col-md-2"><div class="text" style=" text-align:center;">菜单名称</div>
					</th>
					<th class="col-md-3"><div class="text" style=" text-align:center;">标题</div>
					</th>
					<th class="col-md-2"><div class="text" style=" text-align:center;">封面</div>
					</th>
					<th class="col-md-2"><div class="text" style=" text-align:center;">正文</div>
					</th>
					<th class="col-md-2"><div class="text" style=" text-align:center;"></div>
					</th>
				</tr>
				<%
					ResponseMessage responseMessage = new ResponseMessage();
	
					for (int i = 0; i < allSplitRspMsg.size(); i++) {
						responseMessage = (ResponseMessage) allSplitRspMsg.get(i);
				%>
				
				<tr>
					<td><div class="text" style=" text-align:center;"><font style="font-family:Arial;font-weight:bold;font-size:18px;"><%=i+1 %></font></div>
					</td>
					<td><div class="text" style=" text-align:center;"><font style="font-family:宋体;font-size:16px;"><%=responseMessage.getMenu_name()%></font></div>
					</td>
					<td><div class="text" style=" text-align:center;"><font style="font-family:宋体;font-size:16px;"><%=responseMessage.getTitle()%></font></div>
					</td>
					<td>
						<div class="text" style=" text-align:center;">
					
							<a href="<%=responseMessage.getPic_url()%>" class="btn btn-primary"
								target="_Blank">预览&nbsp;&nbsp;<i class="fa  fa-caret-right fa-lg"></i></a>
						</div>
			
					</td>
					<td>
						<div class="text" style=" text-align:center;">
							<a href="<%=responseMessage.getContent_url()%>"
								class="btn btn-primary" target="_Blank">预览&nbsp;&nbsp;<i class="fa  fa-caret-right fa-lg"></i></a>
						</div>
					</td>

					<td>
						<div class="text" style=" text-align:center;">
							<a class="btn btn-default" title="修改" onclick="show(<%=responseMessage.getRow_id() %>,'<%=responseMessage.getMenu_name() %>','<%=responseMessage.getTitle() %>','<%=responseMessage.getDescription() %>','<%=responseMessage.getPic_url() %>','<%=responseMessage.getContent_url() %>')"><i class="fa fa-pencil fa-lg"></i></a>
							<a class="btn btn-danger" title="删除" onclick="confirmDelete(<%=responseMessage.getRow_id() %>,'<%=responseMessage.getMenu_name() %>')"><i class="fa fa-trash-o fa-lg"></i></a>
							<a class="btn btn-info" title="新增" onclick="show('','','','','','')"><i class="fa  fa-plus fa-lg"></i></a>
						</div>
					<div id="confirmDelPop" class="white_content">
				
							<table >
								<tr><td colspan="2" align="left"><h4><b>注意</b></h4></td></tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td colspan="2" align="left">确认要删除菜单<b><input type="text"  style="border:0;outline:none;text-align:center" size="15" id="delMenuId"/></b>的回复信息吗？</td></tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td class="col-md-2" align="right"><input type="button" value="确认" class="btn btn-danger btn-block" onclick="deleteMsg('<%=responseMessage.getRow_id()%>')"/></td>
								<td class="col-md-2"><input type="button" value="取消" class="btn btn-default btn-block" onclick="hidePopup()"/></td></tr>
							</table>
					
					</div> 
					</td>
				</tr>

				<%
					}		
				%>
			</table>
			
			<div>			
				<table>
				<tr class="row">
				<td class="col-md-1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="col-md-10" align="center">
					
					<a
					href="SetupReponseMsgInfo?action=showresponsemsginfo&pagenow=<%=pageNow - 1%>"
					<%=preHrefDisable %>
					class="btn btn-default"><i class="fa fa-chevron-circle-left fa-lg"></i> 上一页</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%
					String hrefclass = "btn btn-default";

					for (int i = 0; i < pageCount; i++) {
						if ((i + 1) == pageNow) {
							hrefclass = "btn btn-success";
						}
				%>
				<a
					href="SetupReponseMsgInfo?action=showresponsemsginfo&pagenow=<%=i + 1%>"
					class='<%=hrefclass%>'><%=i + 1%></a>

				<%
					hrefclass = "btn btn-default";
					}
				%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a
					href="SetupReponseMsgInfo?action=showresponsemsginfo&pagenow=<%=pageNow + 1%>"
					<%=nextHrefDisable %>
					class="btn btn-default">下一页 <i class="fa  fa-chevron-circle-right fa-lg"></i></a> 
				</td>
								
				<td class="col-md-1" align="left">
				<!-- 
					<a class="btn btn-success btn-block" onclick="show('','','','','','')"><i class="fa  fa-plus fa-lg"></i> 新增</a>
				 -->
				</td>
					</tr>
				</table>				
			</div>
			<div id="menupopupone"></div>

			<div id="fade" class="black_overlay"></div> 
		</form>
	</div>
</body>
</html>
