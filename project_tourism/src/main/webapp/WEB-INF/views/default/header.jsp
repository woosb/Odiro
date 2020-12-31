<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
	header {
		position : relative;
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
		background: #4d4d4d;
		box-sizing: border-box;
		border-radius: 4px;
		box-shadow: 0 2px 5px rgba(0,0,0,.2);
	}
	
	nav {
		float: right;
		font-family: sans-serif;
	}
	.clearfix {
		clear : both;
	}
	
	nav ul {
		margin : 0;
		padding : 0;
		display : flex;
	}
	nav ul li {
		color : #262626;
		list-style: none;
	}
	nav ul li a {
		display: block;
		margin : 10px 0;
		border-radius : 2px;
		padding: 10px 20px;
		text-decoration: none;
		color : white;
	}
	nav ul li a.active,
	nav ul li a:hover {
		background: #069370;
		color: #fff;
		transition : 0.5s;
	}
	@media (max-width: 690px) {
		.menu-toggle {
			display: block;
			width: 40px;
			height: 40px;
			margin : 20px;
			float: right;
			cursor: pointer;
			text-align: center;
			font-size: 30px;
			color : #069370;
		}
		.menu-toggle:before
		{
			content : '\f0c9' ;
			font-family: fontAwesome;
			line-height: 40px;
		}
		.menu-toggle.active:before
		{
			content : '\f00d' ;
		}
		nav {
			display: none;
		}
		nav.active {
			display: block;
			width: 100%;
		}
		nav.active ul {
			display: block;
			
		}
		nav.active ul li a{
			margin : 0;
		}
	}
</style>
</head>
<body>
<<<<<<< HEAD
	<p style="font-size: 50px; color: orange; font-weight: bold; font-family: fantasy; text-align: center;">CARE LAB</p> 
		<div class="head" style="text-align: right; font-size: 22px; background-color:#4d4d4d; height: 35px;">
		<ul>
			<li>
				<a href="/" >HOME</a>
			</li>
			
			<li>
				<%if (session.getAttribute("e_mail") == null) {%>
					<a href="/notice/noticeList">공지사항</a> 
				<%} else {%>
					<a href="/notice/noticeList">공지사항</a>
				<%} %>
			</li>
			
			<li>
				<%if (session.getAttribute("e_mail") == null) {%>
					<a href="/board/list">게시판</a> 
				<%} else {%>
					<a href="/board/list">게시판</a>
				<%} %>
			</li>
			
			<li>
				<%if (session.getAttribute("e_mail") == null) {%>
					<a href="/tour/tourList">관광정보 검색</a> 
				<%} else {%>
					<a href="/tour/tourList">관광정보 검색</a>
				<%} %>
			</li>
			
			<li>
				<%if (session.getAttribute("e_mail") == null) {%>
					<a href="/member/login">회원정보</a> 
				<%} else if (session.getAttribute("e_mail").equals("admin@naver.com")) {%>
					<a href="/member/admin">관리자 페이지</a> 
				<%} else {%>
					<a href="/memberDetail/detail">회원정보</a>
				<%} %>
			</li>
			
			<li>
				<%if (session.getAttribute("e_mail") == null) {%> 
					<a href="/member/login_form">로그인</a> 
				<%} else { %>
					<a href="/member/logout">로그아웃
				<%} %></a>
			</li>
		</ul>
=======
	<div class="toplogo">
			<a href="/">
				<img src="/resources/images/mainlogo.png" style="width: 120px; height: 110px; border: 0px; vertical-align: middle;">
			</a>
>>>>>>> dd186ee59f2eb96e89761826581ccc83a6d887a9
	</div>
	<header>
		<div class = "menu-toggle"></div>
			<nav>
				<ul>
					<li>
						<a href="/" class="active">HOME</a>
					</li>
					<li>
							<%if (session.getAttribute("e_mail") == null) {%>
								<a href="/notice/noticeList">공지사항</a> 
							<%} else {%>
								<a href="/notice/noticeList">공지사항</a>
							<%} %>
					</li>
					<li>
						<%if (session.getAttribute("e_mail") == null) {%>
							<a href="/board/list">리뷰 게시판</a> 
						<%} else {%>
							<a href="/board/list">리뷰 게시판</a>
						<%} %>
					</li>
					<li>
						<%if (session.getAttribute("e_mail") == null) {%>
							<a href="/tour/tourList">관광정보 검색</a> 
						<%} else {%>
							<a href="/tour/tourList">관광정보 검색</a>
						<%} %>
					</li>
					<li>
						<%if (session.getAttribute("e_mail") == null) {%>
							<a href="/member/login">회원정보</a> 
						<%} else {%>
							<a href="/memberDetail/detail">회원정보</a>
						<%} %>
					</li>
					<li>
						<%if (session.getAttribute("e_mail") == null) {%> 
							<a href="/member/login_form">로그인</a> 
						<%} else { %>
							<a href="/member/logout">로그아웃
						<%} %></a>
					</li>
				</ul>
			</nav>
			<div class="clearfix"></div>		
	</header>
	<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.menu-toggle').click(function(){
				$('.menu-toggle').toggleClass('active')
				$('nav').toggleClass('active')
			})
		})
	</script>
</body>
</html>

