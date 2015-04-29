package com.pudge.util;

import java.util.ArrayList;
import java.util.List;



public class PageUtil<T>{
	
	private static final int DEFAULT_PAGE_SIZE = 10;
	
	
	private int showCount; //每页显示记录数
	private int total;		//总页数
	private int records;	//总记录数
	private int page;	//当前页
	private int currentResult;	//当前记录起始索引
	
	private List<T> rows = new ArrayList<T>();
	

	
	public PageUtil(int showCount, int records, int currentPage, List<T> rows) {
		super();
		this.showCount = showCount<=0?DEFAULT_PAGE_SIZE:showCount;//默认10
		this.records = records;
		this.rows = rows;
		this.page = currentPage;
		this.page = this.getPage();
		this.total = this.getTotal();
		this.currentResult = getCurrentResult();
		
	}
	
	public int getTotal() {
		if(records%showCount==0)
			total = records/showCount;
		else
			total = records/showCount+1;
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getRecords() {
		return records;
	}
	
	public void setRecords(int records) {
		this.records = records;
	}
	
	public int getPage() {
		if(page<=0)
			page = 1;
		if(page>getTotal())
			page = getTotal();
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	
	public int getShowCount() {
		return showCount;
	}
	
	public void setShowCount(int showCount) {
		
		this.showCount = showCount;
	}
	
	public int getCurrentResult() {
		currentResult = (getPage()-1)*getShowCount();
		if(currentResult<0)
			currentResult = 0;
		return currentResult;
	}
	
	
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
