package com.side.wiki.debateboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.wiki.mapper.DebateBoardMapper;
import com.side.wiki.vo.DebateReplyVO;

@Service
public class DebateBoardServiceImpl implements DebateBoardService {

	private DebateBoardMapper debateBoardMapper;
	
	@Autowired
	public void setMapper(DebateBoardMapper debateBoardMapper) {
		this.debateBoardMapper = debateBoardMapper;
	}
	
	@Override
	public List<DebateReplyVO> getDetail(String docTitle) {
		return debateBoardMapper.getDebateDetail(docTitle);
	}

	@Override
	public int insertReply(DebateReplyVO vo) {
		return debateBoardMapper.insertReply(vo);
	}

	@Override
	public int deleteReply(DebateReplyVO vo) {
		return debateBoardMapper.deleteReply(vo);
	}
	
	

}
