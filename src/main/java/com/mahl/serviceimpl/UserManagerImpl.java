package com.mahl.serviceimpl;


import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mahl.dao.UserDao;
import com.mahl.pojo.User;
import com.mahl.service.IUserManager;

@Component("userManager")
public class UserManagerImpl implements IUserManager{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Override
	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		List<User> list = userDao.selectByNameAndPwd(user);
		if (list.size() > 0) {
			return true;
		}else {
			return false;
		}
	}
	
//	@Transactional
	public void insertUser(List<User> users){
		// TODO Auto-generated method stub  
        for (int i = 0; i < users.size(); i++) {  
            if(i<3){  
                this.userDao.insert(users.get(i));  
            }  
            else {  
                throw new RuntimeException();  
            }  
        }  
	}

}
