package com.sunsharelaw.bg.util;

import java.sql.Connection;
import java.sql.DriverManager;


final public class ConnectDB {
	private ConnectDB(){};
	private static Connection connection=null;	
	static {
		try {
			setConnection(connectDB());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static Connection connectDB() throws Exception{
		
//		String driver = "com.mysql.jdbc.Driver";
	
		String hostip = "localhost:3306"; 
		String DBname = "lawyer"; 
		String user = "root"; 
		String passwd = "Welcome1"; 
        
//		String hostip = "rdsbanf6bbanf6b.mysql.rds.aliyuncs.com:3306"; 
//        String DBname = "r2q5pmhch1gpttkp"; 
//        String user = "r2q5pmhch1gpttkp"; 
//        String passwd = "141242"; 
         
        //1.加载数据库驱动 
        Class.forName("com.mysql.jdbc.Driver").newInstance(); 
         
        //2.获取数据库的连接 
        Connection con=DriverManager.getConnection("jdbc:mysql://"+hostip +"/"+DBname+"?user="+user+"&password="+passwd+"&useUnicode=true&characterEncoding=utf-8"); 
		con.setAutoCommit(false);
        return con;
	}
	public static Connection getConnection() {
		return connection;
	}
	public static void setConnection(Connection connection) {
		ConnectDB.connection = connection;
	}	

}
