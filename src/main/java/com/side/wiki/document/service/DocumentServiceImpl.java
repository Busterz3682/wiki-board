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
	
	//���� �ۼ�
	@Override
	public void insertDoc(DocumentVO vo) {
		documentMapper.insertDoc(vo);
	}

	//���� ��ȸ
	@Override
	public DocumentVO getDoc(DocumentVO vo) {
		return documentMapper.getDoc(vo);
	}

	//���� ����
	@Override
	public void updateDoc(DocumentVO vo) {
		documentMapper.updateDoc(vo);
	}

	//���� ����
	@Override
	public void deleteDoc(DocumentVO vo) {
		documentMapper.deleteDoc(vo);
	}
	
	//���� ����
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
