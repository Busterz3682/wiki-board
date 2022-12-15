package com.side.wiki.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailVO {
	
	private String docTitle;
	private int chapterIndex;
	private String chapterContent;
	private int detailIndex;
}
