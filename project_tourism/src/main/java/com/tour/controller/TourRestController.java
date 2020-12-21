package com.tour.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.tour.dto.AreaCodeDTO;
import com.tour.dto.SigunguCodeDTO;
@RestController
@RequestMapping("/search")
public class TourRestController {
	
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
	
	@RequestMapping(value = "areaSearch.do", method = RequestMethod.POST)
	public Map<String,Object> areaSearch(@RequestBody AreaCodeDTO adto) throws Exception {
		System.out.println("지역 코드 확인 : "+adto.getCode());
		String areacode = adto.getCode();
		ArrayList<SigunguCodeDTO> list = new ArrayList<SigunguCodeDTO>();
		try {
			String urlHead = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?serviceKey=";
			String key = "wEmbHGbmbhHTj7kc3qSnIHgHRP2F1D4blM4wZEzU2L7XYH6QNyOgdJrL%2BFFS3XaKFoyRs2BoGL35PbfzA5bZfA%3D%3D";
			String conditions = "&MobileOS=ETC&MobileApp=AppTest"
								+"&areaCode="+areacode
								+"&numOfRows=50";
			String url = urlHead + key + conditions;
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);
			
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("item");
			log.info("파싱할 시군구 리스트 수 : "+nList.getLength());
			
			for(int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					SigunguCodeDTO dto = new SigunguCodeDTO();
					dto.setCode(getTagValue("code",eElement));
					dto.setName(getTagValue("name",eElement));
					System.out.println(i);
					System.out.println(dto.getCode());
					System.out.println(dto.getName());
					list.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list",list);
		return map;
	}
}
