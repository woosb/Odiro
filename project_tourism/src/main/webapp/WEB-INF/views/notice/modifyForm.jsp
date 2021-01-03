<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script src="/resources/js/ckeditor/ckeditor.js"></script>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<div>
		<div>
			<h3>공지사항 글 수정</h3>
			<hr>
		</div>
		<form action="modifyOk" method="post">
		<div>
			<input type="text" name="notice_no" value="${contentView.notice_no }" hidden="hidden">
			<input type="text" name="notice_title" placeholder="제목을 입력하세요" value="${contentView.notice_title }" class="title">
			<hr>
		</div>
		<div>
			<textarea name="notice_content"placeholder="내용 입력" id="editor4">${contentView.notice_content }</textarea>
			<script>CKEDITOR.replace('editor4',{filebrowserUploadUrl:'imageUpload'});</script>
			<hr>
		</div>
		<div style='text-align: center;'>
			<input type="submit" value="수정하기" class="btnGreen01">
		</div>
		</form>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>