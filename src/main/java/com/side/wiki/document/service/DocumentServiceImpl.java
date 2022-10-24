package com.side.wiki.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.wiki.document.dao.DocumentDAO;
import com.side.wiki.document.domain.DocumentVO;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAO documentDAO;
	
	//문서 작성
	@Override
	public void insertDoc(DocumentVO vo) {
		documentDAO.insertDoc(vo);
	}

	//문서 조회
	@Override
	public DocumentVO getDoc() {
		return null;
	}

	//문서 수정
	@Override
	public void updateDoc() {
		
	}

	//문서 삭제
	@Override
	public void deleteDoc() {
		
	}

}
