<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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
		width:120px; 
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
</style>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div align="center">
	<h1>글 내용</h1>
	<table>
		<tr>
			<th>제목</th>
			<td>${detail.title}</td>
			<th>글쓴이</th>
			<td>${detail.userId}</td>
			<th>조회수</th>
			<td>${detail.hit}</td>
			<th>추천</th>
			<td>${detail.recommend}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="7">${detail.content }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td colspan="7">
			<fmt:formatDate value="${detail.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td colspan="7">
			<fmt:formatDate value="${detail.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<th colspan="8" style="background-color: #069370; color: white;">댓글보기</th>
		</tr>
		<c:forEach var = "reply" items="${reply }" >
		<c:choose>
		<c:when test = "${reply.step eq 1 }">
		<tr>
			<th><c:out value="${reply.userId }"/></th>
			<td colspan="5">
				<c:out value="${reply.content}"/>
			</td>
			<td colspan="2" align="center"><fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		</c:when>
		<c:when test = "${reply.step > 1 }">
		<tr>
			<th><c:out value="${reply.userId }"/></th>
			<td>
				<c:forEach var="i" begin="1" end="${reply.step-1}">
					->re
				</c:forEach>
			</td>
			
			<td>
				<a href="/board/rereply?ref=${reply.ref }&parentNum=${reply.id }&refOrder=${reply.refOrder}&step=${reply.step}&detailId=${detail.id}" onclick="insertReply()">
					<c:out value="${reply.content}"/>
				</a>
			</td>
			<td><fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>id : <c:out value="${reply.id}"/></td>
			<td>ref : <c:out value="${reply.ref}"/></td>
			<td>step : <c:out value="${reply.step}"/></td>
			<td>refOrder : <c:out value="${reply.refOrder}"/></td>
			<td>asNum : <c:out value="${reply.answerNum}"/></td>
			<td>prNum : <c:out value="${reply.parentNum}"/></td>
		</tr>
		</c:when>
		</c:choose>	
		</c:forEach>
	</table>
	<br>
	<c:if test="${sessionScope.nick==detail.userId || sessionScope.nick=='관리자'}">
	<button onclick="self.location='/board/delete?ref='+${detail.ref}" class="btnGreen01">삭제</button>
	<button onclick="self.location='/board/modify?id='+${detail.id}" class="btnGreen01">수정</button>
	</c:if>
	<button onclick="self.location='/board/list'" class="btnGreen02">뒤로가기</button>
	<button onclick="self.location='/board/recommend?id=${detail.id}'" class="btnGreen02">추천하기</button>
	<form action="/board/reply" method="post">
		<br>댓글달기 : <input type="text" name="content" style="width: 350px;">
		<input type="hidden" value="${detail.id }" name="id">
		<input type="hidden" value="${detail.ref }" name="ref">
		<input type="hidden" value="${detail.step }" name="step">
		<input type="hidden" value="${detail.refOrder }" name="refOrder">
		<input type="hidden" value="${detail.answerNum }" name="answerNum">
		<input type="hidden" value="${detail.parentNum }" name="parentNum">
		<input type="submit" class="btnGreen01">
	</form>
</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>