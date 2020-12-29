package com.tour.dto;

public class TourContentInfoDTO {
	//contentType = 12 (관광지)
	private String accomcount; //수용인원
	private String chkbabycarriage;//유모차 대여 정보
	private String chkcreditcard;//신용카드가능 정보
	private String chkpet;//애완동물동반가능 정보
	private String expagerange;//체험가능 연령
	private String expguide; //체험안내
	private String heritage1; //세계 문화유산 유무
	private String heritage2; //세계 자연유산 유무
	private String heritage3; //세계 기록유산 유무
	private String infocenter; //문의 및 안내
	private String opendate; //개장일
	private String parking; //주차시설
	private String restdate; //쉬는날
	private String useseason; //이용시기
	private String usetime; //이용시간
	//contentType = 14 (문화시설)
	private String accomcountculture; //수용인원
	private String chkbabycarriageculture; //유모차대여 정보
	private String chkcreditcardculture; //신용카드가능 정보
	private String chkpetculture; // 애완동물동반가능 정보
	private String discountinfo; //할인정보
	private String infocenterculture; //문의 및 안내
	private String parkingculture; // 주차시설
	private String parkingfee; // 주차요금
	private String restdateculture; //쉬는날
	private String usefee; // 이용요금
	private String usetimeculture; // 이용시간
	private String scale; // 규모
	private String spendtime; //관람 소요시간
	//contentType = 15 (행사/공연/축제)
	private String agelimit; //관람 가능연령
	private String bookingplace; //예매처
	private String discountinfofestival; //할인정보
	private String eventenddate; // 행사 종료일
	private String eventhomepage; // 행사 홈페이지
	private String eventplace; // 행사 장소
	private String eventstartdate; // 행사 시작일
	private String festivalgrade; // 축제 등급
	private String placeinfo; // 행사장 위치안내
	private String playtime; // 공연시간
	private String program; // 행사 프로그램
	private String spendtimefestival; //관람 소요시간
	private String sponsor1; // 주최자 정보
	private String sponsor1tel; // 주최자 연락처
	private String sponsor2; // 주관사 정보
	private String sponsor2tel; // 주관사 연락처
	private String subevent; // 부대행사
	private String usetimefestival; // 이용요금
	//contentType = 25 (여행코스)
	private String distance; //코스 총 거리
	private String infocentertourcourse; //문의 및 안내
	private String schedule; //코스 일정
	private String taketime; //코스 총 소요시간
	private String theme; //코스 테마
	//contentType = 28 (레포츠)
	private String accomcountleports; // 수용인원
	private String chkbabycarriageleports; // 유모차대여 정보
	private String chkcreditcardleports; // 신용카드가능 정보
	private String chkpetleports; // 애완동물동반가능 정보
	private String expagerangeleports; // 체험 가능연령
	private String infocenterleports; // 문의 및 안내
	private String openperiod; // 개장기간
	private String parkingfeeleports; // 주차요금
	private String parkingleports; // 주차시설
	private String reservation; // 예약안내
	private String restdateleports; // 쉬는날
	private String scaleleports; // 규모
	private String usefeeleports; // 입장료
	private String usetimeleports; // 이용시간
	//contentType = 32 (숙박)
	private String accomcountlodging; // 수용 가능인원
	private String benikia; // 베니키아 여부
	private String checkintime; // 입실 시간
	private String checkouttime; // 퇴실 시간
	private String chkcooking; // 객실내 취사 여부
	private String foodplace; // 식음료장
	private String goodstay; // 굿스테이 여부
	private String hanok; // 한옥 여부
	private String infocenterlodging; // 문의 및 안내
	private String parkinglodging; // 주차시설
	private String pickup; // 픽업 서비스
	private String roomcount; // 객실수
	private String reservationlodging; // 예약안내
	private String reservationurl; // 예약안내 홈페이지
	private String roomtype; // 객실유형
	private String scalelodging; // 규모
	private String subfacility; // 부대시설(기타)
	private String barbecue; // 바비큐장 여부
	private String beauty; // 뷰티시설 정보
	private String beverage; // 식음료장 여부
	private String bicycle; // 자전거 대여 여부
	private String campfire; // 캠프파이어 여부
	private String fitness; // 휘트니스 센터 여부
	private String karaoke; // 노래방 여부
	private String publicbath; // 공용 샤워실 여부
	private String publicpc; // 공용 PC실 여부
	private String sauna; // 사우나실 여부
	private String seminar; //세미나실 여부
	private String sports; // 스포츠 시설 여부
	private String refundregulation; // 환불규정
	//contentType = 38 (쇼핑)
	private String chkbabycarriageshopping; //유모차대여 정보
	private String chkcreditcardshopping; //신용카드 가능 정보
	private String chkpetshopping; //애완동물동반가능 정보
	private String culturecenter; //문화센터 바로가기
	private String fairday; // 장서는 날
	private String infocentershopping; // 문의 및 안내
	private String opendateshopping; // 개장일
	private String opentime; // 영업시간
	private String parkingshopping; // 주차시설
	private String restdateshopping; // 쉬는날
	private String restroom; // 화장실 설명
	private String saleitem; // 판매 품목
	private String saleitemcost; // 판매 품목별 가격
	private String scaleshopping; // 규모
	private String shopguide; // 매장안내
	//contentType = 39 (음식점)
	private String chkcreditcardfood; // 신용카드가능 정보
	private String discountinfofood; // 할인정보
	private String firstmenu; //대표 메뉴
	private String infocenterfood; //문의 및 안내
	private String kidsfacility; // 어린이 놀이방 여부
	private String opendatefood; // 개업일
	private String opentimefood; //영업시간
	private String packing; // 포장 가능
	private String parkingfood; // 주차시설
	private String reservationfood; // 예약안내
	private String restdatefood; // 쉬는날
	private String scalefood; // 규모
	private String seat; // 좌석수
	private String smoking; // 금연/흡연 여부
	private String treatmenu; // 취급 메뉴
	private String lcnsno; // 인허가번호
	public String getAccomcount() {
		return accomcount;
	}
	public void setAccomcount(String accomcount) {
		this.accomcount = accomcount;
	}
	public String getChkbabycarriage() {
		return chkbabycarriage;
	}
	public void setChkbabycarriage(String chkbabycarriage) {
		this.chkbabycarriage = chkbabycarriage;
	}
	public String getChkcreditcard() {
		return chkcreditcard;
	}
	public void setChkcreditcard(String chkcreditcard) {
		this.chkcreditcard = chkcreditcard;
	}
	public String getChkpet() {
		return chkpet;
	}
	public void setChkpet(String chkpet) {
		this.chkpet = chkpet;
	}
	public String getExpagerange() {
		return expagerange;
	}
	public void setExpagerange(String expagerange) {
		this.expagerange = expagerange;
	}
	public String getExpguide() {
		return expguide;
	}
	public void setExpguide(String expguide) {
		this.expguide = expguide;
	}
	public String getHeritage1() {
		return heritage1;
	}
	public void setHeritage1(String heritage1) {
		this.heritage1 = heritage1;
	}
	public String getHeritage2() {
		return heritage2;
	}
	public void setHeritage2(String heritage2) {
		this.heritage2 = heritage2;
	}
	public String getHeritage3() {
		return heritage3;
	}
	public void setHeritage3(String heritage3) {
		this.heritage3 = heritage3;
	}
	public String getInfocenter() {
		return infocenter;
	}
	public void setInfocenter(String infocenter) {
		this.infocenter = infocenter;
	}
	public String getOpendate() {
		return opendate;
	}
	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getRestdate() {
		return restdate;
	}
	public void setRestdate(String restdate) {
		this.restdate = restdate;
	}
	public String getUseseason() {
		return useseason;
	}
	public void setUseseason(String useseason) {
		this.useseason = useseason;
	}
	public String getUsetime() {
		return usetime;
	}
	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}
	public String getAccomcountculture() {
		return accomcountculture;
	}
	public void setAccomcountculture(String accomcountculture) {
		this.accomcountculture = accomcountculture;
	}
	public String getChkbabycarriageculture() {
		return chkbabycarriageculture;
	}
	public void setChkbabycarriageculture(String chkbabycarriageculture) {
		this.chkbabycarriageculture = chkbabycarriageculture;
	}
	public String getChkcreditcardculture() {
		return chkcreditcardculture;
	}
	public void setChkcreditcardculture(String chkcreditcardculture) {
		this.chkcreditcardculture = chkcreditcardculture;
	}
	public String getChkpetculture() {
		return chkpetculture;
	}
	public void setChkpetculture(String chkpetculture) {
		this.chkpetculture = chkpetculture;
	}
	public String getDiscountinfo() {
		return discountinfo;
	}
	public void setDiscountinfo(String discountinfo) {
		this.discountinfo = discountinfo;
	}
	public String getInfocenterculture() {
		return infocenterculture;
	}
	public void setInfocenterculture(String infocenterculture) {
		this.infocenterculture = infocenterculture;
	}
	public String getParkingculture() {
		return parkingculture;
	}
	public void setParkingculture(String parkingculture) {
		this.parkingculture = parkingculture;
	}
	public String getParkingfee() {
		return parkingfee;
	}
	public void setParkingfee(String parkingfee) {
		this.parkingfee = parkingfee;
	}
	public String getRestdateculture() {
		return restdateculture;
	}
	public void setRestdateculture(String restdateculture) {
		this.restdateculture = restdateculture;
	}
	public String getUsefee() {
		return usefee;
	}
	public void setUsefee(String usefee) {
		this.usefee = usefee;
	}
	public String getUsetimeculture() {
		return usetimeculture;
	}
	public void setUsetimeculture(String usetimeculture) {
		this.usetimeculture = usetimeculture;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getSpendtime() {
		return spendtime;
	}
	public void setSpendtime(String spendtime) {
		this.spendtime = spendtime;
	}
	public String getAgelimit() {
		return agelimit;
	}
	public void setAgelimit(String agelimit) {
		this.agelimit = agelimit;
	}
	public String getBookingplace() {
		return bookingplace;
	}
	public void setBookingplace(String bookingplace) {
		this.bookingplace = bookingplace;
	}
	public String getDiscountinfofestival() {
		return discountinfofestival;
	}
	public void setDiscountinfofestival(String discountinfofestival) {
		this.discountinfofestival = discountinfofestival;
	}
	public String getEventenddate() {
		return eventenddate;
	}
	public void setEventenddate(String eventenddate) {
		this.eventenddate = eventenddate;
	}
	public String getEventhomepage() {
		return eventhomepage;
	}
	public void setEventhomepage(String eventhomepage) {
		this.eventhomepage = eventhomepage;
	}
	public String getEventplace() {
		return eventplace;
	}
	public void setEventplace(String eventplace) {
		this.eventplace = eventplace;
	}
	public String getEventstartdate() {
		return eventstartdate;
	}
	public void setEventstartdate(String eventstartdate) {
		this.eventstartdate = eventstartdate;
	}
	public String getFestivalgrade() {
		return festivalgrade;
	}
	public void setFestivalgrade(String festivalgrade) {
		this.festivalgrade = festivalgrade;
	}
	public String getPlaceinfo() {
		return placeinfo;
	}
	public void setPlaceinfo(String placeinfo) {
		this.placeinfo = placeinfo;
	}
	public String getPlaytime() {
		return playtime;
	}
	public void setPlaytime(String playtime) {
		this.playtime = playtime;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getSpendtimefestival() {
		return spendtimefestival;
	}
	public void setSpendtimefestival(String spendtimefestival) {
		this.spendtimefestival = spendtimefestival;
	}
	public String getSponsor1() {
		return sponsor1;
	}
	public void setSponsor1(String sponsor1) {
		this.sponsor1 = sponsor1;
	}
	public String getSponsor1tel() {
		return sponsor1tel;
	}
	public void setSponsor1tel(String sponsor1tel) {
		this.sponsor1tel = sponsor1tel;
	}
	public String getSponsor2() {
		return sponsor2;
	}
	public void setSponsor2(String sponsor2) {
		this.sponsor2 = sponsor2;
	}
	public String getSponsor2tel() {
		return sponsor2tel;
	}
	public void setSponsor2tel(String sponsor2tel) {
		this.sponsor2tel = sponsor2tel;
	}
	public String getSubevent() {
		return subevent;
	}
	public void setSubevent(String subevent) {
		this.subevent = subevent;
	}
	public String getUsetimefestival() {
		return usetimefestival;
	}
	public void setUsetimefestival(String usetimefestival) {
		this.usetimefestival = usetimefestival;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getInfocentertourcourse() {
		return infocentertourcourse;
	}
	public void setInfocentertourcourse(String infocentertourcourse) {
		this.infocentertourcourse = infocentertourcourse;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getTaketime() {
		return taketime;
	}
	public void setTaketime(String taketime) {
		this.taketime = taketime;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getAccomcountleports() {
		return accomcountleports;
	}
	public void setAccomcountleports(String accomcountleports) {
		this.accomcountleports = accomcountleports;
	}
	public String getChkbabycarriageleports() {
		return chkbabycarriageleports;
	}
	public void setChkbabycarriageleports(String chkbabycarriageleports) {
		this.chkbabycarriageleports = chkbabycarriageleports;
	}
	public String getChkcreditcardleports() {
		return chkcreditcardleports;
	}
	public void setChkcreditcardleports(String chkcreditcardleports) {
		this.chkcreditcardleports = chkcreditcardleports;
	}
	public String getChkpetleports() {
		return chkpetleports;
	}
	public void setChkpetleports(String chkpetleports) {
		this.chkpetleports = chkpetleports;
	}
	public String getExpagerangeleports() {
		return expagerangeleports;
	}
	public void setExpagerangeleports(String expagerangeleports) {
		this.expagerangeleports = expagerangeleports;
	}
	public String getInfocenterleports() {
		return infocenterleports;
	}
	public void setInfocenterleports(String infocenterleports) {
		this.infocenterleports = infocenterleports;
	}
	public String getOpenperiod() {
		return openperiod;
	}
	public void setOpenperiod(String openperiod) {
		this.openperiod = openperiod;
	}
	public String getParkingfeeleports() {
		return parkingfeeleports;
	}
	public void setParkingfeeleports(String parkingfeeleports) {
		this.parkingfeeleports = parkingfeeleports;
	}
	public String getParkingleports() {
		return parkingleports;
	}
	public void setParkingleports(String parkingleports) {
		this.parkingleports = parkingleports;
	}
	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	public String getRestdateleports() {
		return restdateleports;
	}
	public void setRestdateleports(String restdateleports) {
		this.restdateleports = restdateleports;
	}
	public String getScaleleports() {
		return scaleleports;
	}
	public void setScaleleports(String scaleleports) {
		this.scaleleports = scaleleports;
	}
	public String getUsefeeleports() {
		return usefeeleports;
	}
	public void setUsefeeleports(String usefeeleports) {
		this.usefeeleports = usefeeleports;
	}
	public String getUsetimeleports() {
		return usetimeleports;
	}
	public void setUsetimeleports(String usetimeleports) {
		this.usetimeleports = usetimeleports;
	}
	public String getAccomcountlodging() {
		return accomcountlodging;
	}
	public void setAccomcountlodging(String accomcountlodging) {
		this.accomcountlodging = accomcountlodging;
	}
	public String getBenikia() {
		return benikia;
	}
	public void setBenikia(String benikia) {
		this.benikia = benikia;
	}
	public String getCheckintime() {
		return checkintime;
	}
	public void setCheckintime(String checkintime) {
		this.checkintime = checkintime;
	}
	public String getCheckouttime() {
		return checkouttime;
	}
	public void setCheckouttime(String checkouttime) {
		this.checkouttime = checkouttime;
	}
	public String getChkcooking() {
		return chkcooking;
	}
	public void setChkcooking(String chkcooking) {
		this.chkcooking = chkcooking;
	}
	public String getFoodplace() {
		return foodplace;
	}
	public void setFoodplace(String foodplace) {
		this.foodplace = foodplace;
	}
	public String getGoodstay() {
		return goodstay;
	}
	public void setGoodstay(String goodstay) {
		this.goodstay = goodstay;
	}
	public String getHanok() {
		return hanok;
	}
	public void setHanok(String hanok) {
		this.hanok = hanok;
	}
	public String getInfocenterlodging() {
		return infocenterlodging;
	}
	public void setInfocenterlodging(String infocenterlodging) {
		this.infocenterlodging = infocenterlodging;
	}
	public String getParkinglodging() {
		return parkinglodging;
	}
	public void setParkinglodging(String parkinglodging) {
		this.parkinglodging = parkinglodging;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getRoomcount() {
		return roomcount;
	}
	public void setRoomcount(String roomcount) {
		this.roomcount = roomcount;
	}
	public String getReservationlodging() {
		return reservationlodging;
	}
	public void setReservationlodging(String reservationlodging) {
		this.reservationlodging = reservationlodging;
	}
	public String getReservationurl() {
		return reservationurl;
	}
	public void setReservationurl(String reservationurl) {
		this.reservationurl = reservationurl;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getScalelodging() {
		return scalelodging;
	}
	public void setScalelodging(String scalelodging) {
		this.scalelodging = scalelodging;
	}
	public String getSubfacility() {
		return subfacility;
	}
	public void setSubfacility(String subfacility) {
		this.subfacility = subfacility;
	}
	public String getBarbecue() {
		return barbecue;
	}
	public void setBarbecue(String barbecue) {
		this.barbecue = barbecue;
	}
	public String getBeauty() {
		return beauty;
	}
	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}
	public String getBeverage() {
		return beverage;
	}
	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}
	public String getBicycle() {
		return bicycle;
	}
	public void setBicycle(String bicycle) {
		this.bicycle = bicycle;
	}
	public String getCampfire() {
		return campfire;
	}
	public void setCampfire(String campfire) {
		this.campfire = campfire;
	}
	public String getFitness() {
		return fitness;
	}
	public void setFitness(String fitness) {
		this.fitness = fitness;
	}
	public String getKaraoke() {
		return karaoke;
	}
	public void setKaraoke(String karaoke) {
		this.karaoke = karaoke;
	}
	public String getPublicbath() {
		return publicbath;
	}
	public void setPublicbath(String publicbath) {
		this.publicbath = publicbath;
	}
	public String getPublicpc() {
		return publicpc;
	}
	public void setPublicpc(String publicpc) {
		this.publicpc = publicpc;
	}
	public String getSauna() {
		return sauna;
	}
	public void setSauna(String sauna) {
		this.sauna = sauna;
	}
	public String getSeminar() {
		return seminar;
	}
	public void setSeminar(String seminar) {
		this.seminar = seminar;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	public String getRefundregulation() {
		return refundregulation;
	}
	public void setRefundregulation(String refundregulation) {
		this.refundregulation = refundregulation;
	}
	public String getChkbabycarriageshopping() {
		return chkbabycarriageshopping;
	}
	public void setChkbabycarriageshopping(String chkbabycarriageshopping) {
		this.chkbabycarriageshopping = chkbabycarriageshopping;
	}
	public String getChkcreditcardshopping() {
		return chkcreditcardshopping;
	}
	public void setChkcreditcardshopping(String chkcreditcardshopping) {
		this.chkcreditcardshopping = chkcreditcardshopping;
	}
	public String getChkpetshopping() {
		return chkpetshopping;
	}
	public void setChkpetshopping(String chkpetshopping) {
		this.chkpetshopping = chkpetshopping;
	}
	public String getCulturecenter() {
		return culturecenter;
	}
	public void setCulturecenter(String culturecenter) {
		this.culturecenter = culturecenter;
	}
	public String getFairday() {
		return fairday;
	}
	public void setFairday(String fairday) {
		this.fairday = fairday;
	}
	public String getInfocentershopping() {
		return infocentershopping;
	}
	public void setInfocentershopping(String infocentershopping) {
		this.infocentershopping = infocentershopping;
	}
	public String getOpendateshopping() {
		return opendateshopping;
	}
	public void setOpendateshopping(String opendateshopping) {
		this.opendateshopping = opendateshopping;
	}
	public String getOpentime() {
		return opentime;
	}
	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}
	public String getParkingshopping() {
		return parkingshopping;
	}
	public void setParkingshopping(String parkingshopping) {
		this.parkingshopping = parkingshopping;
	}
	public String getRestdateshopping() {
		return restdateshopping;
	}
	public void setRestdateshopping(String restdateshopping) {
		this.restdateshopping = restdateshopping;
	}
	public String getRestroom() {
		return restroom;
	}
	public void setRestroom(String restroom) {
		this.restroom = restroom;
	}
	public String getSaleitem() {
		return saleitem;
	}
	public void setSaleitem(String saleitem) {
		this.saleitem = saleitem;
	}
	public String getSaleitemcost() {
		return saleitemcost;
	}
	public void setSaleitemcost(String saleitemcost) {
		this.saleitemcost = saleitemcost;
	}
	public String getScaleshopping() {
		return scaleshopping;
	}
	public void setScaleshopping(String scaleshopping) {
		this.scaleshopping = scaleshopping;
	}
	public String getShopguide() {
		return shopguide;
	}
	public void setShopguide(String shopguide) {
		this.shopguide = shopguide;
	}
	public String getChkcreditcardfood() {
		return chkcreditcardfood;
	}
	public void setChkcreditcardfood(String chkcreditcardfood) {
		this.chkcreditcardfood = chkcreditcardfood;
	}
	public String getDiscountinfofood() {
		return discountinfofood;
	}
	public void setDiscountinfofood(String discountinfofood) {
		this.discountinfofood = discountinfofood;
	}
	public String getFirstmenu() {
		return firstmenu;
	}
	public void setFirstmenu(String firstmenu) {
		this.firstmenu = firstmenu;
	}
	public String getInfocenterfood() {
		return infocenterfood;
	}
	public void setInfocenterfood(String infocenterfood) {
		this.infocenterfood = infocenterfood;
	}
	public String getKidsfacility() {
		return kidsfacility;
	}
	public void setKidsfacility(String kidsfacility) {
		this.kidsfacility = kidsfacility;
	}
	public String getOpendatefood() {
		return opendatefood;
	}
	public void setOpendatefood(String opendatefood) {
		this.opendatefood = opendatefood;
	}
	public String getOpentimefood() {
		return opentimefood;
	}
	public void setOpentimefood(String opentimefood) {
		this.opentimefood = opentimefood;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public String getParkingfood() {
		return parkingfood;
	}
	public void setParkingfood(String parkingfood) {
		this.parkingfood = parkingfood;
	}
	public String getReservationfood() {
		return reservationfood;
	}
	public void setReservationfood(String reservationfood) {
		this.reservationfood = reservationfood;
	}
	public String getRestdatefood() {
		return restdatefood;
	}
	public void setRestdatefood(String restdatefood) {
		this.restdatefood = restdatefood;
	}
	public String getScalefood() {
		return scalefood;
	}
	public void setScalefood(String scalefood) {
		this.scalefood = scalefood;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getTreatmenu() {
		return treatmenu;
	}
	public void setTreatmenu(String treatmenu) {
		this.treatmenu = treatmenu;
	}
	public String getLcnsno() {
		return lcnsno;
	}
	public void setLcnsno(String lcnsno) {
		this.lcnsno = lcnsno;
	}
	@Override
	public String toString() {
		return "TourContentInfoDTO [accomcount=" + accomcount + ", chkbabycarriage=" + chkbabycarriage
				+ ", chkcreditcard=" + chkcreditcard + ", chkpet=" + chkpet + ", expagerange=" + expagerange
				+ ", expguide=" + expguide + ", heritage1=" + heritage1 + ", heritage2=" + heritage2 + ", heritage3="
				+ heritage3 + ", infocenter=" + infocenter + ", opendate=" + opendate + ", parking=" + parking
				+ ", restdate=" + restdate + ", useseason=" + useseason + ", usetime=" + usetime
				+ ", accomcountculture=" + accomcountculture + ", chkbabycarriageculture=" + chkbabycarriageculture
				+ ", chkcreditcardculture=" + chkcreditcardculture + ", chkpetculture=" + chkpetculture
				+ ", discountinfo=" + discountinfo + ", infocenterculture=" + infocenterculture + ", parkingculture="
				+ parkingculture + ", parkingfee=" + parkingfee + ", restdateculture=" + restdateculture + ", usefee="
				+ usefee + ", usetimeculture=" + usetimeculture + ", scale=" + scale + ", spendtime=" + spendtime
				+ ", agelimit=" + agelimit + ", bookingplace=" + bookingplace + ", discountinfofestival="
				+ discountinfofestival + ", eventenddate=" + eventenddate + ", eventhomepage=" + eventhomepage
				+ ", eventplace=" + eventplace + ", eventstartdate=" + eventstartdate + ", festivalgrade="
				+ festivalgrade + ", placeinfo=" + placeinfo + ", playtime=" + playtime + ", program=" + program
				+ ", spendtimefestival=" + spendtimefestival + ", sponsor1=" + sponsor1 + ", sponsor1tel=" + sponsor1tel
				+ ", sponsor2=" + sponsor2 + ", sponsor2tel=" + sponsor2tel + ", subevent=" + subevent
				+ ", usetimefestival=" + usetimefestival + ", distance=" + distance + ", infocentertourcourse="
				+ infocentertourcourse + ", schedule=" + schedule + ", taketime=" + taketime + ", theme=" + theme
				+ ", accomcountleports=" + accomcountleports + ", chkbabycarriageleports=" + chkbabycarriageleports
				+ ", chkcreditcardleports=" + chkcreditcardleports + ", chkpetleports=" + chkpetleports
				+ ", expagerangeleports=" + expagerangeleports + ", infocenterleports=" + infocenterleports
				+ ", openperiod=" + openperiod + ", parkingfeeleports=" + parkingfeeleports + ", parkingleports="
				+ parkingleports + ", reservation=" + reservation + ", restdateleports=" + restdateleports
				+ ", scaleleports=" + scaleleports + ", usefeeleports=" + usefeeleports + ", usetimeleports="
				+ usetimeleports + ", accomcountlodging=" + accomcountlodging + ", benikia=" + benikia
				+ ", checkintime=" + checkintime + ", checkouttime=" + checkouttime + ", chkcooking=" + chkcooking
				+ ", foodplace=" + foodplace + ", goodstay=" + goodstay + ", hanok=" + hanok + ", infocenterlodging="
				+ infocenterlodging + ", parkinglodging=" + parkinglodging + ", pickup=" + pickup + ", roomcount="
				+ roomcount + ", reservationlodging=" + reservationlodging + ", reservationurl=" + reservationurl
				+ ", roomtype=" + roomtype + ", scalelodging=" + scalelodging + ", subfacility=" + subfacility
				+ ", barbecue=" + barbecue + ", beauty=" + beauty + ", beverage=" + beverage + ", bicycle=" + bicycle
				+ ", campfire=" + campfire + ", fitness=" + fitness + ", karaoke=" + karaoke + ", publicbath="
				+ publicbath + ", publicpc=" + publicpc + ", sauna=" + sauna + ", seminar=" + seminar + ", sports="
				+ sports + ", refundregulation=" + refundregulation + ", chkbabycarriageshopping="
				+ chkbabycarriageshopping + ", chkcreditcardshopping=" + chkcreditcardshopping + ", chkpetshopping="
				+ chkpetshopping + ", culturecenter=" + culturecenter + ", fairday=" + fairday + ", infocentershopping="
				+ infocentershopping + ", opendateshopping=" + opendateshopping + ", opentime=" + opentime
				+ ", parkingshopping=" + parkingshopping + ", restdateshopping=" + restdateshopping + ", restroom="
				+ restroom + ", saleitem=" + saleitem + ", saleitemcost=" + saleitemcost + ", scaleshopping="
				+ scaleshopping + ", shopguide=" + shopguide + ", chkcreditcardfood=" + chkcreditcardfood
				+ ", discountinfofood=" + discountinfofood + ", firstmenu=" + firstmenu + ", infocenterfood="
				+ infocenterfood + ", kidsfacility=" + kidsfacility + ", opendatefood=" + opendatefood
				+ ", opentimefood=" + opentimefood + ", packing=" + packing + ", parkingfood=" + parkingfood
				+ ", reservationfood=" + reservationfood + ", restdatefood=" + restdatefood + ", scalefood=" + scalefood
				+ ", seat=" + seat + ", smoking=" + smoking + ", treatmenu=" + treatmenu + ", lcnsno=" + lcnsno
				+ ", getAccomcount()=" + getAccomcount() + ", getChkbabycarriage()=" + getChkbabycarriage()
				+ ", getChkcreditcard()=" + getChkcreditcard() + ", getChkpet()=" + getChkpet() + ", getExpagerange()="
				+ getExpagerange() + ", getExpguide()=" + getExpguide() + ", getHeritage1()=" + getHeritage1()
				+ ", getHeritage2()=" + getHeritage2() + ", getHeritage3()=" + getHeritage3() + ", getInfocenter()="
				+ getInfocenter() + ", getOpendate()=" + getOpendate() + ", getParking()=" + getParking()
				+ ", getRestdate()=" + getRestdate() + ", getUseseason()=" + getUseseason() + ", getUsetime()="
				+ getUsetime() + ", getAccomcountculture()=" + getAccomcountculture() + ", getChkbabycarriageculture()="
				+ getChkbabycarriageculture() + ", getChkcreditcardculture()=" + getChkcreditcardculture()
				+ ", getChkpetculture()=" + getChkpetculture() + ", getDiscountinfo()=" + getDiscountinfo()
				+ ", getInfocenterculture()=" + getInfocenterculture() + ", getParkingculture()=" + getParkingculture()
				+ ", getParkingfee()=" + getParkingfee() + ", getRestdateculture()=" + getRestdateculture()
				+ ", getUsefee()=" + getUsefee() + ", getUsetimeculture()=" + getUsetimeculture() + ", getScale()="
				+ getScale() + ", getSpendtime()=" + getSpendtime() + ", getAgelimit()=" + getAgelimit()
				+ ", getBookingplace()=" + getBookingplace() + ", getDiscountinfofestival()="
				+ getDiscountinfofestival() + ", getEventenddate()=" + getEventenddate() + ", getEventhomepage()="
				+ getEventhomepage() + ", getEventplace()=" + getEventplace() + ", getEventstartdate()="
				+ getEventstartdate() + ", getFestivalgrade()=" + getFestivalgrade() + ", getPlaceinfo()="
				+ getPlaceinfo() + ", getPlaytime()=" + getPlaytime() + ", getProgram()=" + getProgram()
				+ ", getSpendtimefestival()=" + getSpendtimefestival() + ", getSponsor1()=" + getSponsor1()
				+ ", getSponsor1tel()=" + getSponsor1tel() + ", getSponsor2()=" + getSponsor2() + ", getSponsor2tel()="
				+ getSponsor2tel() + ", getSubevent()=" + getSubevent() + ", getUsetimefestival()="
				+ getUsetimefestival() + ", getDistance()=" + getDistance() + ", getInfocentertourcourse()="
				+ getInfocentertourcourse() + ", getSchedule()=" + getSchedule() + ", getTaketime()=" + getTaketime()
				+ ", getTheme()=" + getTheme() + ", getAccomcountleports()=" + getAccomcountleports()
				+ ", getChkbabycarriageleports()=" + getChkbabycarriageleports() + ", getChkcreditcardleports()="
				+ getChkcreditcardleports() + ", getChkpetleports()=" + getChkpetleports()
				+ ", getExpagerangeleports()=" + getExpagerangeleports() + ", getInfocenterleports()="
				+ getInfocenterleports() + ", getOpenperiod()=" + getOpenperiod() + ", getParkingfeeleports()="
				+ getParkingfeeleports() + ", getParkingleports()=" + getParkingleports() + ", getReservation()="
				+ getReservation() + ", getRestdateleports()=" + getRestdateleports() + ", getScaleleports()="
				+ getScaleleports() + ", getUsefeeleports()=" + getUsefeeleports() + ", getUsetimeleports()="
				+ getUsetimeleports() + ", getAccomcountlodging()=" + getAccomcountlodging() + ", getBenikia()="
				+ getBenikia() + ", getCheckintime()=" + getCheckintime() + ", getCheckouttime()=" + getCheckouttime()
				+ ", getChkcooking()=" + getChkcooking() + ", getFoodplace()=" + getFoodplace() + ", getGoodstay()="
				+ getGoodstay() + ", getHanok()=" + getHanok() + ", getInfocenterlodging()=" + getInfocenterlodging()
				+ ", getParkinglodging()=" + getParkinglodging() + ", getPickup()=" + getPickup() + ", getRoomcount()="
				+ getRoomcount() + ", getReservationlodging()=" + getReservationlodging() + ", getReservationurl()="
				+ getReservationurl() + ", getRoomtype()=" + getRoomtype() + ", getScalelodging()=" + getScalelodging()
				+ ", getSubfacility()=" + getSubfacility() + ", getBarbecue()=" + getBarbecue() + ", getBeauty()="
				+ getBeauty() + ", getBeverage()=" + getBeverage() + ", getBicycle()=" + getBicycle()
				+ ", getCampfire()=" + getCampfire() + ", getFitness()=" + getFitness() + ", getKaraoke()="
				+ getKaraoke() + ", getPublicbath()=" + getPublicbath() + ", getPublicpc()=" + getPublicpc()
				+ ", getSauna()=" + getSauna() + ", getSeminar()=" + getSeminar() + ", getSports()=" + getSports()
				+ ", getRefundregulation()=" + getRefundregulation() + ", getChkbabycarriageshopping()="
				+ getChkbabycarriageshopping() + ", getChkcreditcardshopping()=" + getChkcreditcardshopping()
				+ ", getChkpetshopping()=" + getChkpetshopping() + ", getCulturecenter()=" + getCulturecenter()
				+ ", getFairday()=" + getFairday() + ", getInfocentershopping()=" + getInfocentershopping()
				+ ", getOpendateshopping()=" + getOpendateshopping() + ", getOpentime()=" + getOpentime()
				+ ", getParkingshopping()=" + getParkingshopping() + ", getRestdateshopping()=" + getRestdateshopping()
				+ ", getRestroom()=" + getRestroom() + ", getSaleitem()=" + getSaleitem() + ", getSaleitemcost()="
				+ getSaleitemcost() + ", getScaleshopping()=" + getScaleshopping() + ", getShopguide()="
				+ getShopguide() + ", getChkcreditcardfood()=" + getChkcreditcardfood() + ", getDiscountinfofood()="
				+ getDiscountinfofood() + ", getFirstmenu()=" + getFirstmenu() + ", getInfocenterfood()="
				+ getInfocenterfood() + ", getKidsfacility()=" + getKidsfacility() + ", getOpendatefood()="
				+ getOpendatefood() + ", getOpentimefood()=" + getOpentimefood() + ", getPacking()=" + getPacking()
				+ ", getParkingfood()=" + getParkingfood() + ", getReservationfood()=" + getReservationfood()
				+ ", getRestdatefood()=" + getRestdatefood() + ", getScalefood()=" + getScalefood() + ", getSeat()="
				+ getSeat() + ", getSmoking()=" + getSmoking() + ", getTreatmenu()=" + getTreatmenu() + ", getLcnsno()="
				+ getLcnsno() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
