package com.tour.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tour.dto.NoticeBoardDTO;

public interface NoticeBoardService {
	public List<NoticeBoardDTO> getList(int start, int end, String searchOption, String keyword) throws Exception;
	public int countBoardList(String searchOption, String keyword);
	public void regBoard(HttpServletRequest req);
	public NoticeBoardDTO getDetail(String no);
	public void upHit(String no);
	public void modifyOk(NoticeBoardDTO dto);
	public void deleteBoard(String no);
}
