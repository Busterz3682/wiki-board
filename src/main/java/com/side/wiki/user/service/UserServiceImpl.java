package com.side.wiki.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.wiki.mapper.UserMapper;
import com.side.wiki.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int userJoin(UserVO vo) {
		return userMapper.userJoin(vo);
	}

	@Override
	public UserVO userLogin(String email) {
		return userMapper.userLogin(email);
	}

	@Override
	public int idCheck(String id) {
		return userMapper.idCheck(id);
	}

	@Override
	public void logout(HttpSession session) {
		session.removeAttribute("user");
	}

}
