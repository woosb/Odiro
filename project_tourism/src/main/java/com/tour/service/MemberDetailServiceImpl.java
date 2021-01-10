package com.tour.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tour.dao.MemberDetailDAO;
import com.tour.dto.ContentInfoDTO;
import com.tour.dto.MemberDTO;
import com.tour.dto.MySchedulerDTO;

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

	@Override
	public int addSchedul(MySchedulerDTO dto) {
		return dao.addSchedul(dto);
	}

	@Override
	public List<MySchedulerDTO> getMySchedul(HttpSession session) {
		List<MySchedulerDTO> list = dao.getMySchedul((String)session.getAttribute("e_mail"));
		return list;
	}

	@Override
	public int removeSchedul(int id) {
		dao.removeMySchedul(id);
		return 0;
	}
	
}
