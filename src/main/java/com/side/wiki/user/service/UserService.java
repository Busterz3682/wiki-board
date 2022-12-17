package com.side.wiki.user.service;

import javax.servlet.http.HttpSession;

import com.side.wiki.vo.UserVO;

public interface UserService {

	//ȸ������
	int userJoin(UserVO vo);
	
	//�α���
	UserVO userLogin(String email);

	//�ߺ�üũ
	int idCheck(String id);
	
	//�α׾ƿ�
	void logout(HttpSession session);
}
