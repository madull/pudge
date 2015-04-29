package com.pudge.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private int currentResult;
	@JsonIgnore
	private int page;	
	@JsonIgnore
	private int rows;
	@JsonIgnore
	private Date beginTime;
	@JsonIgnore
	private Date endTime;

	public BaseEntity() {
		super();
	}
	
	public void init(){
		getRows();
		getPage();
		getCurrentResult();
	}



	public int getPage() {
		/*if(currentPage<=0)
			currentPage = 1;*/
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getCurrentResult() {
		currentResult = (getPage()-1)*getRows();
		if(currentResult<0)
			currentResult = 0;
		return currentResult;
	}
	
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}




	public int getRows() {
		return rows==0?10:rows;
	}




	public void setRows(int rows) {
		this.rows = rows;
	}




	public Date getBeginTime() {
		return beginTime;
	}




	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}




	public Date getEndTime() {
		return endTime;
	}




	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	

}
