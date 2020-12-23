<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
	#mainLogo{
		font-size: 50px; color: orange; font-weight: bold; font-family: fantasy;
	}
	
	.head a:link { 
		color: white; text-decoration: none;
	}
 	.head a:visited { 
 		color: white; text-decoration: none;
 	}
	.head a:hover {
 		 color: white; text-decoration: underline;
 	}
 	
 	ul li {
 		list-style: none; display: inline;
 		margin-right: 20px;
 		margin-top : 5px;
 	}
</style>
<body>
<div style=" height : 200px; background-color: skyblue; padding-top:10px;">
	<span id="mainLogo"><a href="/">CARELAB</a></span>
<!-- 	<div style="right= 10px; float:right;"> -->
	<div class="head" style="text-align: right; font-size: 22px; background-color:#4d4d4d; height: 35px;">
		<ul>
			<li><a href>숙소예약내역</a></li>
			<li><a href="">나의 리뷰</a></li>
			<li><a href="/memberDetail/myWishList">찜 목록</a></li>
			<li><a href>최근 본 숙소</a></li>
			<li><a href>내 정보 관리</a></li>
		</ul>
	</div>
	<h1>내정보</h1>
</div>
</body>
</html>
