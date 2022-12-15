package com.side.wiki.mapper;

import java.util.List;

import com.side.wiki.vo.DebateReplyVO;

public interface DebateBoardMapper {

	//토론페이지 문서제목 + 댓글 불러오기
	List<DebateReplyVO> getDebateDetail(String docTitle);
	
	//토론페이지만들기
	void makeDebatePage(String docTitle);
	
	//댓글 작성
	int insertReply(DebateReplyVO vo);

	
	
	
}
