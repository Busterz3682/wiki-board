package com.side.wiki.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.side.wiki.debateboard.service.DebateBoardService;
import com.side.wiki.document.service.DocumentService;
import com.side.wiki.vo.DebateReplyVO;
import com.side.wiki.vo.DocumentVO;

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
	@GetMapping("/debate")
	public String getDocDebate(Model model) {
		ArrayList<DocumentVO> doclist = (ArrayList<DocumentVO>) documentService.getDocList();
		model.addAttribute("doclist", doclist);
		log.info("토론목록페이지");
		return "debate/boardlist";
	}
	
	//문서토론 상세보기
	@GetMapping("/debatedetail")
	public String getDocDebateDetail(DebateReplyVO vo, Model model) {
		model.addAttribute("debatedetail", debateBoardService.getDetail(vo));
		return "debate/boarddebate";
	}
	
	@PostMapping("/insertreply")
	public void insertReply(DebateReplyVO vo) {
		debateBoardService.insertReply(vo);
	}

}
