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
		<div>
			<ul id="wishList">
			</ul>
		</div>	
	</div>
	<input type="button" value="초기화 하기" onclick="initRecentList();">
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
			str += "<div><a href='/tour/tourdetail?contentid="+wishItem.contentid+"&contenttypeid="+wishItem.contenttypeid+"'><img src='"+wishItem.firstimage+"' width='300'/><br>";
			str += "<li>"+wishItem.title+"</li><br>";
			str += "<li>"+wishItem.overview+"</li><br>";
			str += "<li>"+wishItem.modifiedtime+"</li><br></a></div>";
			wishList.html(str);
		});
	}
});
</script>
</html>
