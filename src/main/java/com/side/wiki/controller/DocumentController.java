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

	//���� �ۼ� ������ �̵�
	@GetMapping("/insertDoc")
	public String insertDocPage() {
		logger.info("�����ۼ� ������ �̵�");
		return "document/docInput";
	}

	//���� �ۼ�
	@PostMapping("/insertDoc")
	public String insertDoc(HttpServletRequest req, @RequestParam(name = "file", required = false) MultipartFile file) {
		logger.info("insertDoc ��û����");
		String docTitle = req.getParameter("docTitle");
		String docContent = req.getParameter("docContent");
		DocumentVO vo = new DocumentVO(docTitle, docContent, null, 0, 0);

		File uploadPath = new File("c:\\upload\\" + docTitle);
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		logger.info("Upload File Name : " + file.getOriginalFilename());
		logger.info("Upload File size : " + file.getSize());
		if(file.getSize() != 0) {
			File saveFile = new File(uploadPath, "image.jpg");
			vo.setDocImage(1);
			try {
				file.transferTo(saveFile);
			} catch(Exception e) {
				logger.error(e.getMessage());
			}
		}

		//����(�ؽ�Ʈ) �ۼ� ����
		List<ChapterVO> cList = new ArrayList<ChapterVO>();
		for(int i = 0; i < req.getParameterValues("chapterTitle").length; i ++) {
			cList.add(new ChapterVO(docTitle, i + 1, req.getParameterValues("chapterTitle")[i]));
		}
		List<DetailVO> dList = new ArrayList<DetailVO>();
		for(int i = 1; i <= req.getParameterValues("chapterTitle").length; i++) {
			for(int j = 0; j < req.getParameterValues("chapterContent" + i).length; j ++) {
				dList.add(new DetailVO(docTitle, i, req.getParameterValues("chapterContent" + i)[j], j + 1));
			}
		} // ����(�ؽ�Ʈ) �ۼ� ��
		documentService.insertDoc(vo, cList, dList);
		return "redirect:/";
	}

	//���� ��ȸ
	@GetMapping("/getDoc/{docTitle}")
	public String getDoc(@PathVariable String docTitle, Model model) {
		logger.info("getDoc ��û ����");
		System.out.println(documentService.getDoc(docTitle));
		model.addAttribute("doc", documentService.getDoc(docTitle));
		model.addAttribute("detail", documentService.getDetail(docTitle));
		model.addAttribute("chapter",  documentService.getChapter(docTitle));
		return "document/docShow";
	}

	//���� ���� ������
	@GetMapping("/updateDoc/{docTitle}")
	public String updateDocPage(@PathVariable String docTitle, Model model) {
		model.addAttribute("doc", documentService.getDoc(docTitle));
		model.addAttribute("detail", documentService.getDetail(docTitle));
		model.addAttribute("chapter",  documentService.getChapter(docTitle));
		return "document/docModify";
	}

	//���� ����
	@PostMapping("/updateDoc")
	public String updateDoc(HttpServletRequest req) {
		logger.info("updateDoc ��û ����");
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
		String docTitle = (documentService.getRandomDoc()).getDocTitle();
		model.addAttribute("doc", documentService.getDoc(docTitle));
		model.addAttribute("detail", documentService.getDetail(docTitle));
		model.addAttribute("chapter",  documentService.getChapter(docTitle));
		return "document/docShow";
	}

	//�������
	@GetMapping("/getDocList")
	public String getdocList(@RequestParam(required = false, defaultValue = "1", name="currpage") int currPage ,Model model) {
		logger.info("getDocList ��û ����");
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

	//�񵿱�˻�
	@ResponseBody
	@GetMapping("/searchDoc")
	public List<String> searchList(String search){
		ArrayList<String> searchResult =  (ArrayList<String>) documentService.searchList(search);
		return searchResult;
	}
}
