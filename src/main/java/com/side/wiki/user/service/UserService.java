package com.side.wiki.user.service;

import javax.servlet.http.HttpSession;

import com.side.wiki.vo.UserVO;

public interface UserService {

	//ȸ������
	public int userJoin(UserVO vo);
	
	//�α���
	public String userLogin(UserVO vo);
}
