package com.sunsharelaw.bg.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunsharelaw.bg.domain.Company;
import com.sunsharelaw.bg.service.CompanyInfoService;

public class SetupCompanyInfo extends HttpServlet {

	private static final long serialVersionUID = 5470054918252698409L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String companyid="";
		String admin_pwd = "";
		
		//必须是登录的用户
		if(session.getAttribute("companyInfo")==null){
			response.sendRedirect("index.jsp");
			return;
//			request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
		}else{
			Company comp = (Company) session.getAttribute("companyInfo");
			companyid = comp.getCompany_id();
			admin_pwd = comp.getAdmin_pwd();
		}
		String action = request.getParameter("action");
		if("showcompanyinfo".equals(action)){
			request.getRequestDispatcher("/WEB-INF/JSP/companyinfo.jsp").forward(request,response);
		}else if("updatecompinfo".equals(action)){
			String welcomecontent = request.getParameter("welcomecontent");
			if(1==CompanyInfoService.saveCompInfo(companyid, welcomecontent)){
				request.getSession().setAttribute("company_welcome_content", welcomecontent);
			}
			request.getRequestDispatcher("/WEB-INF/JSP/companyinfo.jsp").forward(request,response);
		}else if("showeditpwd".equals(action)){
			request.setAttribute("apd", admin_pwd);
			request.getRequestDispatcher("/WEB-INF/JSP/pwdinfo.jsp").forward(request,response);
		}else if("editpwd".equals(action)){
			String newPin = (String) request.getParameter("newPin");
			if(1==CompanyInfoService.updatePin(companyid, newPin)){
				request.setAttribute("change_pwd_result", "密码修改成功，请妥善管理您的密码");
				//需要立即更新session中的companyinfo信息
				Company cp = (Company) request.getSession().getAttribute("companyInfo");
				cp.setAdmin_pwd(newPin);
				request.getSession().setAttribute("companyInfo",cp);
				request.getRequestDispatcher("/WEB-INF/JSP/pwdoperinfo.jsp").forward(request,response);
			}			
		}		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
