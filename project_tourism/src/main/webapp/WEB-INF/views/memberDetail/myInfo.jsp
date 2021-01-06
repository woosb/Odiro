<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:import url="../default/detailHeader.jsp"></c:import>
	<h1>내 정보</h1>
	<form action="update">
		<div class="form-group">
		닉네임 : <input type="text" class="form-control" id="user_nick" name="user_nick" placeholder="ID" required>
		<div class="check_font" id="nick_check"></div>
		<button type="submit">닉네임 변경</button>
	</form>
<c:import url="../default/footer.jsp"></c:import>
</body>
<script type="text/javascript" src="/resources/js/memberDetail.js"></script>
<script>
</script>
</html>
