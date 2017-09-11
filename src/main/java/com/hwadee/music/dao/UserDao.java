package com.hwadee.music.dao;

import java.util.List;

import com.hwadee.music.domain.User;

public interface UserDao {
	
	public User findByNameAndPwd(User user);//根据用户密码和名字查找
	public void insert(User user);//新增用户
	public void delete(int id);//删除用户
	public void update(User user);//更新用户信息
	public User findById(int id);//根据用户Id查找用户
	public List<User> findAll();//查询所有用户

	public User findByName(String name);//根据用户姓名查找
}
