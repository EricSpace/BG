package com.sunsharelaw.bg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.sunsharelaw.bg.domain.Company;
import com.sunsharelaw.bg.domain.Menu;
import com.sunsharelaw.bg.domain.ResponseMessage;
import com.sunsharelaw.bg.service.MenuInfoService;
import com.sunsharelaw.bg.service.ResponseMsgInfoService;

public class SetupReponseMsgInfo extends HttpServlet {

	private static final long serialVersionUID = -8779641823356324404L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String companyid = "";
		
		
		// 必须是登录的用户
		if (session.getAttribute("companyInfo") == null) {
		//session过期，用户需要重新登录
			response.sendRedirect("index.jsp");
			return;
//			request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
		}else{
			Company comp = (Company) session.getAttribute("companyInfo");
			companyid = comp.getCompany_id();
		}

		String action = request.getParameter("action");
		String pagenow = request.getParameter("pagenow");
		String rowid = request.getParameter("rspmsgrowid");
//		ArrayList<ResponseMessage> rspMsgList = new ArrayList<ResponseMessage>();
		ArrayList<ResponseMessage> rspMsgSplitList = new ArrayList<ResponseMessage>();
		
		ArrayList<Menu> allMenuList = new ArrayList<Menu>();		
		allMenuList = MenuInfoService.getMenuInfo(companyid, "N", null);
		request.setAttribute("menu_select_list", allMenuList);
		
		//获取菜单下拉列表内容
		ArrayList<Menu> allMenuSelectList = new ArrayList<Menu>();		
		allMenuSelectList = MenuInfoService.getMenuSelectList(companyid, "N", null);
		
		JSONArray json = JSONArray.fromObject(allMenuSelectList);
		String jsonArray = json.toString();
		request.setAttribute("json_list", jsonArray);
		
		int pageCount = 0;
		int pageSize = 5;
		int pageNow = 1;

		// 默认为1，初始化页数的时候也为1
		if (pagenow != null && pagenow != "") {
			pageNow = Integer.parseInt(pagenow);
		}

		if ("showresponsemsginfo".equals(action)) {
//			rspMsgList = ResponseMsgInfoService.getRespMsgInfo(companyid);
			pageCount = ResponseMsgInfoService
					.getPageCount(pageSize, companyid);
			rspMsgSplitList = ResponseMsgInfoService.getSplitPage(pageSize,
					pageNow, companyid);

			if (rspMsgSplitList != null) {
//				request.setAttribute("response_msg_list", rspMsgList);
				request.setAttribute("response_msg_split_list", rspMsgSplitList);
				request.setAttribute("pageCount", Integer.toString(pageCount));
				request.setAttribute("pageNow", Integer.toString(pageNow));
				request.getRequestDispatcher("/WEB-INF/JSP/responsemsginfo.jsp")
						.forward(request, response);
			}
		}

		// 删除回复信息
		if ("deleterspmsginfo".equals(action)) {

			if (1 == ResponseMsgInfoService.deleteRspMsgInfo(rowid)) {

//				rspMsgList = ResponseMsgInfoService.getRespMsgInfo(companyid);
				pageCount = ResponseMsgInfoService.getPageCount(pageSize,
						companyid);
				rspMsgSplitList = ResponseMsgInfoService.getSplitPage(pageSize,
						pageNow, companyid);

				if (rspMsgSplitList != null) {
//					request.setAttribute("response_msg_list", rspMsgList);
					request.setAttribute("response_msg_split_list",rspMsgSplitList);				
					request.setAttribute("pageCount",Integer.toString(pageCount));
					request.setAttribute("pageNow", Integer.toString(pageNow));
					request.getRequestDispatcher("/WEB-INF/JSP/responsemsginfo.jsp").forward(request, response);
				}
			}
		}
		
//		String rpsmsg_rowid = (String)request.getParameter("msg_row_id");
		String rspmsg_menu_id = request.getParameter("selected_menu_item");
		String rspmsg_title = request.getParameter("msgtitle");
		String rspmsg_pic_url = request.getParameter("msgpic");
		String rspmsg_content_url = request.getParameter("msgcontent"); 
		String rspmsg_description = request.getParameter("msgdescription"); 
		
		ResponseMessage rspMsg = new ResponseMessage();
		
//		int i_rpsmsg_id = Integer.parseInt(request.getParameter("msg_row_id"));
		if("updaterspmsginfo".equals(action)){
			rspMsg.setRow_id(Integer.parseInt(request.getParameter("msg_row_id")));
		}		
		rspMsg.setCompany_id(companyid);
		rspMsg.setMenu_id(rspmsg_menu_id);
		rspMsg.setTitle(rspmsg_title);
		rspMsg.setPic_url(rspmsg_pic_url);
		rspMsg.setContent_url(rspmsg_content_url);	
		rspMsg.setDescription(rspmsg_description);
		
		// 更新回复信息
		if ("updaterspmsginfo".equals(action)) {
			if (1 == ResponseMsgInfoService.updateRspMsgInfo(rspMsg, "update")) {

//				rspMsgList = ResponseMsgInfoService.getRespMsgInfo(companyid);
				pageCount = ResponseMsgInfoService.getPageCount(pageSize,
						companyid);
				rspMsgSplitList = ResponseMsgInfoService.getSplitPage(pageSize,
						pageNow, companyid);

				if (rspMsgSplitList != null) {
//					request.setAttribute("response_msg_list", rspMsgList);
					request.setAttribute("response_msg_split_list",rspMsgSplitList);				
					request.setAttribute("pageCount",Integer.toString(pageCount));
					request.setAttribute("pageNow", Integer.toString(pageNow));
					request.getRequestDispatcher("/WEB-INF/JSP/responsemsginfo.jsp").forward(request, response);
				}
			}
		}
		
		// 更新回复信息
		if ("addrspmsginfo".equals(action)) {
			if (1 == ResponseMsgInfoService.updateRspMsgInfo(rspMsg, "add")) {

//				rspMsgList = ResponseMsgInfoService.getRespMsgInfo(companyid);
				pageCount = ResponseMsgInfoService.getPageCount(pageSize,
						companyid);
				rspMsgSplitList = ResponseMsgInfoService.getSplitPage(pageSize,
						pageNow, companyid);

				if (rspMsgSplitList != null) {
//					request.setAttribute("response_msg_list", rspMsgList);
					request.setAttribute("response_msg_split_list",rspMsgSplitList);				
					request.setAttribute("pageCount",Integer.toString(pageCount));
					request.setAttribute("pageNow", Integer.toString(pageNow));
					request.getRequestDispatcher("/WEB-INF/JSP/responsemsginfo.jsp").forward(request, response);
				}
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
