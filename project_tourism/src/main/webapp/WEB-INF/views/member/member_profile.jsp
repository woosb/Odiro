<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
</head>
<body>
 <c:import url="../default/header.jsp"/>
        <br>
        <br>
        <br>
<c:if test = "${map.list != null}">
	<span style="color: green; font-weight: bold;">나의 프로필</span> <br> <br>
	<div align="center">
		<table border="1" width="300" height="250">
		<tr>        
		    <td>
		        <div>    
					<c:forEach var = "member" items = "${map.list}"><!-- 컨트롤러에서 넘어온 map의 값 --> 
					               이메일 : ${member.e_mail} <br><br>    
					</c:forEach>
		         </div>                        
		    </td>
		</tr>
		</table> 
	</div>
</c:if>
 
<c:import url="../default/footer.jsp"/>
</body>
</html>
