package com.side.wiki.document.service;

import java.util.List;

import com.side.wiki.vo.ChapterVO;
import com.side.wiki.vo.DetailVO;
import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

public interface DocumentService {

	//구현해야 할 기능들(CRUD)
	//문서 작성
	void insertDoc(DocumentVO vo, List<ChapterVO> vo2, List<DetailVO> vo3);
	//문서 조회
	DocumentVO getDoc(String docTitle);
	List<DetailVO> getDetail(String docTitle);
	List<ChapterVO> getChapter(String docTitle);
	//삭제요청 여부
	int isRequested(String docTitle);
	//삭제요청 리스트
	List<String> getRequestedList(PagingVO vo);
	//문서 수정
	void updateDoc(DocumentVO vo, List<ChapterVO> vo2, List<DetailVO> vo3);
	//문서 삭제
	void deleteDoc(String docTitle);
	//문서 삭제 요청
	void requestDeleteDoc(String docTitle);
	//랜덤 문서
	DocumentVO getRandomDoc();
	//문서 전체 조회
	List<DocumentVO> getDocList(PagingVO vo);
	//전체 게시물 수
	int getTotalCount();
	int getTotalRequest();
	//비동기 검색
	List<String> searchList(String search);
}
