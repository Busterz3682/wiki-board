package com.side.wiki.document.mapper;

import java.util.List;

import com.side.wiki.document.domain.DocumentVO;

public interface DocumentMapper {

	//문서 작성
	void insertDoc(DocumentVO vo);
	//문서 조회
	DocumentVO getDoc(DocumentVO vo);
	//문서 수정
	void updateDoc(DocumentVO vo);
	//문서 삭제
	void deleteDoc(DocumentVO vo);
	//문서 id에 맞는 문서 받아오기
	DocumentVO getRandomDoc();
	//문서 목록 받아오기
	List<DocumentVO> getDocList();
}
