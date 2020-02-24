package com.itwill3.dao;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;

public class UserDaoImplMybatisMain {

	public static void main(String[] args) throws Exception {
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/3-3.user_dao_mybatis.xml");
		System.out.println("-------------Spring Container초기화끝----------");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		System.out.println("####userDao:"+userDao);
//		System.out.println(userDao.findUserList());
//		System.out.println(userDao.findUser("mint"));
//		System.out.println(userDao.create(new User("mtest", "1111", "mint", "mint@gmail.com")));
//		System.out.println(userDao.remove("test"));
		User updateUser = new User("mtest", "2222", "minttt", "mint@gmail.com");
		System.out.println(userDao.update(updateUser));
	}

}
