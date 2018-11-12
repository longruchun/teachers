package com.yangsha.util;

import java.util.List;

public class pager<T> {
	
	private List<T> datas;
	private int offSet;
	private int pageSize;
	private int totalRecord;
	
	

	/**
	 * @return the datas
	 */
	public List<T> getDatas() {
		return datas;
	}

	/**
	 * @param datas
	 *            the datas to set
	 */
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	/**
	 * @return the offSet
	 */
	public int getOffSet() {
		return offSet;
	}

	/**
	 * @param offSet
	 *            the offSet to set
	 */
	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalRecord
	 */
	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * @param totalRecord
	 *            the totalRecord to set
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}


}
