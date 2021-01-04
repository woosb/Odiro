<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
	.cal{
		width : 30px;
		height : 30px;	
		background-color:green;
		color:white;
		padding: 10px;
		
	}
</style>
<body>
<c:import url="../default/detailHeader.jsp"></c:import>
<div align="center">
	<h1>내 일정</h1>
	<div id="calendar">
	</div>
	
	<div style="margin: 0 auto; padding:40px; background-color:skyblue;">
		<div style="display:flex; ">
			<div class="cal"><span>일</span></div>
			<div class="cal"><span>월</span></div>
			<div class="cal"><span>화</span></div>
			<div class="cal"><span>수</span></div>
			<div class="cal"><span>목</span></div>
			<div class="cal"><span>금</span></div>
			<div class="cal"><span>토</span></div>
		</div>
		<div style="display:flex; ">
			<div class="cal"><span>1</span></div>
			<div class="cal"><span>2</span></div>
			<div class="cal"><span>3</span></div>
			<div class="cal"><span>4</span></div>
			<div class="cal"><span>5</span></div>
			<div class="cal"><span>6</span></div>
			<div class="cal"><span>7</span></div>
		</div>
	</div>
	
	
	<form>
		<input type="date" id="start">
		<input type="date" id="end">
		<input type="text" id="text">
	</form>
	<input type="button" onclick="getContent();" value="추가하기">
	
	<div id="content">
	</div>
</div>
<c:import url="../default/footer.jsp"></c:import>
</body>
<script>
//2020년 1월 1일 수요일
//2020년 1월 8일 수요일
//2020년 3월 3일 = 31 + 29 + 3 = 63
//각 요일은 7로 나누어서 나머지 값이 day배열의 인덱스 이다.
	const noLeap = [31,28,31,30,31,30,31,31,30,31,30,31];
	const leap   = [31,29,31,30,31,30,31,31,30,31,30,31];
	var weeks = ['sun', 'mon', 'tue', 'wed', 'thu', 'fri','sat'];
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth();
	var day = today.getDate();

// 	var year = 2021;
// 	var month = 5;
	if(isLeapYear(year)){	
		var monthList = leap;	
	}else{
		var monthList= noLeap;
	}

	var sum = 0;
	for(var i = 2020; i< year; i++){
		if(isLeapYear(i)){
			sum += 366;
		}else{
			sum += 365;
		}
	}
	for(var j = 0; j < month-1; j++){
		sum += monthList[j];
	}
	
	// 	console.log(sum);
	// 해당 달의 1일의 요일
	var index = (sum%7+3)%7;
	
	var str = "";
	for(var i = 0; i < index; i++){
		str += '<div class="cal">x</div>';
	}
	for(var i = 0; i < monthList[month]; i ++){
		if( (index+i)%7 == 0 ){
			str += '<br>';
		}
		str += '<div class="cal">'+(i+1)+'</div>';
	}
	
	console.log(str);	
	
	var calendar = document.getElementById("calendar");
	calendar.innerHTML=str;
	
	function isLeapYear(year){
		var flag = false;
		if(year%4==0) flag = true;
		if(year%100 == 0) flag = false;
		if(year%400 == 0) flag = true;
		return flag;
	}
</script>
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
