package com.itwill.user.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserService;

public class UserServiceAnnotationClient {
	public static void main(String[] args) throws Exception{		
		ApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("com/itwill/user/client/99.user-annotation.xml");
		
		UserService userService = (UserService)applicationContext.getBean("userService");
		System.out.println(userService.findUser("id"));
		System.out.println(userService.remove("id"));
		System.out.println(userService.findUserList());
		
	}
}
