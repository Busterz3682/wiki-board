package com.side.wiki.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.side.wiki.document.service.DocumentService;
import com.side.wiki.vo.DebateReplyVO;
import com.side.wiki.vo.DocumentVO;

@RequestMapping("/board")
@Controller
public class DebateBoardController {

	@Autowired
	private DocumentService documentService;

	//문서토론목록페이지 이동
	@GetMapping("/debate")
	public String getDocDebate(Model model) {
		ArrayList<DocumentVO> doclist = (ArrayList<DocumentVO>) documentService.getDocList();
		model.addAttribute("doclist", doclist);
		return "board/boardlist";
	}
	
	//
	@GetMapping("/debatedetail")
	public String getDocDebateDetail(DebateReplyVO vo, Model model) {
		model.addAttribute("docTitle", vo.getDocTitle());
		return "board/boarddebate";
	}

}
