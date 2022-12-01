package com.side.wiki.vo;


import lombok.Data;
/*
 * CREATE TABLE DEBATEREPLY 
(
  DOCTITLE VARCHAR2(500 BYTE) 
, EMAIL VARCHAR2(100 BYTE) 
, CONTENT VARCHAR2(4000 BYTE) 
, REGDATE DATE DEFAULT sysdate 
)
alter table debatereply
add CONSTRAINT fk_debatereply 
foreign key(doc_title) references doc (doc_title);
 */


@Data
public class DebateReplyVO {

	private String docTitle;
	private String email;
	private String content;
	private String regDate;
	private int replyNo;
}
