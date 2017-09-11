package com.hwadee.music.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hwadee.music.dao.UserDao;
import com.hwadee.music.domain.User;
import com.hwadee.music.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	@Override
	//根据用户姓名和密码查找用户
	public User findByNameAndPwd(User user) {
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "select * from users where user_name=? and user_pwd=?";
		
		User userDB = null;//查询的用户
		try {
		   PreparedStatement pre =conn.prepareStatement(sql);
			pre.setString(1, user.getUser_name());
			pre.setString(2, user.getUser_pwd());
			ResultSet rs = pre.executeQuery();
			if(rs.next()){
				userDB = new User();
				userDB.setUser_id(rs.getInt("user_id"));
				userDB.setUser_name(rs.getString("user_name"));
				userDB.setUser_pwd(rs.getString("user_pwd"));
				userDB.setUser_gender(rs.getString("user_gender"));
				userDB.setUser_mail(rs.getString("user_mail"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userDB;
	}

	@Override
	//新增用户信息
	public void insert(User user) {
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "insert into users(user_name,user_pwd,user_gender,user_mail) values("
						+"?,?,?,?)";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, user.getUser_name());
			pre.setString(2, user.getUser_pwd());
			pre.setString(3, user.getUser_gender());
			pre.setString(4, user.getUser_mail());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	//根据用户ID删除用户信息
	public void delete(int id) {
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "delete from users where user_id = ?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	//更新用户信息
	public void update(User user) {
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "update users set user_name=?,user_pwd=?,user_gender=?,user_mail=? "
				 +  "where user_id=?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, user.getUser_name());
			pre.setString(2, user.getUser_pwd());
			pre.setString(3, user.getUser_gender());
			pre.setString(4, user.getUser_mail());
			pre.setInt(5, user.getUser_id());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	//根据用户编号查找用户
	public User findById(int id) {
		User user = null;
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "select * from users where user_id = ?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if(rs.next()){
					 user = new User();
					user.setUser_id(rs.getInt("user_id"));
					user.setUser_name(rs.getString("user_name"));
					user.setUser_gender(rs.getString("user_gender"));
					user.setUser_mail(rs.getString("user_mail"));
					user.setUser_pwd(rs.getString("user_pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	//查询所有用户信息
	public List<User> findAll() {
		List<User> list =  new ArrayList<User>();
		User user = null;
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "select * from users";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_mail(rs.getString("user_mail"));
				user.setUser_pwd(rs.getString("user_pwd"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	//根据用户姓名查找用户信息
	public User findByName(String name) {
		User user = null;
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "select * from users where user_name = ?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			ResultSet rs = pre.executeQuery();
			if(rs.next()){
					 user = new User();
					user.setUser_id(rs.getInt("user_id"));
					user.setUser_name(rs.getString("user_name"));
					user.setUser_gender(rs.getString("user_gender"));
					user.setUser_mail(rs.getString("user_mail"));
					user.setUser_pwd(rs.getString("user_pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
	
}
