package com.side.wiki.document.service;

import com.side.wiki.document.domain.DocumentVO;

public interface DocumentService {

	
	//�����ؾ� �� ��ɵ�(CRUD)
	//���� �ۼ�
	void insertDoc(DocumentVO vo);
	//���� ��ȸ
	DocumentVO getDoc(DocumentVO vo);
	//���� ����
	void updateDoc();
	//���� ����
	void deleteDoc();
}
