package com.tour.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tour.controller.BoardController;
import com.tour.dao.BoardDAO;
import com.tour.dto.BoardDTO;
import com.tour.dto.Criteria;
import com.tour.dto.PageDTO;
import com.tour.dto.ContentInfoDTO;

@Service
public class BoardServiceImpl implements BoardService{
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardDAO dao;
	
	@Override
	public int register(BoardDTO dto) {
		Integer ref = dao.getMaxRef();
		ref =  (ref == null) ? 1 : ref+1;
		dto.setRef(ref);
		
		int result = dao.register(dto);
		return result;
	}

	@Override
	public void getList(Model model, Criteria cri, ContentInfoDTO wish) {
		cri.setContentId(wish.getContentId());
		cri.setContentTypeId(wish.getContentTypeId());
		log.info(cri.toString());
		log.info(wish.toString());
		int total = dao.getTotal();
		PageDTO pageMaker = new PageDTO(cri, total);
		List<BoardDTO> list = dao.getList(cri);
		model.addAttribute("pageMaker",pageMaker);
		model.addAttribute("list", list);
	}
	
	@Override
	public void getMyList(Model model, Criteria cri, ContentInfoDTO wish) {
		cri.setContentId(wish.getContentId());
		cri.setContentTypeId(wish.getContentTypeId());
		cri.setE_mail(wish.getE_mail());
		log.info(cri.toString());
		log.info(wish.toString());
		int total = dao.getTotal();
		PageDTO pageMaker = new PageDTO(cri, total);
		List<BoardDTO> list = dao.getMyList(cri);
		model.addAttribute("pageMaker",pageMaker);
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
	
	public int upRecommend(int id) {
		return dao.upRecommend(id);
	}

	@Override
	public void hitCookie(HttpServletRequest request, HttpServletResponse response, int id) {
		Cookie[] cookies = request.getCookies();
		Cookie hitCookie = null;
		
		if(cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				String cName = cookie.getName();
				String cValue = cookie.getValue();
				log.info(cookie.getName() + " : " + cookie.getValue());
				if(cName.equals("upHit") && cValue.equals("userId"+id)) {
					hitCookie = cookie;
					log.info("이미 존재하는 쿠키");
				}
			}
		}
		
		if(hitCookie == null) {
			dao.upHit(id);
			hitCookie = new Cookie("upHit", "userId"+id);
			response.addCookie(hitCookie);
		}
	}

	@Override
	public void recommendCookie(HttpServletRequest request, HttpServletResponse response, int id) {
		Cookie[] cookies = request.getCookies();
		Cookie recoCookie = null;
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				String cName = cookie.getName();
				String cValue = cookie.getValue();
				if(cName.equals("recommend") && cValue.equals("userId"+id)) {
					recoCookie = cookie;
					log.info("이미 존재하는 쿠키");
				}
			}
		}
		
		if(recoCookie == null) {
			recoCookie = new Cookie("recommend", "userId"+id);
			response.addCookie(recoCookie);
			dao.upRecommend(id);
		}
	}
}
