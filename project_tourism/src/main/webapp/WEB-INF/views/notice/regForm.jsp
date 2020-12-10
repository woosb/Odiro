<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/ckeditor/ckeditor.js"></script>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<div>
		<div>
			<h3>공지사항 등록</h3>
			<hr>
		</div>
		<form action="regBoard" method="post">
		<div>
			<input type="text" name="notice_title" placeholder="제목을 입력하세요" class="title">
			<hr>
		</div>
		<div>
			<textarea name="notice_content"placeholder="내용 입력" id="editor4"></textarea>
			<script>CKEDITOR.replace('editor4',{filebrowserUploadUrl:'imageUpload'});</script>
			<hr>
		</div>
		<div>
			<input type="submit" value="글 등록">
		</div>
		</form>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>