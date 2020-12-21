<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../default/header.jsp"/>
<h1>관광지 목록</h1>
<div>
	<ul id="tourList">
	
	</ul>
</div>
<c:import url="../default/footer.jsp"/>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script type="text/javascript" src="/resources/js/tourAPI/tourAPI.js"></script>
<script>
	$(document).ready(function(){
		var url = "${url}";
// 		var url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=VPzeVba%2BnwCg8Jc3LPiuwaHTj4TMO8InVJsZ%2BQNWQzHjERgDCJqB203xxvuS9RY6dtlXBaz%2BPagLP97uhsVD2g%3D%3D&contentTypeId=12&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=12&pageNo=1&_type=json";
		get();
		function get(){
			getAPI.getList(url, function(data){
				console.log(data);
				var list = data.response.body.items.item;
				
				console.log("리스트 길이 : " + list.length);
				tourList = $("#tourList");
				var str = "";
				for(var i = 0; i < list.length; i++){
					str += "<img src='"+list[i].firstimage+"' width='300'/><br>";
					str += "<li>"+list[i].addr1+"</li><br>";
					str += "<li>"+list[i].tel+"</li><br>";
					str += "<li>"+list[i].title+"</li><br>";
					str += "<li>"+list[i].mapx+"</li><br>";
					str += "<li>"+list[i].mapy+"</li><br>";
					str += "<br>";
				}
				tourList.html(str);
			});
		}
	});
</script>
</html>