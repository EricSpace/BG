package com.sunsharelaw.bg.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyTools {
	
	/*
	 *  获得指定页显示的内容
	 */
	@SuppressWarnings("unused")
	public static ResultSet splitPage(int pageSize, int pageNow,
			String sqlSplit) {
		/*
		 * pageSize:每页显示多少条记录 pageNow:希望显示第几页 pageCount:一共有多少页 rowCount:一共有多少条记录
		 */
		int pageCount = 0;
		int rowCount = 0;
		int begin = 0;

		Connection conn = ConnectDB.getConnection();
		ResultSet rsPageInfo = null;

		try {
			
			begin = (pageNow - 1)*pageSize;
			String sqlSplitReplace = sqlSplit.replace("BEGIN", Integer.toString(begin)).replace("PAGE_SIZE", Integer.toString(pageSize));
			Statement smPageInfo = conn.createStatement();
			rsPageInfo = smPageInfo.executeQuery(sqlSplitReplace);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rsPageInfo;
	}
	
	/*
	 *  获得显示的总页数
	 */
	public static int getPageCount(int pageSize,String sqlCount) {

		int rowCount = 0;
		int pageCount = 0;
		Connection conn = ConnectDB.getConnection();

		try {
			Statement smRowCount = conn.createStatement();
			ResultSet rsRowCount = smRowCount.executeQuery(sqlCount); 
			// 获得总行数
			if (rsRowCount.next()) {
				rowCount = rsRowCount.getInt(1);
			} else {
				return 0;
			}
			
			//获得总页数
			if (rowCount % pageSize == 0) {
				pageCount = rowCount / pageSize;
			} else {
				pageCount = rowCount / pageSize + 1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pageCount;
	}

}
