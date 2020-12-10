package com.tour.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.tour.dto.BoardDTO;
import com.tour.dto.Criteria;

public interface BoardService {
	public int register(BoardDTO dto);
	public void getList(Model model, Criteria cri);
	public void getDetail(Model model, int id);
	public int delete(int id);
	public int modify(BoardDTO dto);
	public int reply(BoardDTO dto);
	public void hitCookie(HttpServletRequest request, HttpServletResponse response, int id);
	public void recommendCookie(HttpServletRequest request, HttpServletResponse response, int id);
	
}
