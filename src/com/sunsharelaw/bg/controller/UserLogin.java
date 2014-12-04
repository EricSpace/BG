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

public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = -3202695077545020497L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		// PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		if ("logout".equals(action)) {
			HttpSession session = request.getSession();      
//			session.removeAttribute("companyInfo");  
			session.invalidate();
//			response.sendRedirect("index.jsp");
			request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);																
		} else {
			// 获得用户名和密码
			String username = request.getParameter("username");
			String userpwd = request.getParameter("userpwd");
			
			Company cp = new Company();
			cp.setAdmin_username(username);
			cp.setAdmin_pwd(userpwd);

			// 检查用户信息
			cp = CompanyInfoService.checkUserLogin(cp);
			if (cp == null) {
				request.setAttribute("loginErrMsg", "用户名或密码不正确，请检查");
				request.setAttribute("usernameforerrpage", username);
				request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(
						request, response);

			} else {
				request.getSession().setAttribute("companyInfo", cp);
				request.getSession().setAttribute("company_welcome_content",
						cp.getWelcome_content());
				request.getRequestDispatcher("/WEB-INF/JSP/welcome.jsp")
						.forward(request, response);
			}
				
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
