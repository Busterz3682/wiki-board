package com.side.wiki.document.mapper;

import com.side.wiki.document.domain.DocumentVO;

public interface DocumentMapper {

	//���� �ۼ�
	void insertDoc(DocumentVO vo);
	//���� ��ȸ
	DocumentVO getDoc(DocumentVO vo);
	//���� ����
	void updateDoc(DocumentVO vo);
	//���� ����
	void deleteDoc();

}
