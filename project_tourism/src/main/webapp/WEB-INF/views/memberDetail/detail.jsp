<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
	
</style>
<body>
<c:import url="../default/detailHeader.jsp"></c:import>
	<div align="center">
		<h1>${sessionScope.e_mail }</h1>	
	</div>
<c:import url="../default/footer.jsp"></c:import>
</body>
</html>
