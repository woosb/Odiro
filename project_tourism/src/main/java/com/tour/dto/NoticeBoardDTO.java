package com.tour.dto;

import java.sql.Date;
/*
 	--! 테이블 생성
	create table notice_board (
    	notice_no number(5) PRIMARY KEY,
	    notice_title varchar2(100),
	    notice_content CLOB,
	    notice_hit number(5) default 0,
	    notice_reg_date date DEFAULT SYSDATE,
	    notice_upt_date date
	);
	create sequence notice_board_seq;
 */


public class NoticeBoardDTO {
	private String notice_no;
	private String notice_title;
	private String notice_content;
	private int notice_hit;
	private Date notice_reg_date;
	private Date notice_upt_date;
	
	public Date getNotice_reg_date() {
		return notice_reg_date;
	}
	public void setNotice_reg_date(Date notice_reg_date) {
		this.notice_reg_date = notice_reg_date;
	}
	public Date getNotice_upt_date() {
		return notice_upt_date;
	}
	public void setNotice_upt_date(Date notice_upt_date) {
		this.notice_upt_date = notice_upt_date;
	}
	public String getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public int getNotice_hit() {
		return notice_hit;
	}
	public void setNotice_hit(int notice_hit) {
		this.notice_hit = notice_hit;
	}

	@Override
	public String toString() {
		return "NoticeBoardDTO [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_hit=" + notice_hit + ", notice_reg_date=" + notice_reg_date + "]";
	}
}
