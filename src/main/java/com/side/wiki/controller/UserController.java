package com.side.wiki.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.side.wiki.user.service.UserService;
import com.side.wiki.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	//�α���������
	@GetMapping("/loginpage")
	public String userLoginPage() {
		return "/board/loginPage";
	}

	//�α���
	@PostMapping("/userLogin")
	public String userLogin(UserVO vo, HttpSession session, HttpServletResponse response) {
		System.out.println("login��û");
		String loginemail = userService.userLogin(vo);
		if(loginemail != null) {
			session.setAttribute("islogin", "yes");
			return "/board/boardlist";
		} else {
			return "/board/loginfail";
		}
	}
	
	//ȸ������
	@PostMapping("/userJoin")
	public String userJoin(UserVO vo) {
		userService.userJoin(vo);
		return null;
	}
}