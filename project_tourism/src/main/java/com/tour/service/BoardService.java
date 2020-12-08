package com.tour.service;

import org.springframework.ui.Model;

import com.tour.dto.BoardDTO;

public interface BoardService {
	public int register(BoardDTO dto);
	public void getList(Model model);
	public void getDetail(Model model, int id);
}
