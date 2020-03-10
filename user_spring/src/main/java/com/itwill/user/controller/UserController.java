package com.itwill.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user_main")
	public String user_main() {
		return "user_main";
	}

	@RequestMapping(value = "/user_write_form")
	public String user_write_form() {
		return "user_write_form";
	}

	@RequestMapping(value = "/user_write_action", method = RequestMethod.GET)
	public String user_write_action() {
		return "redirect:user_write_form";
	}

	@RequestMapping(value = "/user_login_form")
	public String user_login_form() {
		return "user_login_form";
	}

	@RequestMapping(value = "/user_write_action", method = RequestMethod.POST)
	public String user_write_action_post(@ModelAttribute User user, Model model) {
		String forwardPath = "";
		try {
			userService.create(user);
			forwardPath = "redirect:user_login_form";
		} catch (ExistedUserException e) {
			model.addAttribute("fuser", user);
			model.addAttribute("msg", e.getMessage());
			forwardPath = "user_write_form";
			e.printStackTrace();
		} catch (Exception e) {
			model.addAttribute("fuser", user);
			e.printStackTrace();
		}

		return forwardPath;
	}

//	@RequestMapping(value = "/user_login_action", method = RequestMethod.GET)
//	public String user_login_action() {
//		return "user_login_from";
//	}

	@RequestMapping(value = "/user_login_action")
	public String user_login_action_post(String userId, String password, HttpSession session,Model model) {
		String forwardPath = "";
		try {
			userService.login(userId, password);
//			model.addAttribute("sUserId", userId);
			session.setAttribute("sUserId", userId);
			forwardPath="user_main";
		} catch (PasswordMismatchException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			forwardPath="user_login_form";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			forwardPath= "user_login_form";
		}
		return forwardPath;
	}
	@RequestMapping(value = "/user_list")
	public String user_list(HttpSession session, Model model) {
		String forwardPath="";
		try {
			ArrayList<User>userList=userService.findUserList();
			model.addAttribute("userList", userList);
//			session.setAttribute("userList", userList);
			forwardPath="user_list";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="user_login_form";
		}
		
		return forwardPath;
	}
	@RequestMapping(value = "/user_view")
	public String user_view(String userId,HttpSession session, Model model) {
		String forwardPath="";
		try {
			User user = userService.findUser(userId);
//			session.setAttribute("user", user);
			model.addAttribute("user", user);
			forwardPath="user_view";
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			forwardPath="user_list";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			forwardPath="user_list";
		}
		return forwardPath;
		
	}
	@RequestMapping(value = "user_modify_form")
	public String user_modify_form() {
		return "user_modify_form";
	}
	@RequestMapping(value = "user_modify_action",method=RequestMethod.GET)
	public String user_modify_action() {
		return "user_login_form";
	}
	@RequestMapping(value = "user_modify_action",method=RequestMethod.POST)
	public String user_modify_action_post(User user) {
		String forwardPath = "";
		try {
			userService.update(user);
			forwardPath="user_list";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:user_modify_form";
		}
		return forwardPath;
	}
	@RequestMapping(value = "user_remove_action",method=RequestMethod.GET)
	public String user_remove_action() {
		return "user_main";
		
	}
	@RequestMapping(value = "user_remove_action",method=RequestMethod.POST)
	public String user_remove_action_post(String userId, HttpSession session,Model model) {
		String forwardPath = "";
		try {
			userService.remove(userId);
			forwardPath= "user_main";
			session.invalidate();
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath= "user_view";
			
		}
		return forwardPath;
	}
	@RequestMapping(value = "user_logout_action")
	public String user_logout_action (HttpSession session) {
		session.invalidate();
		return "redirect:user_main.do";
	}
}
