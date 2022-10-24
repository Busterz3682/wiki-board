package com.side.wiki.document.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.side.wiki.HomeController;
import com.side.wiki.document.domain.DocumentVO;
import com.side.wiki.document.service.DocumentService;

@Controller
@RequestMapping("/wiki")
public class DocumentController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DocumentService documentService;
	
	//구현해야 할 기능들(CRUD)
	//문서 작성
	@PostMapping("/insertDoc")
	public String insertDoc(DocumentVO vo) {
		logger.info("insertDoc 요청들어옴");
		documentService.insertDoc(vo);
		return "home";
	}
	
	//문서 작성 페이지 이동
	@GetMapping("/insertDoc")
	public String insertDocPage() {
		logger.info("문서작성 페이지 이동");
		return "docInput";
	}
	
	//문서 조회
	@GetMapping("/getDoc")
	public String getDoc() {
		logger.info("getDoc 요청 들어옴");
		return "home.jsp";
	}
	
	//문서 수정
	public String updateDoc() {
		return "home.jsp";
	}
	
	//문서 삭제
	public String deleteDoc() {
		return "home.jsp";
	}
	
}
