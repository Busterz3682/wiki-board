package com.side.wiki.mapper;

import com.side.wiki.vo.UserVO;

public interface UserMapper {
	
	//ȸ������
	public int userJoin(UserVO vo);

	//�α���
	public String userLogin(UserVO vo);
}
