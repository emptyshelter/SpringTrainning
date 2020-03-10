package com.itwill.user.mapper;

import java.util.ArrayList;

import com.itwill.user.User;

public interface userMapper {
	public int create(User user);
	public User login(String userId, String password);
	public User findUser(String userId);
	public ArrayList<User> findUserList() throws Exception;
	public boolean isDuplcateUserId(String userId) throws Exception;
	public int remove(String userId) throws Exception;
	public int update(User user) throws Exception;

}
