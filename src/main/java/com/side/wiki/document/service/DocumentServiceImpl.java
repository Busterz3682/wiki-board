package com.side.wiki.document.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.wiki.document.domain.DocumentVO;
import com.side.wiki.document.mapper.DocumentMapper;

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
	public List<DocumentVO> getDocList() {
		return documentMapper.getDocList();
	}

}
