package com.tour.dto;

public class WishListDTO {
	private int seq;
	private String e_mail;
	private int contentId;
	private int contentTypeId;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	@Override
	public String toString() {
		return "WishListDTO [seq=" + seq + ", e_mail=" + e_mail + ", contentId=" + contentId + ", contentTypeId="
				+ contentTypeId + "]";
	}
}
