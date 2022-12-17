package com.side.wiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.side.wiki.debateboard.service.DebateBoardService;
import com.side.wiki.vo.DebateReplyVO;

import lombok.extern.java.Log;

@RequestMapping("/debate")
@Controller
@Log
public class DebateBoardController {

	@Autowired
	private DebateBoardService debateBoardService;

	//������� �󼼺���
	@GetMapping("/debatedetail/{docTitle}")
	public String getDocDebateDetail(@PathVariable String docTitle, Model model) {
		log.info(docTitle+ " �� ���� ��������� �̵�");
		model.addAttribute("debatedetail", debateBoardService.getDetail(docTitle));
		return "debate/boarddebate";
	}
	
	//����Է�
	@PostMapping("/insertreply")
	@ResponseBody
	public int insertReply(DebateReplyVO vo) {
		log.info("��۵�Ͽ�û");
		return debateBoardService.insertReply(vo);
	}
	
	//��ۻ���
	@PostMapping("/deletereply")
	@ResponseBody
	public int deleteReply(DebateReplyVO vo) {
		return debateBoardService.deleteReply(vo);
	}
	

}
