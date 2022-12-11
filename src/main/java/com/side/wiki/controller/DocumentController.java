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
		return "document/docInput";
	}

	//���� ��ȸ
	@GetMapping("/getDoc")
	public String getDoc(DocumentVO vo, Model model) {
		logger.info("getDoc ��û ����");
		model.addAttribute("doc", documentService.getDoc(vo));
		if(documentService.getDoc(vo) == null) { 
			return "document/docInput";
		} else { 
			return "document/docShow";
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
		return "document/docShow";
	}
	
	//�������
	@GetMapping("/getDocList")
	public String getdocList(@RequestParam(required = false, defaultValue = "1", name="currpage") int currPage ,Model model) {
		logger.info("getDocList ��û ����");
		int totalCount = documentService.getTotalCount();
		int pageSize = 10;
		int blockSize = 5;
		PagingVO vo = new PagingVO(currPage, totalCount, pageSize, blockSize);
		ArrayList<DocumentVO> doclist = (ArrayList<DocumentVO>) documentService.getDocList(vo);
		model.addAttribute("doclist", doclist);
		model.addAttribute("page", vo);
		return "document/docList";
	}
	
	//�񵿱�˻�
	@ResponseBody
	@GetMapping("/searchDoc")
	public List<String> searchList(String search){
		ArrayList<String> searchResult =  (ArrayList<String>) documentService.searchList(search);
		System.out.println(searchResult);
		return searchResult;
	}
}
