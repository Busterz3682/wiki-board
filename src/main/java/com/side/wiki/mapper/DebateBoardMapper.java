package com.side.wiki.mapper;

import java.util.List;

import com.side.wiki.vo.DebateReplyVO;

public interface DebateBoardMapper {

	//��������� �������� + ��� �ҷ�����
	List<DebateReplyVO> getDebateDetail(String docTitle);
	
	//��������������
	void makeDebatePage(String docTitle);
	
	//��� �ۼ�
	int insertReply(DebateReplyVO vo);

	
	
	
}
