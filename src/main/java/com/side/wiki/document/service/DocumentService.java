package com.side.wiki.document.service;

import java.util.ArrayList;
import java.util.List;

import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

public interface DocumentService {

	//�����ؾ� �� ��ɵ�(CRUD)
	//���� �ۼ�
	void insertDoc(DocumentVO vo);
	//���� ��ȸ
	DocumentVO getDoc(DocumentVO vo);
	//���� ����
	void updateDoc(DocumentVO vo);
	//���� ����
	void deleteDoc(DocumentVO vo);
	//���� ����
	DocumentVO getRandomDoc();
	//���� ��ü ��ȸ
	List<DocumentVO> getDocList(PagingVO vo);
	//��ü �Խù� ��
	int getTotalCount();
	//�񵿱� �˻�
	List<String> searchList(String search);
}
