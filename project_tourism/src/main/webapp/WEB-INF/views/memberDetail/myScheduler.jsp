<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
    table
    {
        border:1px solid #BDBDBD;
        text-align:center;
        width:30%;
    }
</style>
<body onload="build();">
<c:import url="../default/detailHeader.jsp"></c:import>
<div align="center">
	<h1>내 일정</h1>
	<table align="center" id="calendar">
        <tr>
            <td><font size=1%; color="#B3B6B3"><label onclick="beforem()" id="before" ></label></font></td>
            <td colspan="5" align="center" id="yearmonth"></td>
            <td><font size=1%; color="#B3B6B3"><label onclick="nextm()" id="next"></label></font></td>
        </tr>
        <tr>
            <td align="center"> <font color="#FF9090">일</font></td>
            <td align="center"> 월 </td>
            <td align="center"> 화 </td>
            <td align="center"> 수 </td>
            <td align="center"> 목 </td>
            <td align="center"> 금 </td>
            <td align="center"><font color=#7ED5E4>토</font></td>
        </tr>
    </table>
	<br><br>
	<form id="addSchedul">
		<input type="date" name="startTime" id="start">
		<input type="date" name="endTime" id="end">
		<input type="text" name="contents" id="text">
	</form>
	<input type="button" onclick="getContent();" value="추가하기">
	<table id="content" style="width:100%">
		<tr>
			<td>start</td>
			<td>end</td>
			<td>text</td>
		</tr>
	</table>
	
	
</div>
<c:import url="../default/footer.jsp"></c:import>
</body>
<script>
	function getList(){
		var schedulData = "";
		$.ajax({
			type:"GET",
			url:"/memberDetail/getSchedul",
			dataType:"json"
		})
		.done(function(result){
				for(var i = 0; i < result.length; i++){
					schedulData += "<tr>";
					schedulData += "<td>"+result[i].startTime+"</td>";
					schedulData += "<td>"+result[i].endTime+"</td>";
					schedulData += "<td>"+result[i].contents+"</td>";
					schedulData += "<td><input type='button' value='CLICK ME' onclick='remove(this.parentElement.parentElement, "+result[i].schedulId+");'/></td>";
					schedulData += "</tr>";
				}
				var content = document.getElementById("content").innerHTML = schedulData;
		})
		.fail(function(){
		});
	}
	
    var today = new Date(); // 오늘 날짜
    var date = new Date();
 
    function beforem() //이전 달을 today에 값을 저장
    { 
        today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
        build(); //만들기
    }
    
    function nextm()  //다음 달을 today에 저장
    {
        today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
        build();
    }
    
    function build()
    {
        var nMonth = new Date(today.getFullYear(), today.getMonth(), 1); //현재달의 첫째 날
        var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0); //현재 달의 마지막 날
        var tbcal = document.getElementById("calendar"); // 테이블 달력을 만들 테이블
        var yearmonth = document.getElementById("yearmonth"); //  년도와 월 출력할곳
        yearmonth.innerHTML = today.getFullYear() + "년 "+ (today.getMonth() + 1) + "월"; //년도와 월 출력
        
        if(today.getMonth()+1==12) //  눌렀을 때 월이 넘어가는 곳
        {
            before.innerHTML=(today.getMonth())+"월";
            next.innerHTML="1월";
        }
        else if(today.getMonth()+1==1) //  1월 일 때
        {
        before.innerHTML="12월";
        next.innerHTML=(today.getMonth()+2)+"월";
        }
        else //   12월 일 때
        {
            before.innerHTML=(today.getMonth())+"월";
            next.innerHTML=(today.getMonth()+2)+"월";
        }
        
       
        // 남은 테이블 줄 삭제
        while (tbcal.rows.length > 2) 
        {
            tbcal.deleteRow(tbcal.rows.length - 1);
        }
        var row = null;
        row = tbcal.insertRow();
        var cnt = 0;
 
        // 1일 시작칸 찾기
        for (i = 0; i < nMonth.getDay(); i++) 
        {
            cell = row.insertCell();
            cnt = cnt + 1;
        }
 
        // 달력 출력
        for (i = 1; i <= lastDate.getDate(); i++) // 1일부터 마지막 일까지
        { 
            cell = row.insertCell();
            cell.innerHTML = i;
            cnt = cnt + 1;
            if (cnt % 7 == 1) {//일요일 계산
                cell.innerHTML = "<font color=#FF9090>" + i//일요일에 색
            }
            if (cnt % 7 == 0) { // 1주일이 7일 이므로 토요일 계산
                cell.innerHTML = "<font color=#7ED5E4>" + i//토요일에 색
                row = calendar.insertRow();// 줄 추가
            }
            if(today.getFullYear()==date.getFullYear()&&today.getMonth()==date.getMonth()&&i==date.getDate()) 
            {
                cell.bgColor = "#BCF1B1"; //오늘날짜배경색
            }
        }
        getList();
    }
</script>
<script>
	function getContent(){
		var startTime = document.getElementById("start").value;
		var endTime = document.getElementById("end").value;
		var text = document.getElementById("text").value;
		
		var content = document.getElementById("content");
		var newTR = document.createElement("tr");
		var startTD = document.createElement("td");
		var endTD = document.createElement("td");
		var textTD = document.createElement("td");
		var start = document.createTextNode(startTime);
		var end = document.createTextNode(endTime);
		var text = document.createTextNode(text);
		
		startTD.appendChild(start);
		endTD.appendChild(end);
		textTD.appendChild(text);
		
		newTR.appendChild(startTD);
		newTR.appendChild(endTD);
		newTR.appendChild(textTD);
		content.appendChild(newTR);
		
		var btn = document.createElement("BUTTON");  
		btn.innerHTML = "CLICK ME"; 
		btn.addEventListener('click', function(event) {
			this.parentElement.remove();
		});
		
		newTR.appendChild(btn);

		$.ajax({
			url : "/memberDetail/addSchedul",
			type : "POST",
			cache : false,
			async : false,
			dataType : "JSON",
			data : $("#addSchedul").serialize(),
			success : function(data)	{
				if(data == 0){
					alert("일정 등록에 실패하였습니다.");
				}
			},
			error : function(data){
				alert("서버에러!");
			} 
		});
		
		$('#text').val('');
        getList();
	}
	
	function remove(tr, id){
		tr.remove();
		console.log(id);
		$.ajax({
			url:'/memberDetail/deleteSchedul/'+id,
			type : "Delete",
			cache : false,
			async : false,
			success : function(data)	{
				
			},
			error : function(data){
				alert("서버에러!");
			} 
		});
        getList();
	}
</script>
</html>
