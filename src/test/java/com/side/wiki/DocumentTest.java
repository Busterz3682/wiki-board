package com.side.wiki;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.side.wiki.document.service.DocumentService;
import com.side.wiki.mapper.DocumentMapper;
import com.side.wiki.vo.DocumentVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/mybatis-config.xml")
public class DocumentTest {

	@Autowired
	private DocumentMapper mapper;
	
	@Test
	public void docInputTest() {
		DocumentVO vo = new DocumentVO();
		
		for(int i=1; i<100; i++) {
			vo.setDocTitle("Test Title" + i);
			vo.setDocContent("Test Content" + i);
			mapper.insertDoc(vo);
		}
		
	}
	
}
