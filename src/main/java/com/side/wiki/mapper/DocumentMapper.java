package com.side.wiki.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.side.wiki.vo.ChapterVO;
import com.side.wiki.vo.DetailVO;
import com.side.wiki.vo.DocumentVO;
import com.side.wiki.vo.PagingVO;

@Mapper
public interface DocumentMapper {

	//���� �ۼ�
	void insertDoc(DocumentVO vo);
	void insertChapter(ChapterVO vo);
	void insertDetail(DetailVO vo);

	//���� ��ȸ
	DocumentVO getDoc(String docTitle);
	List<DetailVO> getDetail(String docTitle);
	List<ChapterVO> getChapter(String docTitle);
	
	//������û ����
	int isRequested(String docTitle);
	
	//������û ����Ʈ
	List<String> getRequestedList(PagingVO vo);
	
	//���� ����
	void updateDoc(DocumentVO vo);
	void updateChapter(ChapterVO vo);
	void updateDetail(DetailVO vo);
	
	//���� ����
	void deleteDoc(String docTitle);
	void deleteRequest(String docTitle);
	
	//���� ���� ��û
	void requestDeleteDoc(String docTitle);
	
	//���� ����
	DocumentVO getRandomDoc();
	
	//���� ��� �޾ƿ���
	List<DocumentVO> getDocList(PagingVO vo);
	
	//�� �Խù���
	int getTotalCount();
	int getTotalRequest();
	
	//�񵿱� �˻�
	List<String> searchList(String search);
}
