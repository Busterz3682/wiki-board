package com.side.wiki.document.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.wiki.mapper.DocumentMapper;
import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

@Service
public class DocumentServiceImpl implements DocumentService {

//	@Autowired
//	private DocumentDAO documentDAO;
	
	@Autowired
	private DocumentMapper documentMapper;
	
	//문서 작성
	@Override
	public void insertDoc(DocumentVO vo) {
		documentMapper.insertDoc(vo);
	}

	//문서 조회
	@Override
	public DocumentVO getDoc(DocumentVO vo) {
		return documentMapper.getDoc(vo);
	}

	//문서 수정
	@Override
	public void updateDoc(DocumentVO vo) {
		documentMapper.updateDoc(vo);
	}

	//문서 삭제
	@Override
	public void deleteDoc(DocumentVO vo) {
		documentMapper.deleteDoc(vo);
	}
	
	//랜덤 문서
	public DocumentVO getRandomDoc() {
		return documentMapper.getRandomDoc();
	}

	@Override
	public List<DocumentVO> getDocList(PagingVO vo) {
		return documentMapper.getDocList(vo);
	}

	@Override
	public int getTotalCount() {
		return documentMapper.getTotalCount();
	}

}
