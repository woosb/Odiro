package com.tour.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tour.dto.ContentInfoDTO;
import com.tour.service.MemberDetailService;

@RestController
@RequestMapping(value="/memberDetail")
public class MemberDetailRestController {
	
	@Autowired
	MemberDetailService service;
	
	@GetMapping(value="/getWishList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<ContentInfoDTO> > getDetail(HttpSession session) {
		String nick = (String)session.getAttribute("nick");
		List<ContentInfoDTO> wishList = service.getWishList(nick);
		ResponseEntity< List<ContentInfoDTO> > result = null;
		if(wishList!= null) {
			result = ResponseEntity.status(HttpStatus.OK).body(wishList);
		}else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
		}
		return result;
	}
	
	@DeleteMapping(value="/delete/{contentId}/{contentTypeId}")
	public int delete(HttpSession session, @PathVariable("contentId") int contentId, @PathVariable("contentTypeId") int contentTypeId) {		
		String user = (String)session.getAttribute("nick");
		ContentInfoDTO dto = new ContentInfoDTO();
		dto.setContentId(contentId);
		dto.setContentTypeId(contentTypeId);
		dto.setE_mail(user);
		return service.delete(dto);
	}
	
	@PostMapping(value="/addWishList")
	public int addWishList(@RequestBody ContentInfoDTO dto, HttpSession session) {
		String nick = (String)session.getAttribute("nick");
		dto.setE_mail(nick);		
		return service.addWishList(dto);
	}
}
