package com.side.wiki.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.side.wiki.vo.ChapterVO;
import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

@Mapper
public interface DocumentMapper {

	//문서 작성
	void insertDoc(DocumentVO vo);
	void insertChapter(DocumentVO vo);
	void insertDetail(ChapterVO vo2);

	//문서 조회
	List<DocumentVO> getDoc(String docTitle);
	List<ChapterVO> getDetail(String docTitle);
	
	//문서 수정
	void updateDoc(DocumentVO vo);
	
	//문서 삭제
	void deleteDoc(DocumentVO vo);
	
	//랜덤 문서
	DocumentVO getRandomDoc();
	
	//문서 목록 받아오기
	List<DocumentVO> getDocList(PagingVO vo);
	
	//총 게시물수
	int getTotalCount();
	
	//비동기 검색
	List<String> searchList(String search);
}
