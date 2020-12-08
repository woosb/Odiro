package com.tour.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tour.dto.NoticeBoardDTO;

public interface NoticeBoardService {
	public void selectNoticeList(Model model);
	public void regBoard(HttpServletRequest req);
	public NoticeBoardDTO contentView(String no);
}
