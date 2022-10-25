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

	//�����ؾ� �� ��ɵ�(CRUD)
	//���� �ۼ�
	@PostMapping("/insertDoc")
	public String insertDoc(DocumentVO vo) {
		logger.info("insertDoc ��û����");
		documentService.insertDoc(vo);
		return "home";
	}

	//���� �ۼ� ������ �̵�
	@GetMapping("/insertDoc")
	public String insertDocPage() {
		logger.info("�����ۼ� ������ �̵�");
		return "docInput";
	}

	//���� ��ȸ
	@GetMapping("/getDoc")
	public String getDoc(DocumentVO vo, Model model) {
		logger.info("getDoc ��û ����");
		model.addAttribute("doc", documentService.getDoc(vo));
		return "docShow";

	}

	//���� ����
	@PostMapping("/updateDoc")
	public String updateDoc() {
		logger.info("updateDoc ��û ����");
		return "home";
	}

	//���� ����
	public String deleteDoc() {
		return "home";
	}

}
