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
</style>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div align="center">
	<table>
		<colgroup>
				<col style="width:6%;">
				<col style="width:auto;">
				<col style="width:8%;">
				<col style="width:10%;">
				<col style="width:8%;">
				<col style="width:5%;">
		</colgroup>
		<tr>
			<th>번호</th>	
			<th>제목</th>	
			<th>글쓴이	</th>	
			<th>작성일</th>	
			<th>조회수</th>	
			<th>추천</th>	
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				<td style="text-align: center;"><c:out value="${list.id }"/></td>
				<td style="padding:25px;"><a href="/board/detail?id=${list.id }&ref=${list.ref }"><c:out value="${list.title }"/></a>
				<c:choose>
					<c:when test="${list.answerNum != 0}">
						<span style="color: #c73841">[${list.answerNum}]</span>
					</c:when>
				</c:choose>
				</td>
				<td style="text-align: center;"><c:out value="${list.userId }"/></td>
				<td style="text-align: center;">
				<fmt:formatDate value="${list.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				
				<td style="text-align: center;"><c:out value="${list.hit }"/></td>
				<td style="text-align: center;"><c:out value="${list.recommend }"/></td>
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
		<input type="submit" value="검색" class="btnGreen01">
	</form>
</div>
<c:import url="../default/footer.jsp"/>
</body>
</html>