package com.side.wiki.document.mapper;

import com.side.wiki.document.domain.DocumentVO;

public interface DocumentMapper {

	//문서 작성
	void insertDoc(DocumentVO vo);
	//문서 조회
	DocumentVO getDoc(DocumentVO vo);
	//문서 수정
	void updateDoc(DocumentVO vo);
	//문서 삭제
	void deleteDoc();

}
