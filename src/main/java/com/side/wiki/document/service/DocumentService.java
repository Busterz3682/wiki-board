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
	//������û ����
	int isRequested(String docTitle);
	//������û ����Ʈ
	List<String> getRequestedList(PagingVO vo);
	//���� ����
	void updateDoc(DocumentVO vo, List<ChapterVO> vo2, List<DetailVO> vo3);
	//���� ����
	void deleteDoc(String docTitle);
	//���� ���� ��û
	void requestDeleteDoc(String docTitle);
	//���� ����
	DocumentVO getRandomDoc();
	//���� ��ü ��ȸ
	List<DocumentVO> getDocList(PagingVO vo);
	//��ü �Խù� ��
	int getTotalCount();
	int getTotalRequest();
	//�񵿱� �˻�
	List<String> searchList(String search);
}
