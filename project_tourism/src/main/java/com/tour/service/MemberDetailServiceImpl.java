package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.dao.MemberDetailDAO;
import com.tour.dto.ContentInfoDTO;

@Service
public class MemberDetailServiceImpl implements MemberDetailService{
	@Autowired
	MemberDetailDAO dao;
	
	@Override
	public List<ContentInfoDTO> getWishList(String e_mail) {
		List<ContentInfoDTO> list = dao.getWishList(e_mail);
		return list;
	}

	@Override
	public int delete(ContentInfoDTO dto) {
		return dao.deleteWishList(dto);
	}

	@Override
	public int addWishList(ContentInfoDTO dto) {
		return dao.addWishList(dto);
	}
}
