package com.side.wiki.debateboard.service;

import java.util.List;

import com.side.wiki.vo.DebateReplyVO;

public interface DebateBoardService {
	
	//토론게시판에 뿌려주기
	public List<DebateReplyVO> getDetail(String docTitle);

	//댓글작성
	public int insertReply(DebateReplyVO vo);

	public int deleteReply(DebateReplyVO vo);

}
