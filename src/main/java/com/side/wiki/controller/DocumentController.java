package com.side.wiki.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String getDoc(String docTitle, Model model) {
		logger.info("getDoc 요청 들어옴");
		model.addAttribute("doc", documentService.getDoc(docTitle));
		System.out.println(documentService.getDoc(docTitle));
		if(documentService.getDoc(docTitle) == null) { 
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
	public String getdocList(@RequestParam(required = false, defaultValue = "1", name="currpage") int currPage ,Model model) {
		logger.info("getDocList 요청 들어옴");
		int totalCount = documentService.getTotalCount();
		int pageSize = 10;
		int blockSize = 5;
		PagingVO vo = new PagingVO(currPage, totalCount, pageSize, blockSize);
		ArrayList<DocumentVO> doclist = (ArrayList<DocumentVO>) documentService.getDocList(vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("doclist", doclist);
		model.addAttribute("page", vo);
		return "document/docList";
	}
	
	//비동기검색
	@ResponseBody
	@GetMapping("/searchDoc")
	public List<String> searchList(String search){
		ArrayList<String> searchResult =  (ArrayList<String>) documentService.searchList(search);
		System.out.println(searchResult);
		return searchResult;
	}
}
