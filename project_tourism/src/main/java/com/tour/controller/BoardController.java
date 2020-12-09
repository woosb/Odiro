package com.tour.controller;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.dto.BoardDTO;
import com.tour.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService service;
	
	@GetMapping(value="/list")
	public void list(Model model) {
		service.getList(model);
	}
	
	@GetMapping(value="/register")
	public void register() {}
	
	@PostMapping(value="/register")
	@ResponseBody
	public int register(BoardDTO dto) {
		int result = service.register(dto);
		log.info(dto.toString());
		return result;
	}
	
	@GetMapping(value="/detail", params= {"id"})
	public void detail(Model model, int id) {
		service.getDetail(model, id);
	}
	
	@GetMapping(value="/delete")
	public String delete(@Param("id") int id) {
		int result = service.delete(id);
		return "redirect:/board/list";
	}
	
	@GetMapping(value="/modify")
	public void modify(Model model, @Param("id") int id){
		service.getDetail(model, id);
	}
	
	@PostMapping(value="/modify")
	public String modify(BoardDTO dto) {
		log.info("dto : "+dto.toString());
		service.modify(dto);
		return "redirect:/board/list";
	}
	
	@PostMapping(value="/reply")
	public String reply(BoardDTO dto) {
		service.reply(dto);
		return "redirect:/board/detail?id="+dto.getId();
	}
}
