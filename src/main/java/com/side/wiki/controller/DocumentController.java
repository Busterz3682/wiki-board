package com.side.wiki.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.side.wiki.document.service.DocumentService;
import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

@Controller
@RequestMapping("/wiki")
public class DocumentController {

	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

	@Autowired
	private DocumentService documentService;

	//문서 작성
	@PostMapping("/insertDoc")
	public String insertDoc(DocumentVO vo) {
		logger.info("insertDoc 요청들어옴");
		documentService.insertDoc(vo);
		return "redirect:/";
	}

	//문서 작성 페이지 이동
	@GetMapping("/insertDoc")
	public String insertDocPage() {
		logger.info("문서작성 페이지 이동");
		return "document/docInput";
	}

	//문서 조회
	@GetMapping("/getDoc")
	public String getDoc(DocumentVO vo, Model model) {
		logger.info("getDoc 요청 들어옴");
		model.addAttribute("doc", documentService.getDoc(vo));
		if(documentService.getDoc(vo) == null) { 
			return "document/docInput";
		} else { 
			return "document/docShow";
		}
	}

	//문서 수정
	@PostMapping("/updateDoc")
	public String updateDoc(DocumentVO vo) {
		logger.info("updateDoc 요청 들어옴");
		documentService.updateDoc(vo);
		return "redirect:/";
	}

	//문서 삭제
	@PostMapping("/deleteDoc")
	public String deleteDoc(DocumentVO vo) {
		logger.info("deleteDoc 요청 들어옴");
		documentService.deleteDoc(vo);
		return "redirect:/";
	}
	
	//랜덤 문서
	@GetMapping("/getRandomDoc")
	public String getRandomDoc(Model model) {
		logger.info("getRandomDoc 요청 들어옴");
		documentService.getRandomDoc();
		model.addAttribute("doc", documentService.getRandomDoc());
		return "document/docShow";
	}
	
	//문서목록
	@GetMapping("/getDocList")
	public String getdocList(@RequestParam(required = false, defaultValue = "1") int currPage ,Model model) {
		logger.info("getDocList 요청 들어옴");
		int totalCount = documentService.getTotalCount();
		int pageSize = 10;
		int blockSize = 10;
		PagingVO vo = new PagingVO(currPage, totalCount, pageSize, blockSize);
		ArrayList<DocumentVO> doclist = (ArrayList<DocumentVO>) documentService.getDocList(vo);
		model.addAttribute("doclist", doclist);
		return "document/docList";
	}
	
}
