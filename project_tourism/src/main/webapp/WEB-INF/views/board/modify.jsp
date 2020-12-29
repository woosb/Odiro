<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
	}
</style>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div align="center">
	<h1>글 내용</h1>
	<form id="registerForm">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${detail.title}"></td>
				<th>글쓴이</th>
				<td>${detail.userId}</td>
				<th>조회수</th>
				<td>${detail.hit}</td>
				<th>추천</th>
				<td>${detail.recommend}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="7"><textarea name="input"  style="width: 1000px;height: 100px;">${detail.content }</textarea></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td colspan="7">${detail.regDate}</td>
			</tr>
			<tr>
				<th>수정일</th>
				<td colspan="7">${detail.updateDate}</td>
			</tr>
			<tr>
				<th colspan="8">댓글</th>
			</tr>
		</table>
		<input type="hidden" name="content" id="content">
		<input type="hidden" name="id" value="${detail.id }">
		<input type="button" value="수정하기" onclick="modify()">
	</form>
	<br>
	<button onclick="self.location='/board/list'">뒤로가기</button>
</div>
<c:import url="../default/footer.jsp"/>
<script src="/resources/js/ckeditor/ckeditor.js"></script>
<script>CKEDITOR.replace('input',{filebrowserUploadUrl:'/fileUpload'});</script>
<script>
function modify(){
	var content = CKEDITOR.instances.input.getData();
	document.getElementById("content").value=content;
	
	$.ajax({
		url : "/board/modify",
		type : "POST",
		cache : false,
		async : false,
		dataType : "JSON",
		data : $("#registerForm").serialize(),
		success : function(data){
			if(data == 1){
				alert("수정 완료");
				self.location="/board/list";
			}else{
				alert("등록실패!");
			}
		},
		error : function(data){
			alert("서버에러!");
		} 
	});
}

</script>
</body>
</html>