package com.tour.dto;

public class MySchedulerDTO {
	private int schedulId;
	private String e_mail;
	private String startTime;
	private String endTime;
	private String contents;
	
	public int getSchedulId() {
		return schedulId;
	}
	public void setSchedulId(int schedulId) {
		this.schedulId = schedulId;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "MySchedulerDTO [schedulId=" + schedulId + ", e_mail=" + e_mail + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", contents=" + contents + "]";
	}
}
