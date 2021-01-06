package com.tour.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tour.dto.ContentInfoDTO;
import com.tour.dto.Criteria;
import com.tour.dto.MemberDTO;
import com.tour.service.BoardService;

@Controller
@RequestMapping(value="/memberDetail")
public class MemberDetailController {
	
	@Autowired
	BoardService service;
	
	@GetMapping(value="/detail")
	public void getDetail() {
		
	}
	
	@GetMapping(value="/myWishList")
	public void getList() {
		
	}
	
	@GetMapping(value="/recentList")
	public void getRecentList() {
		
	}
	
	@GetMapping(value="/myReview")
	public void getMyReview(Model model, Criteria cri, HttpSession session) {
		String nick = (String)session.getAttribute("nick");
		ContentInfoDTO dto = new ContentInfoDTO();
		dto.setE_mail(nick);
		service.getMyList(model, cri, dto);
	}
	
	@GetMapping(value="/myInfo")
	public void myInfo() {
		
	}
	@RequestMapping(value="/update", method=RequestMethod.POST )
	public void update(String user_nick,HttpSession session) {
		String e_mail = (String)session.getAttribute("e_mail");
		MemberDTO dto = new MemberDTO();
		dto.setE_mail(e_mail);
		dto.setNickName(user_nick);
		service.update(dto);
		session.setAttribute("nick", user_nick);
	}
	
	@GetMapping(value="/myScheduler")
	public void myScheduler() {
		
	}
}
