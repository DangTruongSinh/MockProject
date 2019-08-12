package com.bus.model;

public class PageModel {
	private int curentPage = 1;
	private int maxPageItem = 4;
	private int totalPage;
	
	
	public int getCurentPage() {
		return curentPage;
	}
	public void setCurentPage(int curentPage) {
		this.curentPage = curentPage;
	}
	public int getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(int maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
