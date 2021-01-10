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
	.btnGreen01 { 
		display:inline-block; 
		width:150px; 
		height:30px; 
		padding:2px 0;
		border-radius: 1pt;
		border-color: #262626; 
		text-align:center; 
		font-family:NGBold; 
		font-size:15px; 
		color:#fff; 
		background: #069370; 
	}
	.title {
		width: 99%; 
		height: 20px;
	}
</style>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<div align="center" style="padding:50px;">
	<h1>리뷰 작성하기</h1>
	<hr>
		<form id="registerForm">
			<input type="text" name="title" class="title" placeholder="제목">
			<hr>
			<textarea name="input" id="input" placeholder="내용">
			방문지 : 
			<a href="http://localhost:8081/tour/tourdetail?contentid=<%=request.getParameter("contentId") %>&contenttypeid=<%=request.getParameter("contentTypeId") %>"><%=request.getParameter("title") %></a>
			</textarea><br>	
			<input type="hidden" id="content" name="content">		
			<input type="hidden" id="contentId" name="contentId">
			<input type="hidden" id="contentTypeId" name="contentTypeId">
 			<input type="button" value="작성하기" onclick="register()" class="btnGreen01">
		</form>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
<script src="/resources/js/ckeditor/ckeditor.js"></script>
<script>CKEDITOR.replace('input',{
		filebrowserUploadUrl:'/fileUpload',
		height : '500px'
		});</script>
<script>
function register(){
	var contentId = "${contentId }";
	var contentTypeId = "${contentTypeId }";
	document.getElementById("contentId").value = contentId;
	document.getElementById("contentTypeId").value = contentTypeId;
	
	if(contentId == "" || contentTypeId == ""){
		contentId = 0;
		contentTypeId = 0;
	}
	
	var content = CKEDITOR.instances.input.getData();
	document.getElementById("content").value = content;
	var result = 0;
	$.ajax({
		url : "/board/register",
		type : "POST",
		cache : false,
		async : false,
		dataType : "JSON",
		data : $("#registerForm").serialize(),
		success : function(data)	{
			if(data === 1){
				self.location="/board/list";
			}else{
				alert("게시물 등록에 실패하였습니다.");
			}
		},
		error : function(data){
			alert("서버에러!");
		} 
	});
}
</script>
</html>