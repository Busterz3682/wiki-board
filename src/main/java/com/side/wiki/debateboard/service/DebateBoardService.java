package com.side.wiki.debateboard.service;

import java.util.List;

import com.side.wiki.vo.DebateReplyVO;

public interface DebateBoardService {
	
	//��аԽ��ǿ� �ѷ��ֱ�
	public List<DebateReplyVO> getDetail(String docTitle);

	//����ۼ�
	public int insertReply(DebateReplyVO vo);

}
