package com.tour.service;

import java.util.List;

import com.tour.dto.WishListDTO;

public interface MemberDetailService {
	public List<WishListDTO> getWishList(String e_mail);
	public int delete(WishListDTO dto);
	public int addWishList(WishListDTO dto);
}
