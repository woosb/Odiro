<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
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
</head>
<body>
	<p style="font-size: 50px; color: orange; font-weight: bold; font-family: fantasy; text-align: center;">CARE LAB</p> 
		<div class="head" style="text-align: right; font-size: 22px; background-color:#4d4d4d; height: 35px;">
		<ul>
			<li>
				<a href="/spring/member/index" >HOME</a>
			</li>
			
			<li>
				<%if (session.getAttribute("id") == null) {%>
					<a href="/notice/noticeList">공지사항</a> 
				<%} else {%>
					<a href="/notice/noticeList">공지사항</a>
				<%} %>
			</li>
			
			<li>
				<%if (session.getAttribute("id") == null) {%>
					<a href="/board/list">게시판</a> 
				<%} else {%>
					<a href="/board/list">게시판</a>
				<%} %>
			</li>
			<li>
				<%if (session.getAttribute("id") == null) {%>
					<a href="">회원정보</a> 
				<%} else {%>
					<a href="">회원정보</a>
				<%} %>
			</li>
			
			<li>
				<%if (session.getAttribute("id") == null) {%>
					<a href="">로그보기</a> 
				<%} else {%>
					<a href="">로그보기</a>
				<%} %>
			</li>
			
			<li>
				<%if (session.getAttribute("id") == null) {%> 
					<a href="">로그인</a> 
				<%} else { %>
					<a href="">로그아웃
				<%} %></a>
			</li>
		</ul>
	</div>
		
		
</body>
</html>