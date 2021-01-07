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
	
	@media (max-width: 780px) {
		.menu-toggle {
			display: block;
			width: 40px;
			height: 40px;
			margin : 10px;
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
	<div class="toplogo">
			<a href="/">
				<img src="/resources/images/mainlogo.png" style="width: 120px; height: 110px; border: 0px; vertical-align: middle;">
			</a>
	</div>
	<header>
		<div class = "menu-toggle"></div>
			<nav>
				<ul>
					<li>
						<a href="/" class="active">HOME</a>
					</li>
					<li><a href="/memberDetail/myScheduler">일정관리</a></li>
					<li><a href="/memberDetail/myReview">나의 리뷰</a></li>
					<li><a href="/memberDetail/myWishList">찜 목록</a></li>
					<li><a href="/memberDetail/recentList">최근 본 관광지</a></li>
					<li><a href="/memberDetail/myInfo">닉네임 변경</a></li>
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
