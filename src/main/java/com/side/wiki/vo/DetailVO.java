package com.side.wiki.vo;

import lombok.Data;

@Data
public class DetailVO {

	private String docTitle;
	private int chapterLevel;
	private int chapterIndex;
	private String chapterTitle;
	private String detailContent;
}
