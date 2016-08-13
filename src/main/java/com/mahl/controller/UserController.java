package com.mahl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mahl.form.UserForm;
import com.mahl.pojo.User;
import com.mahl.service.IUserManager;

@Controller
public class UserController {

	@Autowired
	private IUserManager userManager;
	
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String login(HttpServletRequest request){
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		User user = new User();
//		user.setPassword(password);
//		user.setUsername(username);
//		if (userManager.checkUser(user)) {
//			return "success";
//		}else {
//			return "login";
//		}	
//	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(UserForm userForm){
		User user = new User();
		user.setPassword(userForm.getPassword());
		user.setUsername(userForm.getUsername());
		if (userManager.checkUser(user)) {
			return "success";
		}else {
			return "login";
		}	
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String request(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		userManager.registerUser(user);
		return "login";

	}
}
