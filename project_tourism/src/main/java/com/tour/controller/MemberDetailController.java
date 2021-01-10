package com.tour.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tour.dto.ContentInfoDTO;
import com.tour.dto.Criteria;
import com.tour.dto.MemberDTO;
import com.tour.service.BoardService;
import com.tour.service.MemberDetailService;

@Controller
@RequestMapping(value="/memberDetail")
public class MemberDetailController {
	
	@Autowired
	BoardService service;
	
	@GetMapping(value="/detail")
	public void getDetail() {
		
	}
	
	@GetMapping(value="/myWishList")
	public void getList() {
		
	}
	
	@GetMapping(value="/recentList")
	public void getRecentList() {
		
	}
	
	@GetMapping(value="/myReview")
	public void getMyReview(Model model, Criteria cri, HttpSession session) {
		String nick = (String)session.getAttribute("nick");
		ContentInfoDTO dto = new ContentInfoDTO();
		dto.setE_mail(nick);
		service.getMyList(model, cri, dto);
	}
	
	@GetMapping(value="/myInfo")
	public void myInfo() {
		
	}
	@RequestMapping(value="/update", method=RequestMethod.POST )
	public ModelAndView update(String user_nick,HttpSession session) {
		String e_mail = (String)session.getAttribute("e_mail");
		String nick = (String)session.getAttribute("nick");
		MemberDTO dto = new MemberDTO();
		dto.setE_mail(e_mail);
		dto.setNickName(user_nick);
		dto.setNickName2(nick);
		service.update(dto);
		session.setAttribute("nick", user_nick);
		ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
        mv.setViewName("/memberDetail/detail");     //뷰의이름
		return mv;
	}
	@RequestMapping(value="/pw_update", method=RequestMethod.POST )
	public ModelAndView pw_update(String user_pass,HttpSession session) throws Exception {
		String e_mail = (String)session.getAttribute("e_mail");
		MemberDTO dto = new MemberDTO();
		dto.setE_mail(e_mail);
		dto.setUser_pass(user_pass);
		service.pw_update(dto);
		session.invalidate();
		ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
        mv.setViewName("/member/login_form");     //뷰의이름
		return mv;
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET )
	public ModelAndView delete(HttpSession session)
	{
		String e_mail = (String)session.getAttribute("e_mail");
		service.delete(e_mail);
		session.invalidate();
		ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
        mv.setViewName("/member/login_form");     //뷰의이름
		return mv;
	}
	@RequestMapping(value="/pw_check", method=RequestMethod.POST )
	public ModelAndView pw_check(HttpSession session,String user_pass,HttpServletResponse response) throws IOException
	{
		String e_mail = (String)session.getAttribute("e_mail");
		MemberDTO dto = new MemberDTO();
		dto.setE_mail(e_mail);
		dto.setUser_pass(user_pass);
		boolean flag=service.pw_check(dto);
		 response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
		if(flag)
		{
			mv.setViewName("/memberDetail/myInfo");     //뷰의이름
		}else
		{
			out.println("<script>alert('로그인에 실패하였습니다 로그인창으로 돌아갑니다');</script>");
			out.println("<script>history.back();</script>");
			out.flush();
		}
		return mv;
	}
	@RequestMapping(value="/pw_check", method=RequestMethod.GET )
	public String pwCheck()
	{
		return "/memberDetail/pw_check";
	}
	@GetMapping(value="/myScheduler")
	public void myScheduler() {
	}
}
