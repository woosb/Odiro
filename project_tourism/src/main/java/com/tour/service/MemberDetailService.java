package com.tour.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.tour.dto.ContentInfoDTO;
import com.tour.dto.MySchedulerDTO;

public interface MemberDetailService {
	public List<ContentInfoDTO> getWishList(String e_mail);
	public int delete(ContentInfoDTO dto);
	public int addWishList(ContentInfoDTO dto);
	public int addSchedul(MySchedulerDTO dto);
	public int getMySchedul(Model model, HttpSession session);
	public int removeSchedul(int id);
}
