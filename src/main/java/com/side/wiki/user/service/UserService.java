package com.side.wiki.user.service;

import javax.servlet.http.HttpSession;

import com.side.wiki.vo.UserVO;

public interface UserService {

	//회원가입
	public int userJoin(UserVO vo);
	
	//로그인
	public String userLogin(UserVO vo);
}
