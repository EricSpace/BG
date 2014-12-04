package com.sunsharelaw.bg.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sunsharelaw.bg.domain.Company;
import com.sunsharelaw.bg.util.ConnectDB;

public class CompanyInfoService {
	
	@SuppressWarnings("null")
	public static Company checkUserLogin(Company cp){
		Connection conn  = ConnectDB.getConnection();
		Company company = null;
		try {
			if((conn!=null)||(!conn.isClosed())){
				String sql = "select * from wx_company_info where admin_username=? and admin_pwd=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,cp.getAdmin_username());
				pstmt.setString(2,cp.getAdmin_pwd());
				ResultSet rs = pstmt.executeQuery();
				//获取公司信息
				while(rs.next()){
					company = new Company();
					company.setCompany_id(rs.getString("company_id"));
					company.setCompany_name(rs.getString("company_name"));
					company.setWelcome_content(rs.getString("welcome_content"));
					company.setAdmin_username(rs.getString("admin_username"));
					company.setAdmin_pwd(rs.getString("admin_pwd"));
					break;					
				}		
			
			}
		} catch (SQLException e) {
			throw new RuntimeException("查询公司/用户信息出错"+e.getMessage());
		} 
		
		return company;
	}
	
	public static int saveCompInfo(String companyid,String welcomecontent){
		Connection conn  = ConnectDB.getConnection();
		int code = 0;
		try {
			if((conn!=null)||(!conn.isClosed())){
				String sql = "update wx_company_info set welcome_content = WELCOMECONTENT where company_id=COMPANYID";
				String sqlReplace = sql.replace("WELCOMECONTENT", "'"+welcomecontent+"'").replace("COMPANYID", "'"+companyid+"'");
				
				Statement pstmt = conn.createStatement();
				code = pstmt.executeUpdate(sqlReplace);
				System.out.println("code="+code);		
				conn.commit();						
			}
		} catch (SQLException e) {
			throw new RuntimeException("更新公司信息出错"+e.getMessage());
		} 
		return code;
	}
	
	public static int updatePin(String companyid,String newPin){
		Connection conn  = ConnectDB.getConnection();
		int code = 0;
		try {
			if((conn!=null)||(!conn.isClosed())){
				String sql = "update wx_company_info set admin_pwd = ADMINPWD where company_id=COMPANYID";
				String sqlReplace = sql.replace("ADMINPWD", "'"+newPin+"'").replace("COMPANYID", "'"+companyid+"'");
				
				Statement pstmt = conn.createStatement();
				code = pstmt.executeUpdate(sqlReplace);
				System.out.println("code="+code);		
				conn.commit();						
			}
		} catch (SQLException e) {
			throw new RuntimeException("更新用户密码出错"+e.getMessage());
		} 
		return code;
	}
}
