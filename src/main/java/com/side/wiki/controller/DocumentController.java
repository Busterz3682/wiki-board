package com.side.wiki.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.side.wiki.document.service.DocumentService;
import com.side.wiki.vo.ChapterVO;
import com.side.wiki.vo.DetailVO;
import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

@Controller
@RequestMapping("/wiki")
public class DocumentController {

	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

	@Autowired
	private DocumentService documentService;

	//문서 작성 페이지 이동
	@GetMapping("/insertDoc")
	public String insertDocPage() {
		logger.info("문서작성 페이지 이동");
		return "document/docInput";
	}

	//문서 작성
	@PostMapping("/insertDoc")
	public String insertDoc(HttpServletRequest req, @RequestParam(name = "file", required = false) MultipartFile file) {
		logger.info("insertDoc 요청들어옴");
		String docTitle = req.getParameter("docTitle");
		String docContent = req.getParameter("docContent");
		DocumentVO vo = new DocumentVO(docTitle, docContent, null, 0, 0);

		File uploadPath = new File("c:\\upload\\" + docTitle);
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		logger.info("Upload File Name : " + file.getOriginalFilename());
		logger.info("Upload File size : " + file.getSize());
		if(file.getSize() > 0) {
			File saveFile = new File(uploadPath, "image.jpg");
			vo.setDocImage(1);
			try {
				file.transferTo(saveFile);
			} catch(Exception e) {
				logger.error(e.getMessage());
			}
		}

		//문서(텍스트) 작성 시작
		List<ChapterVO> cList = new ArrayList<ChapterVO>();
		for(int i = 0; i < req.getParameterValues("chapterTitle").length; i ++) {
			cList.add(new ChapterVO(docTitle, i + 1, req.getParameterValues("chapterTitle")[i]));
		}
		List<DetailVO> dList = new ArrayList<DetailVO>();
		for(int i = 1; i <= req.getParameterValues("chapterTitle").length; i++) {
			for(int j = 0; j < req.getParameterValues("chapterContent" + i).length; j ++) {
				dList.add(new DetailVO(docTitle, i, req.getParameterValues("chapterContent" + i)[j], j + 1));
			}
		} // 문서(텍스트) 작성 끝
		documentService.insertDoc(vo, cList, dList);
		return "redirect:/wiki/getDoc/" + docTitle;
	}

	//문서 조회
	@GetMapping("/getDoc/{docTitle}")
	public String getDoc(@PathVariable String docTitle, Model model) {
		logger.info("getDoc 요청 들어옴");
		model.addAttribute("isRequested", documentService.isRequested(docTitle));
		model.addAttribute("doc", documentService.getDoc(docTitle));
		model.addAttribute("detail", documentService.getDetail(docTitle));
		model.addAttribute("chapter",  documentService.getChapter(docTitle));
		return "document/docShow";
	}

	//문서 수정 페이지
	@GetMapping("/updateDoc/{docTitle}")
	public String updateDocPage(@PathVariable String docTitle, Model model) {
		model.addAttribute("doc", documentService.getDoc(docTitle));
		model.addAttribute("detail", documentService.getDetail(docTitle));
		model.addAttribute("chapter",  documentService.getChapter(docTitle));
		return "document/docModify";
	}

	//문서 수정
	@PostMapping("/updateDoc")
	public String updateDoc(HttpServletRequest req) {
		logger.info("updateDoc 요청 들어옴");
		String docTitle = req.getParameter("docTitle");
		String docContent = req.getParameter("docContent");
		DocumentVO vo = new DocumentVO(docTitle, docContent, null, 0, 0);
		List<ChapterVO> cList = new ArrayList<ChapterVO>();
		for(int i = 0; i < req.getParameterValues("chapterTitle").length; i ++) {
			cList.add(new ChapterVO(docTitle, i + 1, req.getParameterValues("chapterTitle")[i]));
		}
		List<DetailVO> dList = new ArrayList<DetailVO>();
		for(int i = 1; i <= req.getParameterValues("chapterTitle").length; i++) {
			for(int j = 0; j < req.getParameterValues("chapterContent" + i).length; j ++) {
				dList.add(new DetailVO(docTitle, i, req.getParameterValues("chapterContent" + i)[j], j + 1));
			}
		}
		documentService.updateDoc(vo, cList, dList);
		return "redirect:/wiki/getDoc/" + docTitle;
	}

	//문서 삭제 요청
	@GetMapping("/requestDeleteDoc/{docTitle}")
	public String requestDeleteDoc(@PathVariable String docTitle) {
		logger.info("requestDeleteDoc 요청 들어옴");
		documentService.requestDeleteDoc(docTitle);
		return "redirect:/wiki/getDoc/" + docTitle;
	}
	
	//문서 삭제(관리자 전용)
	@PostMapping("/deleteDoc/{docTitle}")
	public String deleteDoc(@PathVariable String docTitle) {
		logger.info("deleteDoc 요청 들어옴");
		System.out.println(docTitle);
		documentService.deleteDoc(docTitle);
		return "redirect:/wiki/getReqList";
	}

	//랜덤 문서
	@GetMapping("/getRandomDoc")
	public String getRandomDoc(Model model) {
		logger.info("getRandomDoc 요청 들어옴");
		String docTitle = (documentService.getRandomDoc()).getDocTitle();
		model.addAttribute("isRequested", documentService.isRequested(docTitle));
		model.addAttribute("doc", documentService.getDoc(docTitle));
		model.addAttribute("detail", documentService.getDetail(docTitle));
		model.addAttribute("chapter",  documentService.getChapter(docTitle));
		return "document/docShow";
	}

	//문서목록
	@GetMapping("/getDocList")
	public String getdocList(@RequestParam(required = false, defaultValue = "1", name="currpage") int currPage ,Model model) {
		logger.info("getDocList 요청 들어옴");
		int totalCount = documentService.getTotalCount();
		int pageSize = 10;
		int blockSize = 10;
		PagingVO vo = new PagingVO(currPage, totalCount, pageSize, blockSize);
		ArrayList<DocumentVO> doclist = (ArrayList<DocumentVO>) documentService.getDocList(vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("doclist", doclist);
		model.addAttribute("page", vo);
		return "document/docList";
	}
	
	//삭제요청문서목록(관리자전용)
	@GetMapping("/getReqList")
	public String getReqList(@RequestParam(required = false, defaultValue = "1", name="currpage") int currPage ,Model model) {
		int totalCount = documentService.getTotalRequest();
		int pageSize = 10;
		int blockSize = 10;
		PagingVO vo = new PagingVO(currPage, totalCount, pageSize, blockSize);
		ArrayList<String> reqList = (ArrayList<String>) documentService.getRequestedList(vo);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("reqList", reqList);
		model.addAttribute("page", vo);
		return "admin/requestList";
	}
	

	//비동기검색
	@ResponseBody
	@GetMapping("/searchDoc")
	public List<String> searchList(String search){
		ArrayList<String> searchResult =  (ArrayList<String>) documentService.searchList(search);
		return searchResult;
	}
	
	//문서 존재 여부 체크
	@ResponseBody
	@GetMapping("/check")
	public String check(String docTitle) {
		if(documentService.getDoc(docTitle) == null) {
			return "ok";
		} else {
			return "exist";
		}
	}
}
