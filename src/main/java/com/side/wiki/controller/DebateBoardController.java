package com.side.wiki.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	//������и�������� �̵�
	@GetMapping("/list")
	public String getDocDebate(Model model) {
		ArrayList<DocumentVO> doclist = (ArrayList<DocumentVO>) documentService.getDocList();
		model.addAttribute("doclist", doclist);
		log.info("��и��������");
		return "debate/boardlist";
	}
	
	//������� �󼼺���
	@GetMapping("/debatedetail")
	public String getDocDebateDetail(DebateReplyVO vo, Model model) {
		log.info(vo.getDocTitle()+"�� ���� ��������� �̵�");
		model.addAttribute("debatedetail", debateBoardService.getDetail(vo));
		return "debate/boarddebate";
	}
	
	@PostMapping("/insertreply")
	@ResponseBody
	public int insertReply(@ModelAttribute DebateReplyVO vo) {
		log.info("��۵�Ͽ�û");
		System.out.println(vo);
		return debateBoardService.insertReply(vo);
	}

}
