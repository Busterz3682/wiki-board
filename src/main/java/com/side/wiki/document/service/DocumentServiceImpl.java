package com.side.wiki.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.wiki.document.dao.DocumentDAO;
import com.side.wiki.document.domain.DocumentVO;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAO documentDAO;
	
	//���� �ۼ�
	@Override
	public void insertDoc(DocumentVO vo) {
		documentDAO.insertDoc(vo);
	}

	//���� ��ȸ
	@Override
	public DocumentVO getDoc() {
		return null;
	}

	//���� ����
	@Override
	public void updateDoc() {
		
	}

	//���� ����
	@Override
	public void deleteDoc() {
		
	}

}
