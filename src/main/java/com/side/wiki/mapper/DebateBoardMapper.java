package com.side.wiki.mapper;

import java.util.List;

import com.side.wiki.vo.DebateReplyVO;

public interface DebateBoardMapper {

	//토론페이지 문서제목 + 댓글 불러오기
	public List<DebateReplyVO> getDebateDetail(DebateReplyVO vo);
	
	//댓글 작성
	public int insertReply(DebateReplyVO vo);

	
	
	
}
