package com.side.wiki.mapper;

import com.side.wiki.vo.UserVO;

public interface UserMapper {
	
	//회원가입
	public int userJoin(UserVO vo);

	//로그인
	public UserVO userLogin(String email);

	//중복체크
	public int idCheck(String id);
}
