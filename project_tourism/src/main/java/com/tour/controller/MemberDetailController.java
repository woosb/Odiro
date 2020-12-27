package com.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/memberDetail")
public class MemberDetailController {
	@GetMapping(value="/detail")
	public void getDetail() {
		
	}
	
	@GetMapping(value="/myWishList")
	public void getList() {
		
	}
	
	@GetMapping(value="/recentList")
	public void getRecentList() {
		
	}
}
