package com.side.wiki.document.service;

import java.util.List;

import com.side.wiki.document.domain.DocumentVO;

public interface DocumentService {

	//구현해야 할 기능들(CRUD)
	//문서 작성
	void insertDoc(DocumentVO vo);
	//문서 조회
	DocumentVO getDoc(DocumentVO vo);
	//문서 수정
	void updateDoc(DocumentVO vo);
	//문서 삭제
	void deleteDoc(DocumentVO vo);
	//랜덤 문서
	DocumentVO getRandomDoc();
	//문서 전체 조회
	List<DocumentVO> getDocList();
}
