package com.hwadee.music.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
private static JDBCUtil idbcUtil = new JDBCUtil();
	
	private Connection conn = null;
	
	private final String driverClass = "com.mysql.jdbc.Driver";
	private final String url="jdbc:mysql://localhost:3306/music?useUnicode=true&characterEncoiding=UTF-8";
	private final String userName = "root";
	private final String password = "123";
	private JDBCUtil(){
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  static JDBCUtil getInstance(){
		return idbcUtil;
		
	}
	//建立连接
		public Connection getConnection(){
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, userName, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		//关闭连接
		public void closeConn(Connection conn){
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
}
