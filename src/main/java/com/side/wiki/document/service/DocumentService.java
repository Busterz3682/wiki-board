package com.side.wiki.document.service;

import com.side.wiki.document.domain.DocumentVO;

public interface DocumentService {

	
	//구현해야 할 기능들(CRUD)
	//문서 작성
	void insertDoc();
	//문서 조회
	DocumentVO getDocList();
	//문서 수정
	void updateDoc();
	//문서 삭제
	void deleteDoc();
}
