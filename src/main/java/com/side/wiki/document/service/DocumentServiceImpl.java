package com.side.wiki.document.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.side.wiki.mapper.DocumentMapper;
import com.side.wiki.vo.ChapterVO;
import com.side.wiki.vo.DetailVO;
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
	@Transactional
	public void insertDoc(DocumentVO vo, List<ChapterVO> vo2, List<DetailVO> vo3) {
		documentMapper.insertDoc(vo);
		for(ChapterVO item : vo2) {
			documentMapper.insertChapter(item);
		}
		for(DetailVO item : vo3) {
			documentMapper.insertDetail(item);
		}
	}

	//문서 조회
	@Override
	public DocumentVO getDoc(String docTitle) {
		return documentMapper.getDoc(docTitle);
	}
	@Override
	public List<DetailVO> getDetail(String docTitle) {
		return documentMapper.getDetail(docTitle);
	}
	@Override
	public List<ChapterVO> getChapter(String docTitle) {
		return documentMapper.getChapter(docTitle);
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

	@Override
	public List<String> searchList(String search) {
		return documentMapper.searchList(search);
	}

	
	

}
