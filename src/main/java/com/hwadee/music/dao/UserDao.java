package com.hwadee.music.dao;

import java.util.List;

import com.hwadee.music.domain.User;

public interface UserDao {
	
	public User findByNameAndPwd(User user);
	public void insert(User user);
	public void delete(int id);
	public void update(User user);
	public User findById(int id);
	public List<User> findAll();

	public User findByName(String name);
}
