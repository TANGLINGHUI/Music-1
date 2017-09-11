package com.hwadee.music.service;

import java.util.List;

import com.hwadee.music.domain.User;

public interface UserService {
	public boolean validateLogin(User user);

	public List<User> getAllUsers();

	public void delUser(int id);

	public void addUser(User user);

	public User getUserByName(String name);

	public User getUserById(int id);

	public void editUser(User user);
}
