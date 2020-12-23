package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.dao.MemberDetailDAO;
import com.tour.dto.WishListDTO;

@Service
public class MemberDetailServiceImpl implements MemberDetailService{
	@Autowired
	MemberDetailDAO dao;
	
	@Override
	public List<WishListDTO> getWishList(String e_mail) {
		List<WishListDTO> list = dao.getWishList(e_mail);
		return list;
	}

	@Override
	public int delete(WishListDTO dto) {
		return dao.deleteWishList(dto);
	}
}
