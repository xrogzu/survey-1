package com.fire.survey.utils;

import java.util.List;

public class Page<T> {
	private int pageNo;
	private int totalRecordNo;
	private int pageSize = 4;
	private int totalPageNo;
	private List<T> list;

	public Page(String pageNoStr, int totalRecordNo) {
		this.totalRecordNo = totalRecordNo;
		totalPageNo = totalRecordNo / pageSize + (totalRecordNo % pageSize == 0 ? 0 : 1);
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {
		}

		if (pageNo > totalPageNo) {
			pageNo = totalPageNo;
		}
		if (pageNo < 1) {
			pageNo = 1;
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalRecordNo() {
		return totalRecordNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPageNo() {
		return totalPageNo;
	}

	public boolean isHasNext() {
		return pageNo < totalPageNo;
	}

	public boolean isHasPrev() {
		return pageNo > 1;
	}

	public int getNext() {

		return pageNo + 1;
	}

	public int getPrev() {
		return pageNo - 1;
	}
}
