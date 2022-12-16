package com.side.wiki.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 CREATE TABLE DOC 
(
  DOC_TITLE VARCHAR2(500) NOT NULL 
, DOC_CONTENT VARCHAR2(4000) 
, DOC_DATE DATE DEFAULT sysdate 
, DOC_ID NUMBER(5,0) 
, CONSTRAINT TABLE1_PK PRIMARY KEY 
  (
    DOC_TITLE 
  )
  ENABLE 
);

create sequence doc_seq
start with 1
INCREMENT by 1
MAXVALUE 99999
nocache
nocycle;

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentVO {

	private String docTitle;
	private String docContent;
	private Date docDate;
	private int docId;
	private int docImage;
}
