package com.side.wiki.mapper;

import java.util.List;

import com.side.wiki.vo.DocumentVO;

public interface DocumentMapper {

	//���� �ۼ�
	void insertDoc(DocumentVO vo);
	//���� ��ȸ
	DocumentVO getDoc(DocumentVO vo);
	//���� ����
	void updateDoc(DocumentVO vo);
	//���� ����
	void deleteDoc(DocumentVO vo);
	//���� id�� �´� ���� �޾ƿ���
	DocumentVO getRandomDoc();
	//���� ��� �޾ƿ���
	List<DocumentVO> getDocList();
}
