package com.side.wiki.user.service;

import javax.servlet.http.HttpSession;

import com.side.wiki.vo.UserVO;

public interface UserService {

	//회원가입
	int userJoin(UserVO vo);
	
	//로그인
	UserVO userLogin(String email);

	//중복체크
	int idCheck(String id);
	
	//로그아웃
	void logout(HttpSession session);
}
