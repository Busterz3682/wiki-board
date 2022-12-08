package com.side.wiki.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.side.wiki.debateboard.service.DebateBoardService;
import com.side.wiki.document.service.DocumentService;
import com.side.wiki.vo.DebateReplyVO;
import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

import lombok.extern.java.Log;

@RequestMapping("/debate")
@Controller
@Log
public class DebateBoardController {

	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private DebateBoardService debateBoardService;

	//문서토론목록페이지 이동
	@GetMapping("/list")
	public String getDocDebate(@RequestParam(required = false, defaultValue = "1", name = "currpage") int currPage, Model model) {
		int totalCount = documentService.getTotalCount();
		int pageSize = 10;
		int blockSize = 5;
		PagingVO vo = new PagingVO(currPage, totalCount, pageSize, blockSize);
		ArrayList<DocumentVO> doclist = (ArrayList<DocumentVO>) documentService.getDocList(vo);
		model.addAttribute("doclist", doclist);
		model.addAttribute("page", vo);
		log.info("토론목록페이지");
		return "debate/boardlist";
	}
	
	//문서토론 상세보기
	@GetMapping("/debatedetail")
	public String getDocDebateDetail(DebateReplyVO vo, Model model) {
		log.info(vo.getDocTitle()+"에 대한 토론페이지 이동");
		model.addAttribute("debatedetail", debateBoardService.getDetail(vo));
		return "debate/boarddebate";
	}
	
	//댓글입력
	@PostMapping("/insertreply")
	@ResponseBody
	public int insertReply(@ModelAttribute DebateReplyVO vo) {
		log.info("댓글등록요청");
		return debateBoardService.insertReply(vo);
	}
	
	

}
