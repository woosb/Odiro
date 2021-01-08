<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
 <style type="text/css">
	.mainDiv {
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
	}
</style>
<body class="mainDiv">
<c:import url="default/header.jsp"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>

<style type="text/css">

.swiper-container {
    width:1190px;
    height:420px;
    border:5px solid silver;
    border-radius:7px;
    box-shadow:0 0 20px #ccc inset;
}
.swiper-slide {
    text-align:center;
    display:flex; /* 내용을 중앙정렬 하기위해 flex 사용 */
    align-items:center; /* 위아래 기준 중앙정렬 */
    justify-content:center; /* 좌우 기준 중앙정렬 */
}
.swiper-slide img {
	width: 1180px;
	height: 390px;
	margin-bottom: 20px;
	box-shadow:0 0 5px #555;
}
	div.category{
		background-color: #069370;
		border-bottom-color: 1px #000;
		color: white;
		padding-top: 8px;
	}
    div.left {
        width: 50%;
        float: left;
        box-sizing: border-box;
        border: 3px solid #000;
        height : 246px;
    }
    div.right {
        width: 50%;
        float: right;
        box-sizing: border-box;
        border: 3px solid #000;
        height : 246px;
    }
    div.bottom {
    	min-height: 248px;
    }
</style>

<!-- 클래스명은 변경하면 안 됨 -->
<div align="center">
<div class="swiper-container swiper1">
	<div class="swiper-wrapper">
		<div class="swiper-slide"><img src="http://www.visitkorea.or.kr/intro/images/pic01.jpg"></div>
		<div class="swiper-slide"><img src="http://www.visitkorea.or.kr/intro/images/pic02.jpg"></div>
		<div class="swiper-slide"><img src="http://www.visitkorea.or.kr/intro/images/pic03.jpg"></div>
		<div class="swiper-slide"><img src="http://www.visitkorea.or.kr/intro/images/pic04.jpg"></div>
	</div>
	<!-- 페이징 -->
	<div class="swiper-pagination"></div>
</div>
<hr>
	<div class="bottom">
	<div class="left">
	<div class="category"><span style="font-size: 23px; font-weight: 500;">최근 공지사항</span><hr></div>
		<c:forEach var="brd" items="${map.list}">
			<a href="/notice/getDetail?no=${brd.notice_no }" style="text-decoration: none;">${brd.notice_title }</a><br><hr>
		</c:forEach>
	</div>
	<div class="right">
	<div class="category"><span style="font-size: 23px; font-weight: 500;">추천수 TOP 리뷰</span><hr></div>
		<c:forEach var="list" items="${list }">
			<a href="/board/detail?id=${list.id }&ref=${list.ref }" style="text-decoration: none;"><c:out value="${list.title }"/>
			<c:choose>
					<c:when test="${list.answerNum != 0}">
						<span style="color: #c73841">[${list.answerNum}]</span>
					</c:when>
			</c:choose>
			</a><br><hr>
		</c:forEach>
	</div>
	</div>
</div>
<script>

new Swiper('.swiper1', {
	effect : 'fade', // 페이드 효과 사용
	loop : true, //무한루프
	autoplay : { // 자동 재생
		delay : 5000, // 딜레이
	},
	pagination : { // 페이징 설정
		el : '.swiper-pagination',
		clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
	}
});

</script>
<c:import url="default/footer.jsp"/>
</body>
</html>
