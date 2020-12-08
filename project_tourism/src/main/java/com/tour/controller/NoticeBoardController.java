package com.tour.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tour.service.NoticeBoardService;

@Controller
public class NoticeBoardController {
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
	@RequestMapping("contentView")
	public String contentView(@RequestParam("notice_no")String no,Model model) {
		model.addAttribute("contentView", nbs.contentView(no));
		return "notice/contentView";
	}
}
