<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:import url="../default/detailHeader.jsp"></c:import>
	<h1>내 일정</h1>
	<form>
		<input type="date" id="start">
		<input type="date" id="end">
	</form>
	<input type="button" onclick="getContent();" value="추가하기">
	
	<div id="content">
	</div>
<c:import url="../default/footer.jsp"></c:import>
</body>
<script>
	function getContent(){
		console.log("컨텐츠 추가");
		var startTime = document.getElementById("start").value;
		var endTime = document.getElementById("end").value;
		var content = document.getElementById("content");
		
		var newDIV = document.createElement("div");
		var txt = document.createTextNode("test");
		newDIV.appendChild(txt);
		
		content.appendChild(newDIV);
		console.log(newDIV);
		
	}
</script>
</html>
