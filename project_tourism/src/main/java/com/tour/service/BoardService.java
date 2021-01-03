package com.tour.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.tour.dto.BoardDTO;
import com.tour.dto.Criteria;
import com.tour.dto.ContentInfoDTO;

public interface BoardService {
	public int register(BoardDTO dto);
	public void getList(Model model, Criteria cri, ContentInfoDTO wish);
	public void getDetail(Model model, int id);
	public int delete(int id);
	public int modify(BoardDTO dto);
	public int reply(BoardDTO dto);
	public void hitCookie(HttpServletRequest request, HttpServletResponse response, int id);
	public void recommendCookie(HttpServletRequest request, HttpServletResponse response, int id);
<<<<<<< HEAD
	public void getList2(Model model);
	
=======
	public void getMyList(Model model, Criteria cri, ContentInfoDTO wish);
>>>>>>> d1e8d422394b98aba2a67208a5960d8f50b9623a
}
