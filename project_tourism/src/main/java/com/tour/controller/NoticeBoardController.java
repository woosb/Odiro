package com.tour.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tour.dto.NoticeBoardDTO;
import com.tour.service.NoticeBoardService;

@Controller
@RequestMapping("notice")
public class NoticeBoardController {
	private static final Logger log = LoggerFactory.getLogger(NoticeBoardController.class);
	@Autowired
	NoticeBoardService nbs;
	@RequestMapping("noticeList")
	public String noticeList(Model model) {
		nbs.selectNoticeList(model);
		return "notice/noticeList";
	}
	@RequestMapping("regForm")
	public String regFrom() {
		return "notice/regForm";
	}
	@PostMapping("regBoard")
	public String regBoard(HttpServletRequest req) {
		nbs.regBoard(req);
		return "redirect:noticeList";
	}
	@RequestMapping("getDetail")
	public String getDetail(HttpServletResponse response,HttpServletRequest request,@RequestParam("no")String no,Model model) {
		
		Cookie[] cookies = request.getCookies();
		
		Cookie viewCookie = null;
		
		if (cookies != null && cookies.length > 0) {
			for (int i = 0 ; i < cookies.length;i++) {
				//Cookie의 name이 cookie + no와 일치하는 쿠키를 viewCookie에 넣어준다.
				if (cookies[i].getName().equals("cookie"+no)) {
					//처음 쿠키가 생성되고 들어온다.
					viewCookie = cookies[i];
				}
			}
		}
		
		//ViewCookie가 만약 null일 경우 쿠키를 생성해서 조회수 증가 로직 처리
		if (viewCookie == null) {
			Cookie newCookie = new Cookie("cookie"+no,no);
			//기본값으로 브라우저가 꺼졌을 때 쿠키 삭제
			response.addCookie(newCookie);
			nbs.upHit(no);
		} 
		
		model.addAttribute("contentView", nbs.getDetail(no));
		return "notice/contentView";
	}
	
	@RequestMapping("modifyForm")
	public String getModifyForm(@RequestParam("no") String no, Model model) {
		model.addAttribute("contentView", nbs.getDetail(no));
		return "notice/modifyForm";
	}
	@RequestMapping("modifyOk")
	public String modifyOk(NoticeBoardDTO dto) {
		nbs.modifyOk(dto);
		return "redirect:noticeList";
	}
	@RequestMapping("delete")
	public String deleteBoard(@RequestParam("no") String no) {
		nbs.deleteBoard(no);
		return "redirect:noticeList";
	}
}
