package com.side.wiki.document.service;

import com.side.wiki.document.domain.DocumentVO;

public interface DocumentService {

	
	//�����ؾ� �� ��ɵ�(CRUD)
	//���� �ۼ�
	void insertDoc();
	//���� ��ȸ
	DocumentVO getDocList();
	//���� ����
	void updateDoc();
	//���� ����
	void deleteDoc();
}
