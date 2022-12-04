package com.side.wiki.vo;

import lombok.Data;

@Data
public class PagingVO {

	private int currPage;
	private int totalCount;
	private int pageSize;
	private int blockSize;

	private int startRow;
	private int endRow;
	private int startBlock;
	private int endBlock;

	private boolean next;
	private boolean prev;

	public PagingVO(int currPage, int totalCount, int pageSize, int blockSize) {
		this.currPage=currPage;
		this.totalCount=totalCount;
		this.pageSize=pageSize;
		this.blockSize=blockSize;
		calRow();
		calBlock();
	}

	public void calRow() {
		startRow = (currPage-1) * pageSize+1;
		endRow = startRow + pageSize-1;
		if(endRow > totalCount) {
			endRow = totalCount;
		}
	}

	public void calBlock() {
		int totalPage=(int) Math.ceil((float)totalCount/ pageSize);
		startBlock = ((currPage-1)/blockSize)*blockSize+1;
		endBlock = startBlock+blockSize-1;
		if(endBlock > totalPage)
			endBlock = totalPage;

		prev = (startBlock == 1) ? false : true;
		next = (endBlock < totalPage) ? true : false;
	}
}
