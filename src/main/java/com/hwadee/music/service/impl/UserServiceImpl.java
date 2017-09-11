package com.hwadee.music.service.impl;

import java.util.List;

import com.hwadee.music.dao.UserDao;
import com.hwadee.music.dao.impl.UserDaoImpl;
import com.hwadee.music.domain.User;
import com.hwadee.music.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();
	@Override
	public boolean validateLogin(User user) {
		//使用接口声明对象
		
		User userDB = userDao.findByNameAndPwd(user);
		if(userDB == null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<User> getAllUsers() {
		
		return userDao.findAll();
	}

	@Override
	public void delUser(int id) {
		userDao.delete(id);
		
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public void editUser(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}
	
}
