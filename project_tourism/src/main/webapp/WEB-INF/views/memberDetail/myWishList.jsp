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
	<input type='button' onclick='getWishList();' value="새로고침" >
		<div>
			<ul id="wishList">
			</ul>
		</div>	
	</div>
<c:import url="../default/footer.jsp"></c:import>
</body>
<script type="text/javascript" src="/resources/js/memberDetail.js"></script>
<script>
function getWishList(){
	var path = "";
	getDetail.getMyWishList(path, function(data){
		var str = "";
		wishList = $("#wishList");
		for(var i = 0; i < data.length; i++){
			var contentId = data[i].contentId;
			var contentTypeId = data[i].contentTypeId;
			var url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?serviceKey=VPzeVba%2BnwCg8Jc3LPiuwaHTj4TMO8InVJsZ%2BQNWQzHjERgDCJqB203xxvuS9RY6dtlXBaz%2BPagLP97uhsVD2g%3D%3D&MobileOS=ETC&MobileApp=AppTest&defaultYN=Y&firstImageYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&contentId="+contentId+"&contentTypeId="+contentTypeId;
			getDetail.getAPIList(url, function(data){
				var wishItem = data.response.body.items.item;
				str += "<div><a href='/tour/tourdetail?contentid="+contentId+"&contenttypeid="+contentTypeId+"'><img src='"+wishItem.firstimage+"' width='300'/><br>";
				str += "<li>"+wishItem.title+"</li><br>";
				str += "<li>"+wishItem.overview+"</li><br>";
				str += "<li>"+wishItem.modifiedtime+"</li><br></a></div>";
				str += "<input type='button' value='삭제' onclick='del("+contentId+","+contentTypeId+")'><hr>";
				wishList.html(str);
			});
		}
	});
}

function del(contentId, contentTypeId){
	getDetail.deleteList(contentId, contentTypeId);
	getWishList();
}

$(document).ready(function(){
	getWishList();
});
</script>
</html>
