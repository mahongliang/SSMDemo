package com.mahl.service;


import java.util.List;

import com.mahl.pojo.User;

public interface IUserManager {

	public void registerUser(User user);
	
	public boolean checkUser(User user);

	public void insertUser(List<User> users);
}
