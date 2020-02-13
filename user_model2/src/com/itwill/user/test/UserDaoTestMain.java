package com.itwill.user.test;
import com.itwill.user.User;
import com.itwill.user.UserDao;

public class UserDaoTestMain {
	public static void main(String[] args) throws Exception {
          UserDao userDao=new UserDao(JavaSeDataSource.getDataSource());
          System.out.println(userDao.create(new User("x","x", "엑스맨", "x@naver.com")));
	}    
 	
	
  }