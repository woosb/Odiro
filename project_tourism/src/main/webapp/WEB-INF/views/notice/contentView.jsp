<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	table {
    	width: 100%;
    	border-top: solid #444444;
    	border-collapse: collapse;
  	}
  	th, td {
    	border-bottom: 1px solid #444444;
    	padding: 10px;
  	}
	
	.btnGreen01 { 
		display:inline-block; 
		width:60px; 
		height:25px; 
		padding:2px 0;
		border-radius: 0.5pt;
		border-color: #262626; 
		text-align:center; 
		font-family:NGBold; 
		font-size:13px; 
		color:#fff; 
		background: #069370; 
	}
	.btnGreen02 { 
		display:inline-block; 
		width:80px; 
		height:25px; 
		padding:2px 0;
		border-radius: 0.5pt;
		border-color: #262626; 
		text-align:center; 
		font-family:NGBold; 
		font-size:13px; 
		color:#fff; 
		background: #069370; 
	}
	.title {
		width: 99%; 
		height: 20px;
	}
</style>
<script src="/resources/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	function getList() {
		location.href="noticeList";	
	}
	function modi() {
		location.href="modifyForm?no=${contentView.notice_no }";	
	}
	function del() {
		location.href="delete?no=${contentView.notice_no }";	
	}
	
</script>
</head>
<body>
	<c:import url="../default/header.jsp"/>
<div align="center">
	<h1>글 내용</h1>
	<table border="1">
		<colgroup>
			<col style="width:10%;">
			<col style="width:auto;">
			<col style="width:10%;">
			<col style="width:5%;">
		</colgroup>
		
		<tr>
			<th>제목</th>
			<td>${contentView.notice_title}</td>
			<th>조회수</th>
			<td><center>${contentView.notice_hit}</center></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				${contentView.notice_content }
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td colspan="3"><fmt:formatDate value="${contentView.notice_reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<c:choose>
			<c:when test="${contentView.notice_upt_date ne null}">
				<th>수정일</th>
				<td colspan="3"><fmt:formatDate value="${contentView.notice_upt_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</c:when>
		</c:choose>
		<tr>
			<td colspan="4" style="text-align: right;"> <!-- 관리자로 접근했을때 이 곳 활성화되도록 추후 수정 -->
				<input type="button" value="목록보기" onclick="getList()" class="btnGreen02"/>
				<% if (session.getAttribute("e_mail") == null) {%>
					
				<%} else if (session.getAttribute("e_mail").equals("admin@naver.com")){%>
					<input type="button" value="수정" onclick="modi()" class="btnGreen01"/>
					<input type="button" value="삭제" onclick="del()" class="btnGreen01"/>
				<%} %>
			</td>
		</tr>
	</table>
</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>