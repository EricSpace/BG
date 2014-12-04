package com.sunsharelaw.bg.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.alibaba.appengine.api.fetchurl.FetchUrlService;
import com.alibaba.appengine.api.fetchurl.FetchUrlServiceFactory;
import com.sunsharelaw.bg.domain.Menu;
import com.sunsharelaw.bg.util.ConnectDB;

public class MenuInfoService {

	@SuppressWarnings("null")
	public static ArrayList<Menu> getMenuInfo(String companyid, String grade,
			String parentmenuid) {
		Connection conn = ConnectDB.getConnection();
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		Menu menu = null;
		try {
			String sql = "";
			if ((conn != null) || (!conn.isClosed())) {
				if (parentmenuid != null) {
					sql = "select * from wx_menu_info where company_id=? and parent_flag=? and parent_menu_id=? order by menu_id";
				} else {
					sql = "select * from wx_menu_info where company_id=? and parent_flag=? order by menu_id";
				}

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, companyid);
				pstmt.setString(2, grade);
				if (parentmenuid != null) {
					pstmt.setString(3, parentmenuid);
				}

				ResultSet rs = pstmt.executeQuery();
				// 获取菜单信息
				while (rs.next()) {
					menu = new Menu();
					menu.setCompany_id(rs.getString("company_id"));
					menu.setKey(rs.getString("key"));
					menu.setMenu_id(rs.getString("menu_id"));
					menu.setName(rs.getString("name")==null? "":rs.getString("name"));
					menu.setParent_flag(rs.getString("parent_flag"));
					menu.setParent_menu_id(rs.getString("parent_menu_id"));
					menu.setResp_type(rs.getString("resp_type"));
					menu.setRow_id(rs.getInt("row_id"));
					menu.setType(rs.getString("type"));
					menu.setUrl(rs.getString("url"));

					menuList.add(menu);
				}

			}
		} catch (SQLException e) {
			throw new RuntimeException("查询菜单信息出错" + e.getMessage());
		}

		return menuList;
	}
	
	public static ArrayList<Menu> getMenuSelectList(String companyid, String grade,
			String parentmenuid) {
		Connection conn = ConnectDB.getConnection();
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		Menu menu = null;
		try {
			String sql = "";
			if ((conn != null) || (!conn.isClosed())) {
				if (parentmenuid != null) {
					sql = "select * from wx_menu_info where company_id=? and parent_flag=? and parent_menu_id=? order by menu_id";
				} else {
					sql = "select * from wx_menu_info where company_id=? and parent_flag=? order by menu_id";
				}

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, companyid);
				pstmt.setString(2, grade);
				if (parentmenuid != null) {
					pstmt.setString(3, parentmenuid);
				}

				ResultSet rs = pstmt.executeQuery();
				// 获取菜单信息
				while (rs.next()) {
					if(rs.getString("name")==null){
						continue;
					}
					menu = new Menu();
					menu.setCompany_id(rs.getString("company_id"));
					menu.setKey(rs.getString("key"));
					menu.setMenu_id(rs.getString("menu_id"));
					menu.setName(rs.getString("name")==null? "":rs.getString("name"));
					menu.setParent_flag(rs.getString("parent_flag"));
					menu.setParent_menu_id(rs.getString("parent_menu_id"));
					menu.setResp_type(rs.getString("resp_type"));
					menu.setRow_id(rs.getInt("row_id"));
					menu.setType(rs.getString("type"));
					menu.setUrl(rs.getString("url"));

					menuList.add(menu);
				}

			}
		} catch (SQLException e) {
			throw new RuntimeException("查询菜单信息出错" + e.getMessage());
		}

		return menuList;
	}

	@SuppressWarnings("null")
	public static int updateMenuInfo(String rowid, String menuname) {
		Connection conn = ConnectDB.getConnection();
		// String row_id = Integer.toString(rowid);
		if (rowid == null) {
			rowid = "6";
		}
		int code = 0;
		try {
			if ((conn != null) || (!conn.isClosed())) {
				String sql = "update wx_menu_info set name = NAME where row_id=ROWID";
				String sqlReplace = sql.replace("NAME", "'" + menuname + "'")
						.replace("ROWID", rowid);

				Statement pstmt = conn.createStatement();
				code = pstmt.executeUpdate(sqlReplace);
				System.out.println("code=" + code);
				conn.commit();
			}
		} catch (SQLException e) {
			throw new RuntimeException("更新菜单信息出错" + e.getMessage());
		}
		return code;
	}

	@SuppressWarnings("null")
	public static String getMenuName(String companyid, String grade,String menuid) {
		Connection conn = ConnectDB.getConnection();
		String menuName = "";

		try {
			if ((conn != null) || (!conn.isClosed())) {
				String sql = "select * from wx_menu_info where company_id=? and parent_flag=? and menu_id=? order by menu_id";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, companyid);
				pstmt.setString(2, grade);
				pstmt.setString(3, menuid);

				ResultSet rs = pstmt.executeQuery();
				// 获取菜单信息
				while (rs.next()) {

					menuName = (String)rs.getString("name")==null? "":rs.getString("name");
					break;
				}
			}

		} catch (SQLException e) {
//			e.printStackTrace();
			throw new RuntimeException("获取一级菜单名称信息出错" + e.getMessage());
		}

		return menuName;
	}
	
	
	public static void releaseMenuInfo(){
		FetchUrlService fetchUrlService = FetchUrlServiceFactory.getFetchUrlService();
	}
}
