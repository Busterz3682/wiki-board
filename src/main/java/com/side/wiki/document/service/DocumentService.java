package com.side.wiki.document.service;

import java.util.List;

import com.side.wiki.vo.ChapterVO;
import com.side.wiki.vo.DetailVO;
import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

public interface DocumentService {

	//�����ؾ� �� ��ɵ�(CRUD)
	//���� �ۼ�
	void insertDoc(DocumentVO vo, List<ChapterVO> vo2, List<DetailVO> vo3);
	//���� ��ȸ
	DocumentVO getDoc(String docTitle);
	List<DetailVO> getDetail(String docTitle);
	List<ChapterVO> getChapter(String docTitle);
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
