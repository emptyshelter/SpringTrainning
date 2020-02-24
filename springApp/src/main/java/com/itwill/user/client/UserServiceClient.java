package com.itwill.user.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserDao;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserServiceClient {
	public static void main(String[] args) throws Exception{		
		ApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("com/itwill/user/client/99.user.xml");
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");
//		UserService userService = (UserService)applicationContext.getBean("userService");
		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserDao(userDao);
		userService.findUser("id");
		userService.remove("id");
		userService.findUserList();
		
	}
}
