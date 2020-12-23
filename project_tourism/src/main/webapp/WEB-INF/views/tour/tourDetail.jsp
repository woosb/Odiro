<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 정보</title>
</head>
<body>
	<c:import url="../default/header.jsp"/>
		
		<div style="width: 25%; align-content: left;">
			<img style="height: 600px; width: 600px;"onerror="this.src='/resources/images/noimage.png'" src="${map.info.firstimage }">
		</div>
		${map.info.title }<br>
		${map.info.createdtime }<br>
		${map.info.modifiedtime}<br>
		${map.info.mapx}<br>
		${map.info.mapy}<br>
		${map.info.mlevel}<br>
		${map.info.addr1}<br>
		${map.info.tel}<br>
		${map.info.homepage}<br>
		${map.info.overview}<br>
		
		
		<input type="button" value="즐겨찾기 추가" onclick="addWishList();">
	<c:import url="../default/footer.jsp"/>
</body>
<script>
	var contentId = "${contentid}";
	var contentTypeId = "${contenttypeid}"
	var list = {contentId : contentId, contentTypeId: contentTypeId}
	function addWishList(){
		console.log(list);
		$.ajax({
			url:"/memberDetail/addWishList",
			type:"POST",
			data: JSON.stringify(list),
	        contentType: "application/json",
			success : function(data){
				alert(data);
			}
		});
	}
</script>
</html>