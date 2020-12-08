package com.tour.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tour.dao.NoticeBoardDAO;
import com.tour.dto.NoticeBoardDTO;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{
	@Autowired
	NoticeBoardDAO dao;
	@Override
	public void selectNoticeList(Model model) {
		model.addAttribute("noticeList", dao.selectNoticeList());
	}
	public void regBoard(HttpServletRequest req) {
		dao.regBoard(req);
	}
	public NoticeBoardDTO contentView(String no) {
		return dao.contentView(no);
	}
}
