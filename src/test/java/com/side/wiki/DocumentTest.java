package com.side.wiki;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.side.wiki.document.service.DocumentService;
import com.side.wiki.mapper.DocumentMapper;
import com.side.wiki.vo.DetailVO;
import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mybatis-config.xml"})
public class DocumentTest {

	@Autowired
	private DocumentMapper mapper;
	
//	@Autowired
//	private DocumentService service;
	
//	@Test
//	public void docInputTest() {
//		DocumentVO vo = new DocumentVO();
//		
//		for(int i=1; i<100; i++) {
//			vo.setDocTitle("Test Title" + i);
//			vo.setDocContent("Test Content" + i);
//			mapper.insertDoc(vo);
//		}
//		
//	}
	
//	@Test
//	public void searchTest() {
//		System.out.println(mapper.searchList("Test"));
//	}
	
//	@Test
//	public void docTest() {
//		System.out.println(mapper.getDoc("위키백과 미러사이트"));
//	}
	
//	@Test
//	public void detailTest() {
//		System.out.println(mapper.getDetail("221213문서"));
//	}
	
//	@Test
//	public void listTest() {
//		DocumentVO vo = new DocumentVO("AAA", "BBB", null, 0, 1, "cc");
//		List<DetailVO> vo2 = new ArrayList<DetailVO>();
//		service.insertDoc(vo, vo2);
//	}
	
//	@Test
//	public void docTest2() {
//		System.out.println(service.getDoc("221213문서"));
//		System.out.println(service.getChapter("221213문서"));
//		System.out.println(service.getDetail("221213문서"));
//	}
	
	@Test
	public void reqTest() {
		for(int i = 1; i <= 200; i++) {
			mapper.requestDeleteDoc("문서삭제요청목록 테스트 " + i);
		}
	}
	
//	@Test
//	public void listTest() {
//		PagingVO vo = new PagingVO(1, mapper.getTotalRequest(), 10, 10);
//		for(String s : mapper.getRequestedList(vo)) {
//			System.out.println(s);
//		}
//	}
	
}
