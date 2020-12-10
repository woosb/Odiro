package com.tour.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tour.controller.BoardController;
import com.tour.dao.BoardDAO;
import com.tour.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardDAO dao;
	
	@Override
	public int register(BoardDTO dto) {
		dto.setUserId("asd");
		
		Integer ref = dao.getMaxRef();
		ref =  (ref == null) ? 1 : ref+1;
		dto.setRef(ref);
		
		int result = dao.register(dto);
		return result;
	}

	@Override
	public void getList(Model model) {
		List<BoardDTO> list = dao.getList();
		model.addAttribute("list", list);
	}

	@Override
	public void getDetail(Model model, int id) {
		BoardDTO dto = dao.getDetail(id);
		int ref = dto.getRef();
		List<BoardDTO> reply = dao.getReply(ref);
		model.addAttribute("reply", reply);
		model.addAttribute("detail", dto);
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}

	@Override
	public int modify(BoardDTO dto) {
		return dao.modify(dto);
	}

	@Override
	public int reply(BoardDTO dto) {
		int parentNum = dto.getId();
		int step = dto.getStep();
		int refOrder = dto.getRefOrder();
		String userId = "asd";
		dto.setUserId(userId);
		
		dao.addRefOrder(dto);

		dto.setParentNum(parentNum);
		dto.setStep(step+1);
		dto.setRefOrder(refOrder+1);
		
		dao.addReplyNum(parentNum);
		return dao.reply(dto);
	}

	@Override
	public int upHit(int id) {
		return dao.upHit(id);
	}

	@Override
	public int upRecommend(int id) {
		return dao.upRecommend(id);
	}
}
