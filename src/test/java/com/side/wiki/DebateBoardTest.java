package com.side.wiki;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.side.wiki.mapper.DebateBoardMapper;
import com.side.wiki.vo.DebateReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/mybatis-config.xml")
public class DebateBoardTest {

	@Autowired
	private DebateBoardMapper debateBoardMapper;
	
//	@Test
//	public void insertTest() {
//		for(int i=1; i<=10; i++) {
//		DebateReplyVO vo = new DebateReplyVO();
//		vo.setDocTitle("Test Title1");
//		
//		vo.setEmail("email1");
//		vo.setContent("content"+i);
//		debateBoardMapper.insertReply(vo);
//		}
//	}
//	@Test
//	public void getTest() {
//		DebateReplyVO vo = new DebateReplyVO();
//		vo.setDocTitle("Test Title1");
//		System.out.println(debateBoardMapper.getDebateDetail(vo));
//	}
	
//	@Test
//	public void replyTest() {
//		DebateReplyVO vo = new DebateReplyVO("Test Title2", "AAA", "BBB", "a", 1);
//		debateBoardMapper.insertReply(vo);
//	}
}
