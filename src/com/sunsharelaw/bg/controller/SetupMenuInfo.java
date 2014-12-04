package com.sunsharelaw.bg.controller;

import java.io.IOException;
import java.util.ArrayList;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunsharelaw.bg.domain.Company;
import com.sunsharelaw.bg.domain.Menu;
import com.sunsharelaw.bg.service.MenuInfoService;

public class SetupMenuInfo extends HttpServlet {

	private static final long serialVersionUID = -3704012888581261597L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String companyid="";
		
		
		//必须是登录的用户
		if(session.getAttribute("companyInfo")==null){
			response.sendRedirect("index.jsp");
			return;
//			request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
		}else{
			Company comp = (Company) session.getAttribute("companyInfo");
			companyid = comp.getCompany_id();
		}
		
		String action = request.getParameter("action");
		ArrayList<Menu> menuList = new ArrayList<Menu>();

		
		if("showmenuoneinfo".equals(action)){			
			menuList = MenuInfoService.getMenuInfo(companyid, "Y",null);
			if(menuList!=null){
				request.setAttribute("menu_one_list", menuList);
				request.getRequestDispatcher("/WEB-INF/JSP/menuoneinfo.jsp").forward(request,response);
			}			
		}else if("updatemenuinfo".equals(action)){
			String rowid = (String) request.getParameter("menuonerowid");
			String menuname = (String) request.getParameter("menuonename");
			if(1==MenuInfoService.updateMenuInfo(rowid, menuname)){
				menuList = MenuInfoService.getMenuInfo(companyid, "Y",null);
				if(menuList!=null){
					request.setAttribute("menu_one_list", menuList);
					request.getRequestDispatcher("/WEB-INF/JSP/menuoneinfo.jsp").forward(request,response);
				}	
			}
		}else if("showmenutwoinfo".equals(action)){			

			ArrayList<Menu> menuList_a = new ArrayList<Menu>();
			ArrayList<Menu> menuList_b = new ArrayList<Menu>();
			ArrayList<Menu> menuList_c = new ArrayList<Menu>();
			menuList_a = MenuInfoService.getMenuInfo(companyid, "N","01");
			menuList_b = MenuInfoService.getMenuInfo(companyid, "N","02");
			menuList_c = MenuInfoService.getMenuInfo(companyid, "N","03");
			
			if(menuList_a!=null){
				request.setAttribute("menuList_a", menuList_a);
				request.setAttribute("menu_one_a_name", MenuInfoService.getMenuName(companyid, "Y", "01"));
			}
			
			if(menuList_b!=null){
				request.setAttribute("menuList_b", menuList_b);
				request.setAttribute("menu_one_b_name", MenuInfoService.getMenuName(companyid, "Y", "02"));
			}
			
			if(menuList_c!=null){
				request.setAttribute("menuList_c", menuList_c);
				request.setAttribute("menu_one_c_name", MenuInfoService.getMenuName(companyid, "Y", "03"));
			}
			
			request.getRequestDispatcher("/WEB-INF/JSP/menutwoinfo.jsp").forward(request,response);
		
		}else if("updatemenutwoinfo".equals(action)){
			String rowid = (String) request.getParameter("menuonerowid");
			String menuname = (String) request.getParameter("menuonename");
			if(1==MenuInfoService.updateMenuInfo(rowid, menuname)){

				ArrayList<Menu> menuList_a = new ArrayList<Menu>();
				ArrayList<Menu> menuList_b = new ArrayList<Menu>();
				ArrayList<Menu> menuList_c = new ArrayList<Menu>();
				menuList_a = MenuInfoService.getMenuInfo(companyid, "N","01");
				menuList_b = MenuInfoService.getMenuInfo(companyid, "N","02");
				menuList_c = MenuInfoService.getMenuInfo(companyid, "N","03");
				
				if(menuList_a!=null){
					request.setAttribute("menuList_a", menuList_a);
					request.setAttribute("menu_one_a_name", MenuInfoService.getMenuName(companyid, "Y", "01"));
				}
				
				if(menuList_b!=null){
					request.setAttribute("menuList_b", menuList_b);
					request.setAttribute("menu_one_b_name", MenuInfoService.getMenuName(companyid, "Y", "02"));
				}
				
				if(menuList_c!=null){
					request.setAttribute("menuList_c", menuList_c);
					request.setAttribute("menu_one_c_name", MenuInfoService.getMenuName(companyid, "Y", "03"));
				}
				
				request.getRequestDispatcher("/WEB-INF/JSP/menutwoinfo.jsp").forward(request,response);
			
			}
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);	 
	}

}
