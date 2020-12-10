package com.tour.service;

import org.springframework.ui.Model;

import com.tour.dto.BoardDTO;

public interface BoardService {
	public int register(BoardDTO dto);
	public void getList(Model model);
	public void getDetail(Model model, int id);
	public int delete(int id);
	public int modify(BoardDTO dto);
	public int reply(BoardDTO dto);
	public int upHit(int id);
	public int upRecommend(int id);
}
