<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 정보</title>
<style type="text/css">
	body {
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
	}
	.btnGreen01 { 
		display:inline-block; 
		width:150px; 
		height:30px; 
		padding:2px 0;
		border-radius: 1pt;
		border-color: #262626; 
		text-align:center; 
		font-family:NGBold; 
		font-size:15px; 
		color:#fff; 
		background: #069370; 
	}
	
</style>
</head>
<body>
	<c:import url="../default/header.jsp"/>
		<div style="padding: 10px;">
		<div>
			<h2 style="border-bottom: 1px solid #cfcfcf; padding-bottom: 10px;">지역 관광 정보 검색</h2>
		</div>
		<div>
			<h3 style="border-bottom: 2px solid #cfcfcf; padding-bottom: 10px;">${map.info.title }</h3>
		</div>
		<div style="width: 25%; align-content: left;">
			<img style="height: 600px; width: 600px;"onerror="this.src='/resources/images/noimage.png'" src="${map.info.firstimage }">
		</div>
		
		${map.info.createdtime }<br>
		${map.info.modifiedtime}<br>
		${map.info.addr1}<br>
		${map.info.tel}<br>
		${map.info.homepage}<br>
		${map.info.overview}<br>
		<hr>
		상세정보<br>
		<c:choose>
			<c:when test="${contenttypeid == 12 }">
				<c:if test="${map.contentInfo.accomcount !=' '}">
					수용인원 : ${map.contentInfo.accomcount }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkbabycarriage !=' '}">
					유모차 대여 정보 : ${map.contentInfo.chkbabycarriage }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkcreditcard !=' '}">
					신용카드가능 정보 : ${map.contentInfo.chkcreditcard }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkpet !=' '}">
					애완동물동반가능 정보 : ${map.contentInfo.chkpet }<br>
				</c:if>
				<c:if test="${map.contentInfo.expagerange !=' '}">
					체험가능 연령 : ${map.contentInfo.expagerange }<br>
				</c:if>
				<c:if test="${map.contentInfo.expguide !=' '}">
					체험안내 : ${map.contentInfo.expguide }<br>
				</c:if>
				<c:if test="${map.contentInfo.heritage1 != '0'}">
					세계 문화유산으로 지정되었습니다.<br>
				</c:if>
				<c:if test="${map.contentInfo.heritage2 != '0'}">
					세계 자연유산으로 지정되었습니다.<br>
				</c:if>
				<c:if test="${map.contentInfo.heritage3 != '0'}">
					세계 기록유산으로 지정되었습니다.<br>
				</c:if>
				<c:if test="${map.contentInfo.infocenter !=' '}">
					문의 및 안내 : ${map.contentInfo.infocenter }<br>
				</c:if>
				<c:if test="${map.contentInfo.opendate !=' '}">
					개장일 : ${map.contentInfo.opendate }<br>
				</c:if>
				<c:if test="${map.contentInfo.parking !=' '}">
					주차시설 : ${map.contentInfo.parking }<br>
				</c:if>
				<c:if test="${map.contentInfo.restdate !=' '}">
					쉬는날 : ${map.contentInfo.restdate }<br>
				</c:if>
				<c:if test="${map.contentInfo.useseason !=' '}">
					이용시기 : ${map.contentInfo.useseason }<br>
				</c:if>
				<c:if test="${map.contentInfo.usetime !=' '}">
					이용시간 : ${map.contentInfo.usetime }
				</c:if>
			</c:when>
			<c:when test="${contenttypeid == 14 }">
				<c:if test="${map.contentInfo.accomcountculture !=' '}">
					수용인원 : ${map.contentInfo.accomcountculture }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkbabycarriageculture !=' '}">
					유모차대여 정보 : ${map.contentInfo.chkbabycarriageculture }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkcreditcardculture !=' '}">
					신용카드가능 정보 : ${map.contentInfo.chkcreditcardculture }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkpetculture !=' '}">
					애완동물동반가능 여부 : ${map.contentInfo.chkpetculture }<br>
				</c:if>
				<c:if test="${map.contentInfo.discountinfo !=' '}">
					할인정보 : ${map.contentInfo.discountinfo }<br>
				</c:if>
				<c:if test="${map.contentInfo.infocenterculture !=' '}">
					문의 및 안내 : ${map.contentInfo.infocenterculture }<br>
				</c:if>
				<c:if test="${map.contentInfo.parkingculture !=' '}">
					주차시설 : ${map.contentInfo.parkingculture }<br>
				</c:if>
				<c:if test="${map.contentInfo.parkingfee !=' '}">
					주차요금 : ${map.contentInfo.parkingfee }<br>
				</c:if>
				<c:if test="${map.contentInfo.restdateculture !=' '}">
					쉬는날 : ${map.contentInfo.restdateculture }<br>
				</c:if>
				<c:if test="${map.contentInfo.usefee !=' '}">
					이용요금 : ${map.contentInfo.usefee }<br>
				</c:if>
				<c:if test="${map.contentInfo.usetimeculture !=' '}">
					이용시간 : <br>${map.contentInfo.usetimeculture }<br>
				</c:if>
				<c:if test="${map.contentInfo.scale !=' '}">
					규모 : ${map.contentInfo.scale }<br>
				</c:if>
				<c:if test="${map.contentInfo.spendtime !=' '}">
					관람 소요시간 : ${map.contentInfo.spendtime }<br>
				</c:if>
			</c:when>
			<c:when test="${contenttypeid == 15 }">
				<c:if test="${map.contentInfo.agelimit !=' '}">
					관람 가능연령 : ${map.contentInfo.agelimit }<br>
				</c:if>
				<c:if test="${map.contentInfo.bookingplace !=' '}">
					예매처 : ${map.contentInfo.bookingplace }<br>
				</c:if>
				<c:if test="${map.contentInfo.discountinfofestival !=' '}">
					할인정보 : ${map.contentInfo.discountinfofestival }<br>
				</c:if>
				<c:if test="${map.contentInfo.eventenddate !=' '}">
					행사 종료일 : ${map.contentInfo.eventenddate }<br>
				</c:if>
				<c:if test="${map.contentInfo.eventhomepage !=' '}">
					행사 홈페이지 : ${map.contentInfo.eventhomepage }<br>
				</c:if>
				<c:if test="${map.contentInfo.eventplace !=' '}">
					행사 장소 : ${map.contentInfo.eventplace }<br>
				</c:if>
				<c:if test="${map.contentInfo.eventstartdate !=' '}">
					행사 시작일 : ${map.contentInfo.eventstartdate }<br>
				</c:if>
				<c:if test="${map.contentInfo.festivalgrade !=' '}">
					축제 등급 : ${map.contentInfo.festivalgrade }<br>
				</c:if>
				<c:if test="${map.contentInfo.placeinfo !=' '}">
					행사장 위치안내 : ${map.contentInfo.placeinfo }<br>
				</c:if>
				<c:if test="${map.contentInfo.playtime !=' '}">
					공연시간 : ${map.contentInfo.playtime }<br>
				</c:if>
				<c:if test="${map.contentInfo.program !=' '}">
					행사 프로그램 : ${map.contentInfo.program }<br>
				</c:if>
				<c:if test="${map.contentInfo.spendtimefestival !=' '}">
					관람 소요시간 : ${map.contentInfo.spendtimefestival }<br>
				</c:if>
				<c:if test="${map.contentInfo.sponsor1 !=' '}">
					주최자 정보 : ${map.contentInfo.sponsor1 }<br>
				</c:if>
				<c:if test="${map.contentInfo.sponsor1tel !=' '}">
					주최자 연락처 : ${map.contentInfo.sponsor1tel }<br>
				</c:if>
				<c:if test="${map.contentInfo.sponsor2 !=' '}">
					주관사 정보 : ${map.contentInfo.sponsor2 }<br>
				</c:if>
				<c:if test="${map.contentInfo.sponsor2tel !=' '}">
					주관사 연락처 : ${map.contentInfo.sponsor2tel }<br>
				</c:if>
				<c:if test="${map.contentInfo.subevent !=' '}">
					부대행사 : ${map.contentInfo.subevent }<br>
				</c:if>
				<c:if test="${map.contentInfo.usetimefestival !=' '}">
					이용요금 : ${map.contentInfo.usetimefestival }<br>
				</c:if>
			</c:when>
			<c:when test="${contenttypeid == 25 }">
				<c:if test="${map.contentInfo.distance !=' '}">
					코스 총 거리 : ${map.contentInfo.distance }<br>
				</c:if>
				<c:if test="${map.contentInfo.infocentertourcourse !=' '}">
					문의 및 안내 : ${map.contentInfo.infocentertourcourse }<br>
				</c:if>
				<c:if test="${map.contentInfo.schedule !=' '}">
					코스 일정 : ${map.contentInfo.schedule }<br>
				</c:if>
				<c:if test="${map.contentInfo.taketime !=' '}">
					코스 총 소요시간 : ${map.contentInfo.taketime }<br>
				</c:if>
				<c:if test="${map.contentInfo.theme !=' '}">
					코스 테마 : ${map.contentInfo.theme }<br>
				</c:if>
			</c:when>
			<c:when test="${contenttypeid == 28 }">
				<c:if test="${map.contentInfo.accomcountleports !=' '}">
					수용인원 : ${map.contentInfo.accomcountleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkbabycarriageleports !=' '}">
					유모차대여 정보 : ${map.contentInfo.chkbabycarriageleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkcreditcardleports !=' '}">
					신용카드가능 정보 : ${map.contentInfo.chkcreditcardleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkpetleports !=' '}">
					애완동물동반가능 정보 : ${map.contentInfo.chkpetleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.expagerangeleports !=' '}">
					체험 가능연령 : ${map.contentInfo.expagerangeleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.infocenterleports !=' '}">
					문의 및 안내 : ${map.contentInfo.infocenterleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.openperiod !=' '}">
					개장기간 : ${map.contentInfo.openperiod }<br>
				</c:if>
				<c:if test="${map.contentInfo.parkingfeeleports !=' '}">
					주차요금 : ${map.contentInfo.parkingfeeleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.parkingleports !=' '}">
					주차시설 : ${map.contentInfo.parkingleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.reservation !=' '}">
					예약안내 : ${map.contentInfo.reservation }<br>
				</c:if>
				<c:if test="${map.contentInfo.restdateleports !=' '}">
					쉬는날 : ${map.contentInfo.restdateleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.scaleleports !=' '}">
					규모 : ${map.contentInfo.scaleleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.usefeeleports !=' '}">
					입장료 : ${map.contentInfo.usefeeleports }<br>
				</c:if>
				<c:if test="${map.contentInfo.usetimeleports !=' '}">
					이용시간 : <br>${map.contentInfo.usetimeleports }<br>
				</c:if>
			</c:when>
			<c:when test="${contenttypeid == 32 }">
				<c:if test="${map.contentInfo.accomcountlodging !=' '}">
					수용 가능인원 : ${map.contentInfo.accomcountlodging }<br>
				</c:if>
				<c:if test="${map.contentInfo.benikia !='0'}">
					베니키아 호텔 시설입니다.<br>
				</c:if>
				<c:if test="${map.contentInfo.checkintime !=' '}">
					입실 시간 : ${map.contentInfo.checkintime }<br>
				</c:if>
				<c:if test="${map.contentInfo.checkouttime !=' '}">
					퇴실 시간 : ${map.contentInfo.checkouttime }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkcooking !=' '}">
					객실내 취사 여부 : ${map.contentInfo.chkcooking }<br>
				</c:if>
				<c:if test="${map.contentInfo.foodplace !=' '}">
					식음료장 : ${map.contentInfo.foodplace }<br>
				</c:if>
				<c:if test="${map.contentInfo.goodstay !='0'}">
					굿스테이 시설입니다.<br>
				</c:if>
				<c:if test="${map.contentInfo.hanok !='0'}">
					한옥 시설입니다.<br>
				</c:if>
				<c:if test="${map.contentInfo.infocenterlodging !=' '}">
					문의 및 안내 : ${map.contentInfo.infocenterlodging }<br>
				</c:if>
				<c:if test="${map.contentInfo.parkinglodging !=' '}">
					주차시설 : ${map.contentInfo.parkinglodging }<br>
				</c:if>
				<c:if test="${map.contentInfo.pickup !=' '}">
					픽업 서비스 : ${map.contentInfo.pickup }<br>
				</c:if>
				<c:if test="${map.contentInfo.roomcount !=' '}">
					객실 수 : ${map.contentInfo.roomcount }<br>
				</c:if>
				<c:if test="${map.contentInfo.reservationlodging !=' '}">
					예약안내 : ${map.contentInfo.reservationlodging }<br>
				</c:if>
				<c:if test="${map.contentInfo.reservationurl !=' '}">
					예약안내 홈페이지 : ${map.contentInfo.reservationurl }<br>
				</c:if>
				<c:if test="${map.contentInfo.roomtype !=' '}">
					객실유형 : ${map.contentInfo.roomtype }<br>
				</c:if>
				<c:if test="${map.contentInfo.scalelodging !=' '}">
					규모 : ${map.contentInfo.scalelodging }<br>
				</c:if>
				<c:if test="${map.contentInfo.subfacility !=' '}">
					부대시설(기타) : ${map.contentInfo.subfacility }<br>
				</c:if>
				<c:if test="${map.contentInfo.barbecue !='0'}">
					바비큐장 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.beauty !='0'}">
					뷰티시설 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.beverage !='0'}">
					식음료장 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.bicycle !='0'}">
					자전거 대여 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.campfire !='0'}">
					캠프파이어 시설 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.fitness !='0'}">
					휘트니스 센터 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.karaoke !='0'}">
					노래방 시설 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.publicbath !='0'}">
					공용 샤워실 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.publicpc !='0'}">
					공용 PC 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.sauna !='0'}">
					사우나실 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.seminar !='0'}">
					세미나실 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.sports !='0'}">
					스포츠 시설 이용 가능<br>
				</c:if>
				<c:if test="${map.contentInfo.refundregulation !=' '}">
					환불규정 : ${map.contentInfo.refundregulation }<br>
				</c:if>
			</c:when>
			<c:when test="${contenttypeid == 38 }">
				<c:if test="${map.contentInfo.chkbabycarriageshopping !=' '}">
					유모차대여 정보 : ${map.contentInfo.chkbabycarriageshopping }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkcreditcardshopping !=' '}">
					신용카드 가능 정보 : ${map.contentInfo.chkcreditcardshopping }<br>
				</c:if>
				<c:if test="${map.contentInfo.chkpetshopping !=' '}">
					애완동물동반가능 정보 : ${map.contentInfo.chkpetshopping }<br>
				</c:if>
				<c:if test="${map.contentInfo.culturecenter !=' '}">
					문화센터 바로가기 : ${map.contentInfo.culturecenter }<br>
				</c:if>
				<c:if test="${map.contentInfo.fairday !=' '}">
					장서는 날 : ${map.contentInfo.fairday }<br>
				</c:if>
				<c:if test="${map.contentInfo.infocentershopping !=' '}">
					문의 및 안내 : ${map.contentInfo.infocentershopping }<br>
				</c:if>
				<c:if test="${map.contentInfo.opendateshopping !=' '}">
					개장일 : ${map.contentInfo.opendateshopping }<br>
				</c:if>
				<c:if test="${map.contentInfo.opentime !=' '}">
					영업시간 : ${map.contentInfo.opentime }<br>
				</c:if>
				<c:if test="${map.contentInfo.parkingshopping !=' '}">
					주차시설 : ${map.contentInfo.parkingshopping }<br>
				</c:if>
				<c:if test="${map.contentInfo.restdateshopping !=' '}">
					쉬는날 : ${map.contentInfo.restdateshopping }<br>
				</c:if>
				<c:if test="${map.contentInfo.restroom !=' '}">
					화장실 설명 : ${map.contentInfo.restroom }<br>
				</c:if>
				<c:if test="${map.contentInfo.saleitem !=' '}">
					판매 품목 : ${map.contentInfo.saleitem }<br>
				</c:if>
				<c:if test="${map.contentInfo.saleitemcost !=' '}">
					판매 품목별 가격 : ${map.contentInfo.saleitemcost }<br>
				</c:if>
				<c:if test="${map.contentInfo.scaleshopping !=' '}">
					규모 : ${map.contentInfo.scaleshopping }<br>
				</c:if>
				<c:if test="${map.contentInfo.shopguide !=' '}">
					매장안내 : <br>${map.contentInfo.shopguide }<br>
				</c:if>
			</c:when>
			<c:when test="${contenttypeid == 39 }">
				<c:if test="${map.contentInfo.chkcreditcardfood !=' '}">
					신용카드가능 정보 : ${map.contentInfo.chkcreditcardfood }<br>
				</c:if>
				<c:if test="${map.contentInfo.discountinfofood !=' '}">
					할인정보 : ${map.contentInfo.discountinfofood }<br>
				</c:if>
				<c:if test="${map.contentInfo.firstmenu !=' '}">
					대표 메뉴 : ${map.contentInfo.firstmenu }<br>
				</c:if>
				<c:if test="${map.contentInfo.infocenterfood !=' '}">
					문의 및 안내 : ${map.contentInfo.infocenterfood }<br>
				</c:if>
				<c:if test="${map.contentInfo.kidsfacility !='0'}">
					어린이 놀이방 시설 있습니다.<br>
				</c:if>
				<c:if test="${map.contentInfo.opendatefood !=' '}">
					개업일 : ${map.contentInfo.opendatefood }<br>
				</c:if>
				<c:if test="${map.contentInfo.opentimefood !=' '}">
					영업시간 : ${map.contentInfo.opentimefood }<br>
				</c:if>
				<c:if test="${map.contentInfo.packing !=' '}">
					포장가능 : ${map.contentInfo.packing }<br>
				</c:if>
				<c:if test="${map.contentInfo.parkingfood !=' '}">
					주차시설 : ${map.contentInfo.parkingfood }<br>
				</c:if>
				<c:if test="${map.contentInfo.reservationfood !=' '}">
					예약안내 : ${map.contentInfo.reservationfood }<br>
				</c:if>
				<c:if test="${map.contentInfo.restdatefood !=' '}">
					쉬는날 : ${map.contentInfo.restdatefood }<br>
				</c:if>
				<c:if test="${map.contentInfo.scalefood !=' '}">
					규모 : ${map.contentInfo.scalefood }<br>
				</c:if>
				<c:if test="${map.contentInfo.seat !=' '}">
					좌석수 : ${map.contentInfo.seat }<br>
				</c:if>
				<c:if test="${map.contentInfo.smoking !=' '}">
					금연/흡연 여부 : ${map.contentInfo.smoking }<br>
				</c:if>
				<c:if test="${map.contentInfo.treatmenu !=' '}">
					취급 메뉴 : ${map.contentInfo.treatmenu }<br>
				</c:if>
				<c:if test="${map.contentInfo.lcnsno !=' '}">
					인허가번호 : ${map.contentInfo.lcnsno }<br>
				</c:if>
			</c:when>
		</c:choose>
		
		<hr>
		위치정보
		<div id="map" style="width:500px;height:400px;"></div>
		<hr>
		<div id="roadview" style="width:800px;height:400px;"></div>
		<a href="/board/register?contentId=${contentid}&contentTypeId=${contenttypeid}">리뷰 작성하기</a>
		<hr>
		
		<div align="center">
		<table border="1">
			<tr>
				<th>번호</th>	
				<th>제목</th>	
				<th>글쓴이	</th>	
				<th>작성일</th>	
				<th>조회수</th>	
				<th>추천</th>	
				<th>ref</th>	
				<th>step</th>	
				<th>refOrder</th>	
				<th>answerNum</th>	
				<th>parentNum</th>	
			</tr>
			<c:forEach var="list" items="${list }">
				<tr>
					<td><c:out value="${list.id }"/></td>
					<td><a href="/board/detail?id=${list.id }&ref=${list.ref }"><c:out value="${list.title }"/></a></td>
					<td><c:out value="${list.userId }"/></td>
					<td><c:out value="${list.regDate }"/></td>
					<td><c:out value="${list.hit }"/></td>
					<td><c:out value="${list.recommend }"/></td>
					<td><c:out value="${list.ref }"/></td>
					<td><c:out value="${list.step }"/></td>
					<td><c:out value="${list.refOrder }"/></td>
					<td><c:out value="${list.answerNum }"/></td>
					<td><c:out value="${list.parentNum }"/></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<c:if test="${pageMaker.prev }">
			<a href="/board/list?pageNum=${pageMaker.startPage-1 }"><c:out value="prev"/></a>
		</c:if>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="page">
			<a href="/board/list?pageNum=${page }"><c:out value="${page }"/></a>
		</c:forEach>
		<c:if test="${pageMaker.next }">
			<a href="/board/list?pageNum=${pageMaker.endPage+1 }"><c:out value="next"/></a>
		</c:if>
		<br><br>
		<form id='searchForm' action="/board/list" method='get' >
			<select name='type'>
				<option value="" <c:out value="${pageMaker.cri.type == null? 'selected ' : ''}"/>>--</option>
				<option value="T" <c:out value="${pageMaker.cri.type eq 'T'? 'selected ' : ''}"/>>제목</option>
				<option value="C" <c:out value="${pageMaker.cri.type eq 'C'? 'selected ' : ''}"/>>내용</option>
				<option value="W" <c:out value="${pageMaker.cri.type eq 'W'? 'selected ' : ''}"/>>글쓴이</option>
			</select>
			<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword }"/>'/>
			<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum }"/>'/>
			<input type="submit" value="Search">
		</form>
	</div>
		<div id="roadview" style="width:1000px; height:500px;"></div>
		<hr>
		<input class="btnGreen01" type="button" value="즐겨찾기 추가" onclick="addWishList();">
		</div>
	<c:import url="../default/footer.jsp"/>
</body>
<script>
	var contentId = "${contentid}";
	var contentTypeId = "${contenttypeid}"
	var list = {contentId : contentId, contentTypeId: contentTypeId}
	function addWishList(){
		console.log(list);
		$.ajax({
			url:"/memberDetail/addWishList",
			type:"POST",
			data: JSON.stringify(list),
	        contentType: "application/json",
			success : function(data){
				alert("즐겨찾기 추가 성공!");
			}
		});
	}
</script>
<!-- appkey에 카카오 javascript key -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4a8c2d955aeb07b54a172c2b1b1490d3"></script>
<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapCenter = new kakao.maps.LatLng( ${map.info.mapy}, ${map.info.mapx} ), // 지도의 중심 좌표
	    mapOption = {
	        center: mapCenter, // 지도의 중심 좌표
	        level: 4 // 지도의 확대 레벨
	    };

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성
		var map = new kakao.maps.Map(mapContainer, mapOption);
	
		// 지도에 올릴 마커를 생성
		var mMarker = new kakao.maps.Marker({
		    position: mapCenter, // 지도의 중심좌표에 올리기.
		    map: map // 생성하면서 지도에 올리기.
		});
	
		// 지도에 올릴 장소명 인포윈도우
		var mLabel = new kakao.maps.InfoWindow({
		    position: mapCenter, // 지도의 중심좌표에 올리기.
		    content: '${map.info.title}' // 인포윈도우 내부에 들어갈 컨텐츠.
		});
		mLabel.open(map, mMarker); // 지도에 올리면서, 두번째 인자로 들어간 마커 위에 올라가도록 설정.
				
		var rvContainer = document.getElementById('roadview'); // 로드뷰를 표시할 div
		var rv = new kakao.maps.Roadview(rvContainer); // 로드뷰 객체 생성
		var rc = new kakao.maps.RoadviewClient(); // 좌표를 통한 로드뷰의 panoid를 추출하기 위한 로드뷰 help객체 생성
		var rvResetValue = {} //로드뷰의 초기화 값을 저장할 변수
		rc.getNearestPanoId(mapCenter, 50, function(panoId) {
		    rv.setPanoId(panoId, mapCenter);//좌표에 근접한 panoId를 통해 로드뷰를 실행.
		    rvResetValue.panoId = panoId;
		});
	
		// 로드뷰 초기화 이벤트
		kakao.maps.event.addListener(rv, 'init', function() {
	
		    // 로드뷰에 올릴 마커를 생성.
		    var rMarker = new kakao.maps.Marker({
		        position: mapCenter,
		        map: rv //map 대신 rv(로드뷰 객체)로 설정하면 로드뷰에 올라감.
		    });
	
		    // 로드뷰에 올릴 장소명 인포윈도우를 생성.
		    var rLabel = new kakao.maps.InfoWindow({
		        position: mapCenter,
		        content: '${map.info.title}'
		    });
		    rLabel.open(rv, rMarker);
	
		    // 로드뷰 마커가 중앙에 오도록 로드뷰의 viewpoint 조정.
		    var projection = rv.getProjection(); // viewpoint(화면좌표)값을 추출할 수 있는 projection 객체를 가져옴.
		    
		    // 마커의 position과 altitude값을 통해 viewpoint값(화면좌표)를 추출.
		    var viewpoint = projection.viewpointFromCoords(rMarker.getPosition(), rMarker.getAltitude());
		    rv.setViewpoint(viewpoint); //로드뷰에 뷰포인트를 설정.
	
		    //각 뷰포인트 값을 초기화를 위해 저장해 놓는다.
		    rvResetValue.pan = viewpoint.pan;
		    rvResetValue.tilt = viewpoint.tilt;
		    rvResetValue.zoom = viewpoint.zoom;
		});
	
		//지도 이동 이벤트 핸들러
		function moveKakaoMap(self){
		    
		    var center = map.getCenter(), 
		        lat = center.getLat(),
		        lng = center.getLng();
	
		    self.href = 'https://map.kakao.com/link/map/' + encodeURIComponent('${map.info.title}') + ',' + lat + ',' + lng; //Kakao 지도로 보내는 링크
		}
	
		//지도 초기화 이벤트 핸들러
		function resetKakaoMap(){
		    map.setCenter(mapCenter); //지도를 초기화 했던 값으로 다시 셋팅.
		    map.setLevel(mapOption.level);
		}
	
		//로드뷰 이동 이벤트 핸들러
		function moveKakaoRoadview(self){
		    var panoId = rv.getPanoId(); //현 로드뷰의 panoId값을 가져옴.
		    var viewpoint = rv.getViewpoint(); //현 로드뷰의 viewpoint(pan,tilt,zoom)값을 가져옴.
		    self.href = 'https://map.kakao.com/?panoid='+panoId+'&pan='+viewpoint.pan+'&tilt='+viewpoint.tilt+'&zoom='+viewpoint.zoom; //Kakao 지도 로드뷰로 보내는 링크
		}
	
		//로드뷰 초기화 이벤트 핸들러
		function resetRoadview(){
		    //초기화를 위해 저장해둔 변수를 통해 로드뷰를 초기상태로 되돌림.
		    rv.setViewpoint({
		        pan: rvResetValue.pan, tilt: rvResetValue.tilt, zoom: rvResetValue.zoom
		    });
		    rv.setPanoId(rvResetValue.panoId);
		}		
	</script>
</html>