package com.tour.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import com.tour.common.Pagination;
import com.tour.dto.RoomDTO;
import com.tour.dto.TourDetailDTO;

@Controller
@RequestMapping(value = "/tour")
public class TourController {
	private static final Logger log = LoggerFactory.getLogger(NoticeBoardController.class);
	
	private String getTagValue(String tag, Element eElement) {
		NodeList nlList = null;
		Node nValue = null;
		try {
	    	nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		    nValue = (Node) nlList.item(0);
		} catch (Exception e) {
			return " ";
		}
	    return nValue.getNodeValue();
	}

	
	@RequestMapping(value = "/tourList")
	public ModelAndView getTourList(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "") String contentTypeId,
									@RequestParam(defaultValue = "") String areaCode, @RequestParam(defaultValue = "") String sigunguCode,
									@RequestParam(defaultValue = " ") String keyword) throws Exception {
		String sigunName = "";
		
		System.out.println("인코딩 전 keyword : " + keyword);
		System.out.println("pageNo : "+pageNo);
		ArrayList<RoomDTO> list = new ArrayList<RoomDTO>();
		String keywordEnc = URLEncoder.encode(keyword,"UTF-8");
		System.out.println("contentTypeId : "+contentTypeId);
		System.out.println("areacode : "+areaCode);
		System.out.println("sigungucode : "+sigunguCode);
		System.out.println("keyword : "+keyword);
		
		int total = 0;
		try {
		// 1. 파싱할 url 준비하기
		String urlHead = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?serviceKey=";
		String key = "wEmbHGbmbhHTj7kc3qSnIHgHRP2F1D4blM4wZEzU2L7XYH6QNyOgdJrL%2BFFS3XaKFoyRs2BoGL35PbfzA5bZfA%3D%3D";
		String conditions = "&numOfRows=10"
				+ "&pageNo=" + pageNo 
				+ "&MobileOS=ETC&MobileApp=AppTest&arrange=A&listYN=Y"
				+ "&areaCode="+areaCode
				+ "&sigunguCode="+sigunguCode
				+ "&contentTypeId="+contentTypeId
				+ "&keyword="+keywordEnc;
		String url = urlHead + key + conditions;
		System.out.println(url);
		// 2. 페이지에 접근해줄 Document객체 생성
		// tourAPI의 xml파일을 보면 최상위 태그 이름 : <reponse>
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(url);
		
		// normalize : 속성 노드를 포함하여 노드 아래 하위 트리의 모든 텍스트 노드를 "일반" 형식으로 배치
		doc.getDocumentElement().normalize();
		
		// 파싱할 태그
		NodeList nList = doc.getElementsByTagName("item");
		
		// 전체페이지 태그 불러오기
		NodeList totalCount = doc.getElementsByTagName("totalCount");
		
		log.info("파싱할 리스트 수 : "+nList.getLength());
		
		// xml문서의 특정태그 값을 불러오는 방법
		Node countNode = totalCount.item(0);
		if(countNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) countNode;
			total = Integer.parseInt(eElement.getFirstChild().getNodeValue());
			System.out.println("총 게시물 수 : "+ total);
		}
		
		
		for(int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				RoomDTO dto = new RoomDTO();
				dto.setTitle(getTagValue("title",eElement));
				dto.setFirstimage(getTagValue("firstimage",eElement));
				dto.setCreatedtime(getTagValue("createdtime",eElement));
				dto.setModifiedtime(getTagValue("modifiedtime",eElement));
				dto.setContentid(getTagValue("contentid",eElement));
				dto.setContenttypeid(getTagValue("contenttypeid",eElement));
				dto.setAddr1(getTagValue("addr1",eElement));
				dto.setTel(getTagValue("tel",eElement));
				list.add(dto);
				
				System.out.println(i);
				System.out.println(dto.getTitle());
				System.out.println(dto.getFirstimage());
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list",list);
		map.put("sigunguCode",sigunguCode);
		Pagination pagination = new Pagination(total, pageNo);
		map.put("pagination", pagination);
		map.put("count",total);
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.addObject("contentTypeId", contentTypeId);
		mav.addObject("areaCode", areaCode);
		mav.addObject("sigunguCode", sigunguCode);
		mav.addObject("keyword", keyword);
		mav.setViewName("tour/tourList");
		return mav;
	}
	
	
	
	@GetMapping(value="tourdetail")
	public ModelAndView getRoomInfo(@RequestParam("contentid") String contentid, @RequestParam("contenttypeid") String contenttypeid) throws Exception {
		TourDetailDTO dto = new TourDetailDTO();
		try {
		
		String urlHead = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?serviceKey=";
		String key = "wEmbHGbmbhHTj7kc3qSnIHgHRP2F1D4blM4wZEzU2L7XYH6QNyOgdJrL%2BFFS3XaKFoyRs2BoGL35PbfzA5bZfA%3D%3D";
		String conditions = "&MobileOS=ETC&MobileApp=AppTest&defaultYN=Y&firstImageYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y"+
							"&contentId="+contentid+
							"&contentTypeId="+contenttypeid;
		String url = urlHead + key + conditions;
		
		System.out.println(url);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(url);
		
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("item");
		
		for(int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				dto.setTitle(getTagValue("title",eElement));
				dto.setFirstimage(getTagValue("firstimage",eElement));
				dto.setCreatedtime(getTagValue("createdtime",eElement));
				dto.setModifiedtime(getTagValue("modifiedtime",eElement));
				dto.setContentid(getTagValue("contentid",eElement));
				dto.setContenttypeid(getTagValue("contenttypeid",eElement));
				dto.setMapx(getTagValue("mapx",eElement));
				dto.setMapy(getTagValue("mapy",eElement));
				dto.setMlevel(getTagValue("mlevel",eElement));
				dto.setAddr1(getTagValue("addr1",eElement));
				dto.setTel(getTagValue("tel",eElement));
				dto.setHomepage(getTagValue("homepage", eElement));
				dto.setOverview(getTagValue("overview", eElement));
			}
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dto.getHomepage());
		System.out.println(dto.getTitle());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("map",map);
		mav.setViewName("tour/tourDetail");
		
		return mav;
	}
}
