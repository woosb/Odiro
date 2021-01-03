package com.tour.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tour.dto.ContentInfoDTO;
import com.tour.dto.Criteria;
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
		String e_mail = (String)session.getAttribute("e_mail");
		ContentInfoDTO dto = new ContentInfoDTO();
		dto.setE_mail(e_mail);
		service.getMyList(model, cri, dto);
	}
	
	@GetMapping(value="/myInfo")
	public void myInfo() {
		
	}
	
	@GetMapping(value="/myScheduler")
	public void myScheduler() {
		
	}
}
