package com.side.wiki.mapper;

import java.util.List;

import com.side.wiki.vo.DebateReplyVO;

public interface DebateBoardMapper {

	//��������� �������� + ��� �ҷ�����
	public List<DebateReplyVO> getDebateDetail(String docTitle);
	
	//��� �ۼ�
	public int insertReply(DebateReplyVO vo);

	
	
	
}
