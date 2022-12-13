package com.side.wiki.document.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.wiki.mapper.DocumentMapper;
import com.side.wiki.vo.ChapterVO;
import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

@Service
public class DocumentServiceImpl implements DocumentService {

//	@Autowired
//	private DocumentDAO documentDAO;
	
	@Autowired
	private DocumentMapper documentMapper;
	
	//���� �ۼ�
	@Override
	public void insertDoc(DocumentVO vo, ChapterVO vo2) {
		documentMapper.insertDoc(vo);
		documentMapper.insertChapter(vo);
		documentMapper.insertDetail(vo2);
	}

	//���� ��ȸ
	@Override
	public List<DocumentVO> getDoc(String docTitle) {
		return documentMapper.getDoc(docTitle);
	}
	@Override
	public List<ChapterVO> getDetail(String docTitle) {
		return documentMapper.getDetail(docTitle);
	}

	//���� ����
	@Override
	public void updateDoc(DocumentVO vo) {
		documentMapper.updateDoc(vo);
	}

	//���� ����
	@Override
	public void deleteDoc(DocumentVO vo) {
		documentMapper.deleteDoc(vo);
	}
	
	//���� ����
	public DocumentVO getRandomDoc() {
		return documentMapper.getRandomDoc();
	}

	@Override
	public List<DocumentVO> getDocList(PagingVO vo) {
		return documentMapper.getDocList(vo);
	}

	@Override
	public int getTotalCount() {
		return documentMapper.getTotalCount();
	}

	@Override
	public List<String> searchList(String search) {
		return documentMapper.searchList(search);
	}

	

}
