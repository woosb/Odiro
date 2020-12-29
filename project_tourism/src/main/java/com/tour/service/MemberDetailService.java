package com.tour.service;

import java.util.List;

import com.tour.dto.ContentInfoDTO;

public interface MemberDetailService {
	public List<ContentInfoDTO> getWishList(String e_mail);
	public int delete(ContentInfoDTO dto);
	public int addWishList(ContentInfoDTO dto);
}
