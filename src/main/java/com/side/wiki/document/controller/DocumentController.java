package com.side.wiki.document.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		return "redirect:/";
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
		if(documentService.getDoc(vo) == null) { 
			return "docInput";
		} else { 
			return "docShow";
		}
	}

	//���� ����
	@PostMapping("/updateDoc")
	public String updateDoc(DocumentVO vo) {
		logger.info("updateDoc ��û ����");
		documentService.updateDoc(vo);
		return "redirect:/";
	}

	//���� ����
	@PostMapping("/deleteDoc")
	public String deleteDoc(DocumentVO vo) {
		logger.info("deleteDoc ��û ����");
		documentService.deleteDoc(vo);
		return "redirect:/";
	}
	
	//���� ����
	@GetMapping("/getRandomDoc")
	public String getRandomDoc(Model model) {
		logger.info("getRandomDoc ��û ����");
		documentService.getRandomDoc();
		model.addAttribute("doc", documentService.getRandomDoc());
		return "docShow";
	}
	
	//�������
	@GetMapping("/getDocList")
	public String getdocList(Model model) {
		logger.info("getDocList ��û ����");
		ArrayList<DocumentVO> doclist = (ArrayList<DocumentVO>)documentService.getDocList();
		System.out.println(doclist);
		model.addAttribute("doclist", doclist);
		return "docList";
	}

}
