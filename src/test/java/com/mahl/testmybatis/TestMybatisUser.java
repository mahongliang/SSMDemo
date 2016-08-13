package com.mahl.testmybatis;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mahl.pojo.User;
import com.mahl.service.IUserManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMybatisUser {

	@Autowired
	private IUserManager userManager;
	
	 @Test
	 public void testRegister(){
	 User user = new User();
	 user.setUsername("mahl");
	 user.setPassword("mahl");
	 userManager.registerUser(user);
	 }
	
	 @Test
	 public void testCheck(){
	 User user = new User();
	 user.setUsername("admin");
	 user.setPassword("123");
	 Assert.assertTrue(userManager.checkUser(user));
	 }

//	@Test
//	public void testTransaction() {
//		List<User> users = new ArrayList<User>();
//		for (int i = 1; i < 5; i++) {
//			User user = new User();
//			user.setPassword(i + "111111");
//			user.setUsername("测试" + i);
//			users.add(user);
//		}
//		this.userManager.insertUser(users);
//	}
}
