package com.tour.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tour.dto.WishListDTO;
import com.tour.service.MemberDetailService;

@RestController
@RequestMapping(value="/memberDetail")
public class MemberDetailRestController {
	
	@Autowired
	MemberDetailService service;
	
	@GetMapping(value="/getWishList/{e_mail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<WishListDTO> > getDetail(@PathVariable("e_mail") String e_mail) {		
		List<WishListDTO> wishList = service.getWishList(e_mail);
		ResponseEntity< List<WishListDTO> > result = null;
		if(wishList!= null) {
			result = ResponseEntity.status(HttpStatus.OK).body(wishList);
		}else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
		}
		return result;
	}
	
	@DeleteMapping(value="/delete/{contentId}/{contentTypeId}")
	public int delete(HttpSession session, @PathVariable("contentId") int contentId, @PathVariable("contentTypeId") int contentTypeId) {		
		String user = (String)session.getAttribute("e_mail");
		WishListDTO dto = new WishListDTO();
		dto.setContentId(contentId);
		dto.setContentTypeId(contentTypeId);
		dto.setE_mail(user);
		return service.delete(dto);
	}
}
