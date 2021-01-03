<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<style type="text/css">
	body {
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
	}
	.btnGreen { 
		display:inline-block; 
		width:50px; 
		height:24px; 
		padding:2px 0;
		border-radius: 1pt;
		border-color: #262626; 
		text-align:center; 
		font-family:NGBold; 
		font-size:12px; 
		color:#fff; 
		background: #069370; 
	}
	.btnGreen1 { 
		display:inline-block; 
		width:100px; 
		height:24px; 
		padding:2px 0;
		border-radius: 1pt;
		border-color: #262626; 
		text-align:center; 
		font-family:NGBold; 
		font-size:12px; 
		color:#fff; 
		background: #069370; 
	}
</style>
<body>
<c:import url="../default/detailHeader.jsp"></c:import>
	<div align="center">
		<h1>최근 본 관광지</h1>
		<div>
			<ul id="wishList">
			</ul>
		</div>	
	</div>
	<div style="display: flex; justify-content: center; align-items: center;">
		<input type="button" value="초기화 하기" onclick="initRecentList();" class="btnGreen1">
	</div>
<c:import url="../default/footer.jsp"></c:import>
</body>
<script type="text/javascript" src="/resources/js/memberDetail.js"></script>
<script>
$(document).ready(function(){
	var list = [
			<c:forEach items="${recent}" var="i" >
				{
					e_mail : "${i.e_mail}",
					contentId : "${i.contentId}",
					contentTypeId : "${i.contentTypeId}"},
			</c:forEach>
		];
	
	console.log(list);
	console.log("${recent}");
	wishList = $("#wishList");
	var str = "";	
	for(var i = 0; i < list.length; i++){
		var url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?serviceKey=VPzeVba%2BnwCg8Jc3LPiuwaHTj4TMO8InVJsZ%2BQNWQzHjERgDCJqB203xxvuS9RY6dtlXBaz%2BPagLP97uhsVD2g%3D%3D&MobileOS=ETC&MobileApp=AppTest&defaultYN=Y&firstImageYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&contentId="+list[i].contentId+"&contentTypeId="+list[i].contentTypeId;
		getDetail.getAPIList(url, function(data){
			var wishItem = data.response.body.items.item;
				str += "<li style='overflow: hidden; min-height: 120px; max-width: 1100px; border: 2px solid #069370;'>"
				str += "<div style='width: 5%; float: left; min-height: 130px; margin-right: 10px; text-align: center; vertical-align: middle;'></div>"
				str += "<div style='float: left; width:80%;'><a href='/tour/tourdetail?contentid="+wishItem.contentid+"&contenttypeid="+wishItem.contenttypeid+"' style='display: block; text-decoration: none;'>"
				str += "<img src='"+wishItem.firstimage+"' style='height: 110px; width: 85px; float:left; margin: 5px 20px 10px 0; vertical-align: middle; border: 0px;' onerror='this.src='/resources/images/noimage.png''/>";
				str += "<dl style='display: block; margin: 20px 0 0 10px; padding:0;'>"
				str += '<dt style="margin-bottom: 8px; font-size: 14px; color:#333; letter-spacing: -1px; font-weight: bold;">'+wishItem.title+'</dt>'
				str += "<dd><p>"+wishItem.addr1+"</p></dd>";
				str += "<dd><p>"+wishItem.tel+"</p></dd></dl></a></div></li>";
				str += "<br>";
			wishList.html(str);
		});
	}
});
</script>
</html>
