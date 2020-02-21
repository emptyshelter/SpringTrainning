package com.itwill.user;
import java.util.List;
import org.springframework.stereotype.Component;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;
@Component(value = "userService")
public interface UserService{
	public int create(User user) throws ExistedUserException,Exception;
	public int update(User user)throws Exception;
	public int remove(String userId)throws Exception;
	public User findUser(String userId)	throws UserNotFoundException,Exception;
	public List<User> findUserList()throws Exception;
	public User login(String userId, String password)throws  UserNotFoundException, PasswordMismatchException,Exception;
}