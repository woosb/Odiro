package com.tour.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tour.dao.NoticeBoardDAO;
import com.tour.dto.BoardDTO;
import com.tour.dto.NoticeBoardDTO;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{
	@Autowired
	NoticeBoardDAO dao;
	public List<NoticeBoardDTO> getList(int start, int end, String searchOption, String keyword) throws Exception {
		return dao.getList(start, end, searchOption, keyword);
	}
	public List<NoticeBoardDTO> getList2()
	{
		return dao.getList2();
	}
	public int countBoardList(String searchOption, String keyword) {
		return dao.countBoardList(searchOption, keyword);
	}
	
	public void regBoard(HttpServletRequest req) {
		dao.regBoard(req);
	}
	public NoticeBoardDTO getDetail(String no) {
		return dao.getDetail(no);
	}
	public void upHit(String no) {
		dao.upHit(no);
	}
	public void modifyOk(NoticeBoardDTO dto) {
		dao.modifyOk(dto);
	}
	public void deleteBoard(String no) {
		dao.deleteBoard(no);
	}
	public List<NoticeBoardDTO> getNotice()
	{
		return dao.getNotice();
	}
}
