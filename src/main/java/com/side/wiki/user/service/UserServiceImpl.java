package com.side.wiki.user.service;

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
	public String userLogin(UserVO vo) {
		return userMapper.userLogin(vo);
	}

}
