package com.tour.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tour.dto.NoticeBoardDTO;

public interface NoticeBoardService {
	public void selectNoticeList(Model model);
	public void regBoard(HttpServletRequest req);
	public NoticeBoardDTO getDetail(String no);
	public void upHit(String no);
	public void modifyOk(NoticeBoardDTO dto);
	public void deleteBoard(String no);
}
