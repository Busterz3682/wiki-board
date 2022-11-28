package com.side.wiki.mapper;

import com.side.wiki.vo.DebateReplyVO;

public interface DebateBoardMapper {

	//토론페이지 문서제목 + 댓글
	public DebateReplyVO getAllDetail(DebateReplyVO vo);
	
}
