package com.tour.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.dto.BoardDTO;
import com.tour.dto.Criteria;
import com.tour.dto.ContentInfoDTO;
import com.tour.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService service;
	
	@GetMapping(value="/list")
	public void list(Model model, Criteria cri) {
		ContentInfoDTO wish = new ContentInfoDTO();
		service.getList(model, cri, wish);
	}
	
	@GetMapping(value="/register")
	public void register(Model model, String contentId, String contentTypeId) {
		
		log.info(contentId);
		log.info(contentTypeId);
		model.addAttribute("contentId", contentId);
		model.addAttribute("contentTypeId", contentTypeId);
	}
	
	@PostMapping(value="/register")
	@ResponseBody
	public int register(BoardDTO dto, HttpSession session) {
		String userId = (String)session.getAttribute("e_mail");
		if(userId == null) {
			dto.setUserId("Anonymous");
		}else {
			dto.setUserId(userId);
		}
		int result = service.register(dto);
		log.info(dto.toString());
		return result;
	}
	

	@GetMapping(value="/detail")
	public String detail(@RequestParam("id") int id, Model model, HttpServletResponse response,HttpServletRequest request) {
		service.hitCookie(request, response, id);
		service.getDetail(model, id);
		return "/board/detail";
	}
	
	@GetMapping(value="recommend")
	public String upRecommend(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) {
		service.recommendCookie(request, response, id);
		return "redirect:/board/detail?id="+id;
	}
	
	@GetMapping(value="/delete")
	public String delete(@Param("ref") int ref) {
		int result = service.delete(ref);
		return "redirect:/board/list";
	}
	
	@GetMapping(value="/modify")
	public void modify(Model model, @Param("id") int id){
		service.getDetail(model, id);
	}
	
	@PostMapping(value="/modify")
	@ResponseBody
	public int modify(BoardDTO dto) {
		log.info("dto : "+dto.toString());
		int result = service.modify(dto);
		return result;
	}
	
	@PostMapping(value="/reply")
	public String reply(BoardDTO dto) {
		service.reply(dto);
		return "redirect:/board/detail?id="+dto.getId();
	}
}
