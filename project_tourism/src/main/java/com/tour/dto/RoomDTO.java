package com.tour.dto;

public class RoomDTO {
	private String numOfRows;
	private String pageNo;
	private String totalCount;
	private String contentid;
	private String contenttypeid;
	private String createdtime;
	private String readcount;
	private String modifiedtime;
	private String tel;
	private String title;
	private String firstimage;
	private String firstimage2;
	private String addr1;
	private String addr2;
	public String getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(String numOfRows) {
		this.numOfRows = numOfRows;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getContenttypeid() {
		return contenttypeid;
	}
	public void setContenttypeid(String contenttypeid) {
		this.contenttypeid = contenttypeid;
	}
	public String getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}
	public String getReadcount() {
		return readcount;
	}
	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}
	public String getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstimage() {
		return firstimage;
	}
	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}
	public String getFirstimage2() {
		return firstimage2;
	}
	public void setFirstimage2(String firstimage2) {
		this.firstimage2 = firstimage2;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	@Override
	public String toString() {
		return "RoomDTO [numOfRows=" + numOfRows + ", pageNo=" + pageNo + ", totalCount=" + totalCount + ", contentid="
				+ contentid + ", contenttypeid=" + contenttypeid + ", createdtime=" + createdtime + ", readcount="
				+ readcount + ", modifiedtime=" + modifiedtime + ", tel=" + tel + ", title=" + title + ", firstimage="
				+ firstimage + ", firstimage2=" + firstimage2 + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", getNumOfRows()=" + getNumOfRows() + ", getPageNo()=" + getPageNo() + ", getTotalCount()="
				+ getTotalCount() + ", getContentid()=" + getContentid() + ", getContenttypeid()=" + getContenttypeid()
				+ ", getCreatedtime()=" + getCreatedtime() + ", getReadcount()=" + getReadcount()
				+ ", getModifiedtime()=" + getModifiedtime() + ", getTel()=" + getTel() + ", getTitle()=" + getTitle()
				+ ", getFirstimage()=" + getFirstimage() + ", getFirstimage2()=" + getFirstimage2() + ", getAddr1()="
				+ getAddr1() + ", getAddr2()=" + getAddr2() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
