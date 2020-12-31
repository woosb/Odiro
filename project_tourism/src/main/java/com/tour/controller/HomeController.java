package com.tour.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tour.common.Pagination;
import com.tour.dto.Criteria;
import com.tour.dto.NoticeBoardDTO;
import com.tour.service.BoardService;
import com.tour.service.NoticeBoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	NoticeBoardService service;
	@Autowired
	BoardService service2;
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model){
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		List<NoticeBoardDTO> list = service.getNotice();
						//데이터를 맵에 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list); // list
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("map",map);
		mav.setViewName("home");
		service2.getList2(model);
		return mav;
	}
	
}
