package com.tour.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.tour.dto.TourContentInfoDTO;

@Service
public class TourContentInfoServiceImpl implements TourContentInfoService{
	public String getTagValue(String tag, Element eElement) {
		NodeList nlList = null;
		Node nValue = null;
		try {
	    	nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		    nValue = (Node) nlList.item(0);
		} catch (Exception e) {
			return " ";
		}
		if (nValue == null) {
			return " ";
		} else {
			return nValue.getNodeValue();
		}	
	}
	
	public TourContentInfoDTO getTourContent(String contentid, String contenttypeid) throws Exception {
		
		TourContentInfoDTO infoDto = new TourContentInfoDTO();
		try {
		String urlHead = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?serviceKey=";
		String key = "wEmbHGbmbhHTj7kc3qSnIHgHRP2F1D4blM4wZEzU2L7XYH6QNyOgdJrL%2BFFS3XaKFoyRs2BoGL35PbfzA5bZfA%3D%3D";
		String conditions = "&MobileOS=ETC&MobileApp=AppTest"+
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
				switch(contenttypeid) {
				case "12" :
				//12(관광지)
				infoDto.setAccomcount(getTagValue("accomcount",eElement));
				infoDto.setChkbabycarriage(getTagValue("chkbabycarriage",eElement));
				infoDto.setChkcreditcard(getTagValue("chkcreditcard",eElement));
				infoDto.setChkpet(getTagValue("chkpet",eElement));
				infoDto.setExpagerange(getTagValue("expagerange",eElement));
				infoDto.setExpguide(getTagValue("expguide",eElement));
				infoDto.setHeritage1(getTagValue("heritage1",eElement));
				infoDto.setHeritage2(getTagValue("heritage2",eElement));
				infoDto.setHeritage3(getTagValue("heritage3",eElement));
				infoDto.setInfocenter(getTagValue("infocenter",eElement));
				infoDto.setOpendate(getTagValue("opendate",eElement));
				infoDto.setParking(getTagValue("parking", eElement));
				infoDto.setRestdate(getTagValue("restdate", eElement));
				infoDto.setUseseason(getTagValue("useseason", eElement));
				infoDto.setUsetime(getTagValue("usetime", eElement));
				break;
				case "14" :
				//14(문화시설)
				infoDto.setAccomcountculture(getTagValue("accomcountculture", eElement));
				infoDto.setChkbabycarriageculture(getTagValue("chkbabycarriageculture", eElement));
				infoDto.setChkcreditcardculture(getTagValue("chkcreditcardculture", eElement));
				infoDto.setChkpetculture(getTagValue("chkpetculture", eElement));
				infoDto.setDiscountinfo(getTagValue("discountinfo", eElement));
				infoDto.setInfocenterculture(getTagValue("infocenterculture", eElement));
				infoDto.setParkingculture(getTagValue("parkingculture", eElement));
				infoDto.setParkingfee(getTagValue("parkingfee", eElement));
				infoDto.setRestdateculture(getTagValue("restdateculture", eElement));
				infoDto.setUsefee(getTagValue("usefee", eElement));
				infoDto.setUsetimeculture(getTagValue("usetimeculture", eElement));
				infoDto.setScale(getTagValue("scale", eElement));
				infoDto.setSpendtime(getTagValue("spendtime", eElement));
				break;
				case "15" :
				//15(행사/공연/축제)
				infoDto.setAgelimit(getTagValue("agelimit", eElement));
				infoDto.setBookingplace(getTagValue("bookingplace", eElement));
				infoDto.setDiscountinfofestival(getTagValue("discountinfofestival", eElement));
				infoDto.setEventenddate(getTagValue("eventenddate", eElement));
				infoDto.setEventhomepage(getTagValue("eventhomepage", eElement));
				infoDto.setEventplace(getTagValue("eventplace", eElement));
				infoDto.setEventstartdate(getTagValue("eventstartdate", eElement));
				infoDto.setFestivalgrade(getTagValue("festivalgrade", eElement));
				infoDto.setPlaceinfo(getTagValue("placeinfo", eElement));
				infoDto.setPlaytime(getTagValue("playtime", eElement));
				infoDto.setProgram(getTagValue("program", eElement));
				infoDto.setSpendtimefestival(getTagValue("spendtimefestival", eElement));
				infoDto.setSponsor1(getTagValue("sponsor1", eElement));
				infoDto.setSponsor1tel(getTagValue("sponsor1tel", eElement));
				infoDto.setSponsor2(getTagValue("sponsor2", eElement));
				infoDto.setSponsor2tel(getTagValue("sponsor2tel", eElement));
				infoDto.setSubevent(getTagValue("subevent", eElement));
				infoDto.setUsetimefestival(getTagValue("usetimefestival", eElement));
				break;
				case "25" :
				//25(여행코스)
				infoDto.setDistance(getTagValue("distance", eElement));
				infoDto.setInfocentertourcourse(getTagValue("infocentertourcourse", eElement));
				infoDto.setSchedule(getTagValue("schedule", eElement));
				infoDto.setTaketime(getTagValue("taketime", eElement));
				infoDto.setTheme(getTagValue("theme", eElement));
				break;
				case "28" :
				//28(레포츠)
				infoDto.setAccomcountleports(getTagValue("accomcountleports", eElement));
				infoDto.setChkbabycarriageleports(getTagValue("chkbabycarriageleports", eElement));
				infoDto.setChkcreditcardleports(getTagValue("chkcreditcardleports", eElement));
				infoDto.setChkpetleports(getTagValue("chkpetleports", eElement));
				infoDto.setExpagerangeleports(getTagValue("expagerangeleports", eElement));
				infoDto.setInfocenterleports(getTagValue("infocenterleports", eElement));
				infoDto.setOpenperiod(getTagValue("openperiod", eElement));
				infoDto.setParkingfeeleports(getTagValue("parkingfeeleports", eElement));
				infoDto.setParkingleports(getTagValue("parkingleports", eElement));
				infoDto.setReservation(getTagValue("reservation", eElement));
				infoDto.setRestdateleports(getTagValue("restdateleports", eElement));
				infoDto.setScaleleports(getTagValue("scaleleports", eElement));
				infoDto.setUsefeeleports(getTagValue("usefeeleports", eElement));
				infoDto.setUsetimeleports(getTagValue("usetimeleports", eElement));
				break;
				case "32" :
				//32(숙박)
				infoDto.setAccomcountlodging(getTagValue("accomcountlodging", eElement));
				infoDto.setBenikia(getTagValue("benikia", eElement));
				infoDto.setCheckintime(getTagValue("checkintime", eElement));
				infoDto.setCheckouttime(getTagValue("checkouttime", eElement));
				infoDto.setChkcooking(getTagValue("chkcooking", eElement));
				infoDto.setFoodplace(getTagValue("foodplace", eElement));
				infoDto.setGoodstay(getTagValue("goodstay", eElement));
				infoDto.setHanok(getTagValue("hanok", eElement));
				infoDto.setInfocenterlodging(getTagValue("infocenterlodging", eElement));
				infoDto.setParkinglodging(getTagValue("parkinglodging", eElement));
				infoDto.setPickup(getTagValue("pickup", eElement));
				infoDto.setRoomcount(getTagValue("roomcount", eElement));
				infoDto.setReservationlodging(getTagValue("reservationlodging", eElement));
				infoDto.setReservationurl(getTagValue("reservationurl", eElement));
				infoDto.setRoomtype(getTagValue("roomtype", eElement));
				infoDto.setScalelodging(getTagValue("scalelodging", eElement));
				infoDto.setSubfacility(getTagValue("subfacility", eElement));
				infoDto.setBarbecue(getTagValue("barbecue", eElement));
				infoDto.setBeauty(getTagValue("beauty", eElement));
				infoDto.setBeverage(getTagValue("beverage", eElement));
				infoDto.setBicycle(getTagValue("bicycle", eElement));
				infoDto.setCampfire(getTagValue("campfire", eElement));
				infoDto.setFitness(getTagValue("fitness", eElement));
				infoDto.setKaraoke(getTagValue("karaoke", eElement));
				infoDto.setPublicbath(getTagValue("publicbath", eElement));
				infoDto.setPublicpc(getTagValue("publicpc", eElement));
				infoDto.setSauna(getTagValue("sauna", eElement));
				infoDto.setSeminar(getTagValue("seminar", eElement));
				infoDto.setSports(getTagValue("sports", eElement));
				infoDto.setRefundregulation(getTagValue("refundregulation", eElement));
				break;
				case "38" :
				//38(쇼핑)
				infoDto.setChkbabycarriageshopping(getTagValue("chkbabycarriageshopping", eElement));
				infoDto.setChkcreditcardshopping(getTagValue("chkcreditcardshopping", eElement));
				infoDto.setChkpetshopping(getTagValue("chkpetshopping", eElement));
				infoDto.setCulturecenter(getTagValue("culturecenter", eElement));
				infoDto.setFairday(getTagValue("fairday", eElement));
				infoDto.setInfocentershopping(getTagValue("infocentershopping", eElement));
				infoDto.setOpendateshopping(getTagValue("opendateshopping", eElement));
				infoDto.setOpentime(getTagValue("opentime", eElement));
				infoDto.setParkingshopping(getTagValue("parkingshopping", eElement));
				infoDto.setRestdateshopping(getTagValue("restdateshopping", eElement));
				infoDto.setRestroom(getTagValue("restroom", eElement));
				infoDto.setSaleitem(getTagValue("saleitem", eElement));
				infoDto.setSaleitemcost(getTagValue("saleitemcost", eElement));
				infoDto.setScaleshopping(getTagValue("scaleshopping", eElement));
				infoDto.setShopguide(getTagValue("shopguide", eElement));
				break;
				case "39" :
				//39(음식점)
				infoDto.setChkcreditcardfood(getTagValue("chkcreditcardfood", eElement));
				infoDto.setDiscountinfofood(getTagValue("discountinfofood", eElement));
				infoDto.setFirstmenu(getTagValue("firstmenu", eElement));
				infoDto.setInfocenterfood(getTagValue("infocenterfood", eElement));
				infoDto.setKidsfacility(getTagValue("kidsfacility", eElement));
				infoDto.setOpendatefood(getTagValue("opendatefood", eElement));
				infoDto.setOpentimefood(getTagValue("opentimefood", eElement));
				infoDto.setPacking(getTagValue("packing", eElement));
				infoDto.setParkingfood(getTagValue("parkingfood", eElement));
				infoDto.setReservationfood(getTagValue("reservationfood", eElement));
				infoDto.setRestdatefood(getTagValue("restdatefood", eElement));
				infoDto.setScalefood(getTagValue("scalefood", eElement));
				infoDto.setSeat(getTagValue("seat", eElement));
				infoDto.setSmoking(getTagValue("smoking", eElement));
				infoDto.setTreatmenu(getTagValue("treatmenu", eElement));
				infoDto.setLcnsno(getTagValue("lcnsno", eElement));
				break;
				default :
				break;
				}
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(infoDto.toString());
		return infoDto;
	}
}
