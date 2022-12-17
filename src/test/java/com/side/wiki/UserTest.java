package com.side.wiki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.side.wiki.controller.UserController;
import com.side.wiki.mapper.UserMapper;
import com.side.wiki.user.service.UserService;
import com.side.wiki.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mybatis-config.xml", "file:src/main/webapp/WEB-INF/spring/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/email-config.xml", "file:src/main/webapp/WEB-INF/spring/interceptor-config.xml"})
public class UserTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private UserController userController;
	
//	@Test
//	public void userJoinTest() {
//		UserVO vo = new UserVO();
//		for(int i=1; i<=5; i++) {
//			vo.setEmail("221125email"+i);
//			vo.setPw("221125pw"+i);
//			userMapper.userJoin(vo);
//		}
//		System.out.println("회원가입테스트");
//	}
	
//	@Test
//	public void userLoginTest() {
//		UserVO vo = new UserVO();
//		vo.setEmail("email1");
//		vo.setPw("pw1");
//		String a = userMapper.userLogin(vo);
//		assertEquals("email1", "email1");
//	}
	
//	@Test
//	public void userJoinTest() {
//		UserVO vo = new UserVO();
//		vo.setEmail("a");
//		vo.setPassword("b");
//		userMapper.userJoin(vo);
//	}
	
	@Test
	public void contTest() {
		UserVO vo = new UserVO();
		vo.setEmail("Test");
		vo.setPassword("123");
		userController.userJoin(vo);
	}
	
}
