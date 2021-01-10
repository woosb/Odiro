<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<c:import url="../default/detailHeader.jsp"></c:import>
	<div align="center">
		<h1>비밀번호 확인</h1>
	
		<form action="pw_check" method="post">
		비밀번호 : <input type="password" class="form-control" id="user_pass" name="user_pass" placeholder="PW" required>
		<br>
		<br>
		<button type="submit" class="btnGreen01">비밀번호 확인</button>
	</form>
	</div>
	<c:import url="../default/footer.jsp"></c:import>
</body>
</html>