package com.tour.dto;

import java.util.Date;
/*
	 create table free_board(
	    id number not null primary key,
	    userId varchar(20),
	    title varchar(20),
	    content varchar(2000),
	    regDate Date,
	    updateDate Date,
	    
	    hit number default 0,
	    recommend number default 0,
	    
	    ref number default 0,
	    refOrder number default 0,
	    step number default 0,
	    answerNum number default 0,
	    parentNum number default 0
	);
	create sequence free_board_seq;
*/
public class BoardDTO {
	private int id;
	private String userId;
	private String title;
	private String content;
	private Date regDate;
	private Date updateDate;
	
	private int hit;
	private int recommend;
	
	private int contentId;
	private int contentTypeId;
	
	private int ref;
	private int refOrder;
	private int step;
	private int answerNum;
	private int parentNum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRefOrder() {
		return refOrder;
	}
	public void setRefOrder(int refOrder) {
		this.refOrder = refOrder;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getAnswerNum() {
		return answerNum;
	}
	public void setAnswerNum(int answerNum) {
		this.answerNum = answerNum;
	}
	public int getParentNum() {
		return parentNum;
	}
	public void setParentNum(int parentNum) {
		this.parentNum = parentNum;
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
		return "BoardDTO [id=" + id + ", userId=" + userId + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + ", updateDate=" + updateDate + ", hit=" + hit + ", recommend=" + recommend + ", contentId="
				+ contentId + ", contentTypeId=" + contentTypeId + ", ref=" + ref + ", refOrder=" + refOrder + ", step="
				+ step + ", answerNum=" + answerNum + ", parentNum=" + parentNum + "]";
	}
	
}
