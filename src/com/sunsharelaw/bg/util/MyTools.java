package com.sunsharelaw.bg.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyTools {
	
	/*
	 *  ���ָ��ҳ��ʾ������
	 */
	@SuppressWarnings("unused")
	public static ResultSet splitPage(int pageSize, int pageNow,
			String sqlSplit) {
		/*
		 * pageSize:ÿҳ��ʾ��������¼ pageNow:ϣ����ʾ�ڼ�ҳ pageCount:һ���ж���ҳ rowCount:һ���ж�������¼
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
	 *  �����ʾ����ҳ��
	 */
	public static int getPageCount(int pageSize,String sqlCount) {

		int rowCount = 0;
		int pageCount = 0;
		Connection conn = ConnectDB.getConnection();

		try {
			Statement smRowCount = conn.createStatement();
			ResultSet rsRowCount = smRowCount.executeQuery(sqlCount); 
			// ���������
			if (rsRowCount.next()) {
				rowCount = rsRowCount.getInt(1);
			} else {
				return 0;
			}
			
			//�����ҳ��
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
