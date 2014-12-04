package com.sunsharelaw.bg.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sunsharelaw.bg.domain.ResponseMessage;
import com.sunsharelaw.bg.util.ConnectDB;
import com.sunsharelaw.bg.util.MyTools;

public class ResponseMsgInfoService {

	@SuppressWarnings("null")
	public static ArrayList<ResponseMessage> getRespMsgInfo(String companyid) {
		Connection conn = ConnectDB.getConnection();
		ArrayList<ResponseMessage> rspMsgList = new ArrayList<ResponseMessage>();
		ResponseMessage responseMessage = null;
		try {
			if ((conn != null) || (!conn.isClosed())) {
				String sql = "select t1.*, t2.`NAME` as menu_name from wx_article_resp_info as t1 LEFT JOIN wx_menu_info as t2 on t1.COMPANY_ID= t2.COMPANY_ID and t1.MENU_ID=t2.MENU_ID where t1.COMPANY_ID=?";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, companyid);

				ResultSet rs = pstmt.executeQuery();
				// 获取返回消息信息
				while (rs.next()) {
					responseMessage = new ResponseMessage();
					responseMessage.setCompany_id(companyid);
					responseMessage
							.setContent_url(rs.getString("content_url") == null ? ""
									: rs.getString("content_url"));
					responseMessage
							.setMenu_id(rs.getString("menu_id") == null ? ""
									: rs.getString("menu_id"));
					responseMessage
							.setMenu_name(rs.getString("menu_name") == null ? ""
									: rs.getString("menu_name"));
					responseMessage
							.setPic_url(rs.getString("pic_url") == null ? ""
									: rs.getString("pic_url"));
					responseMessage.setRow_id(rs.getInt("row_id"));
					responseMessage.setTitle(rs.getString("title") == null ? ""
							: rs.getString("title"));
					responseMessage
							.setDescription(rs.getString("description") == null ? ""
									: rs.getString("description"));

					rspMsgList.add(responseMessage);
				}

			}
		} catch (SQLException e) {
			throw new RuntimeException("查询返回消息信息出错" + e.getMessage());
		}

		return rspMsgList;
	}

	@SuppressWarnings("null")
	public static int updateRspMsgInfo(ResponseMessage responseMessage,String operation) {
		Connection conn = ConnectDB.getConnection();
		String sql = null;
		String sqlReplace = null;
		String rowid = Integer.toString(responseMessage.getRow_id());
		int code = 0;
		try {
			if ((conn != null) || (!conn.isClosed())) {

				if ("update".equals(operation)) {
					sql = "update wx_article_resp_info set menu_id=MENU_ID,title = TITLE,description = DESCRIPTION,pic_url= PIC_URL,content_url= CONTENT_URL where row_id=ROWID";
					sqlReplace = sql
							.replace("TITLE",
									"'" + responseMessage.getTitle() + "'")
							.replace("MENU_ID",
									"'" + responseMessage.getMenu_id() + "'")
							.replace(
									"DESCRIPTION",
									"'" + responseMessage.getDescription()
											+ "'")
							.replace("PIC_URL",
									"'" + responseMessage.getPic_url() + "'")
							.replace(
									"CONTENT_URL",
									"'" + responseMessage.getContent_url()
											+ "'").replace("ROWID", rowid);
				} else if("add".equals(operation)){
					sql = "insert into wx_article_resp_info(company_id,menu_id,title,description,pic_url,content_url) values (COMPANY_ID,MENU_ID,TITLE,DESCRIPTION,PIC_URL,CONTENT_URL)";
					sqlReplace = sql
							.replace("TITLE",
									"'" + responseMessage.getTitle() + "'")
							.replace("MENU_ID",
									"'" + responseMessage.getMenu_id() + "'")
							.replace(
									"DESCRIPTION",
									"'" + responseMessage.getDescription()
											+ "'")
							.replace("PIC_URL",
									"'" + responseMessage.getPic_url() + "'")
							.replace(
									"CONTENT_URL",
									"'" + responseMessage.getContent_url()
											+ "'").replace("COMPANY_ID", "'" + responseMessage.getCompany_id() + "'");
				}

				Statement pstmt = conn.createStatement();
				code = pstmt.executeUpdate(sqlReplace);
				System.out.println("code=" + code);
				conn.commit();
			}
		} catch (SQLException e) {
			throw new RuntimeException("更新/新增菜单回复信息出错" + e.getMessage());
		}
		return code;
	}

	@SuppressWarnings("null")
	public static int deleteRspMsgInfo(String rowid) {
		Connection conn = ConnectDB.getConnection();

		int code = 0;
		try {
			if ((conn != null) || (!conn.isClosed())) {
				String sql = "delete from wx_article_resp_info where row_id=ROWID";
				String sqlReplace = sql.replace("ROWID", rowid);

				Statement pstmt = conn.createStatement();
				code = pstmt.executeUpdate(sqlReplace);
				System.out.println("code=" + code);
				conn.commit();
			}
		} catch (SQLException e) {
			throw new RuntimeException("删除菜单回复信息出错" + e.getMessage());
		}
		return code;
	}

	// 获取具体的分页信息
	public static ArrayList<ResponseMessage> getSplitPage(int pageSize,
			int pageNow, String companyid) {

		ArrayList<ResponseMessage> rspMsgList = new ArrayList<ResponseMessage>();
		ResponseMessage responseMessage = null;

		String sqlSplit = "select t1.*, t2.`NAME` as menu_name from wx_article_resp_info as t1 LEFT JOIN wx_menu_info as t2 on t1.COMPANY_ID= t2.COMPANY_ID and t1.MENU_ID=t2.MENU_ID where t1.COMPANY_ID='"
				+ companyid + "' order by t1.menu_id LIMIT BEGIN,PAGE_SIZE;";

		ResultSet rs = MyTools.splitPage(pageSize, pageNow, sqlSplit);

		try {
			while (rs.next()) {
				responseMessage = new ResponseMessage();
				responseMessage.setCompany_id(companyid);
				responseMessage
						.setContent_url(rs.getString("content_url") == null ? ""
								: rs.getString("content_url"));
				responseMessage.setMenu_id(rs.getString("menu_id") == null ? ""
						: rs.getString("menu_id"));
				responseMessage
						.setMenu_name(rs.getString("menu_name") == null ? ""
								: rs.getString("menu_name"));
				responseMessage.setPic_url(rs.getString("pic_url") == null ? ""
						: rs.getString("pic_url"));
				responseMessage.setRow_id(rs.getInt("row_id"));
				responseMessage.setTitle(rs.getString("title") == null ? ""
						: rs.getString("title"));
				responseMessage
						.setDescription(rs.getString("description") == null ? ""
								: rs.getString("description"));

				rspMsgList.add(responseMessage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rspMsgList;
	}

	// 获取分页总页数
	public static int getPageCount(int pageSize, String companyid) {

		int count = 0;
		String sql = "select count(*) from wx_article_resp_info as t1 LEFT JOIN wx_menu_info as t2 on t1.COMPANY_ID= t2.COMPANY_ID and t1.MENU_ID=t2.MENU_ID where t1.COMPANY_ID='"
				+ companyid + "' ";

		count = MyTools.getPageCount(pageSize, sql);
		return count;
	}

}
