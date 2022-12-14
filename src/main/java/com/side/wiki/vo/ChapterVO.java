package com.side.wiki.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChapterVO {

	private String docTitle;
	private int chapterIndex;
	private String chapterTitle;
}
