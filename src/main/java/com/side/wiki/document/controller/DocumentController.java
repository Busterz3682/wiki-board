package com.side.wiki.document.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public String getDoc(DocumentVO vo, Model model) {
		logger.info("getDoc 요청 들어옴");
		model.addAttribute("doc", documentService.getDoc(vo));
		return "docShow";

	}

	//문서 수정
	@PostMapping("/updateDoc")
	public String updateDoc() {
		logger.info("updateDoc 요청 들어옴");
		return "home";
	}

	//문서 삭제
	public String deleteDoc() {
		return "home";
	}

}
