package com.itwill3.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserDao;

public class SpringApplicationContextMain {

	public static void main(String[] args) throws Exception {
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/3-1.spring_datasource.xml");
		System.out.println("-------------Spring Container초기화끝----------");
		DataSource apacheDataSource = (DataSource) applicationContext.getBean("apacheDataSource");
		Connection con1 = apacheDataSource.getConnection();
		System.out.println("####"+apacheDataSource);
		System.out.println("####"+con1);
		DataSource springDataSource = (DataSource) applicationContext.getBean("springDataSource");
		Connection con2 = springDataSource.getConnection();
		System.out.println("####"+springDataSource);
		System.out.println("####"+con2);
		con1.close();
		con2.close();
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		System.out.println(userDao.findUserList());
		System.out.println(userDao.findUser("test"));
	}

}
