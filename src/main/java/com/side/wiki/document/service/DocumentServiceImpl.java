package com.side.wiki.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.wiki.document.domain.DocumentVO;
import com.side.wiki.document.mapper.DocumentMapper;

@Service
public class DocumentServiceImpl implements DocumentService {

//	@Autowired
//	private DocumentDAO documentDAO;
	
	@Autowired
	private DocumentMapper documentMapper;
	
	//문서 작성
	@Override
	public void insertDoc(DocumentVO vo) {
		documentMapper.insertDoc(vo);
	}

	//문서 조회
	@Override
	public DocumentVO getDoc(DocumentVO vo) {
		return documentMapper.getDoc(vo);
	}

	//문서 수정
	@Override
	public void updateDoc(DocumentVO vo) {
		documentMapper.updateDoc(vo);
	}

	//문서 삭제
	@Override
	public void deleteDoc() {
		
	}

}
