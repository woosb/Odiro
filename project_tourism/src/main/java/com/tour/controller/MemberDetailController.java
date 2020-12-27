package com.tour.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tour.dto.WishListDTO;

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
