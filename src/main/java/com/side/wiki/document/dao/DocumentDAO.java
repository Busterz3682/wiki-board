package com.side.wiki.document.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.side.wiki.common.JDBCUtil;
import com.side.wiki.document.domain.DocumentVO;

@Repository("DocumentDAO")
public class DocumentDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	//CRUD 기능 구현

	//문서 작성
	public void insertDoc(DocumentVO vo) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement("insert into doc(doc_title, doc_content, doc_id) values(?,?,doc_seq.nextval)");
			stmt.setString(1, vo.getDocTitle());
			stmt.setString(2, vo.getDocContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	//문서 조회
	public DocumentVO getDoc(DocumentVO vo) {
		conn = JDBCUtil.getConnection();
		DocumentVO doc = new DocumentVO();

		try {
			stmt = conn.prepareStatement("select * from doc where(doc_title = ?)");
			stmt.setString(1, vo.getDocTitle());
			rs = stmt.executeQuery();
			if(rs.next()) {
				doc.setDocTitle(rs.getString("doc_title"));
				doc.setDocContent(rs.getString("doc_content"));
				doc.setDocDate(rs.getDate("doc_date"));
				doc.setDocId(rs.getInt("doc_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return doc;
	}

	//문서 수정
	public void updateDoc(DocumentVO vo) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement("update doc set doc_content = ?, doc_date = sysdate where doc_title= ?");
			stmt.setString(1, vo.getDocContent());
			stmt.setString(2, vo.getDocTitle());
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	//문서 삭제



}
