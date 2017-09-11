package com.hwadee.music.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
private static JDBCUtil idbcUtil = new JDBCUtil();
	
	private Connection conn = null;
	
	private final String driverClass = "com.mysql.jdbc.Driver";
	private final static String url="jdbc:mysql://localhost:3306/music?useUnicode=true&characterEncoiding=UTF-8";
	private final static String userName = "root";
	private final static String password = "root";
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
		public static Connection getConnection(){
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
		//对数据表实现修改
		public static void executeUpdate(String sql, String[] args) {
			Connection conn = null;
			PreparedStatement pre = null;
			System.out.println(args.length);
			try {
				conn = getConnection();
				pre = conn.prepareStatement(sql);
				if (args != null && args.length > 0) {
					for (int i = 1; i <= args.length; i++) {
						pre.setString(i, args[i-1]);
					}
				}
				int rs=pre.executeUpdate();
				System.out.print(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (pre != null) {
					try {
						pre.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
}
