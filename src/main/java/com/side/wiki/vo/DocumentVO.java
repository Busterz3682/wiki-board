package com.side.wiki.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
