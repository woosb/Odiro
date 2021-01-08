<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<script>
// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
	$("#user_nick").blur(function() {
		var user_nick = $('#user_nick').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/member/nickCheck?userNick='+ user_nick,
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : "+ data);							
				
				if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#nick_check").text("사용중인 닉네임입니다 :p");
						$("#nick_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
						
						if(idJ.test(user_nick)){
							// 0 : 아이디 길이 / 문자열 검사
							$("#nick_check").text("");
							$("#reg_submit").attr("disabled", false);
				`
						} else if(user_nick == ""){
							
							$('#nick_check').text('닉네임을 입력해주세요 :)');
							$('#nick_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);				
							
						} 
						
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});
</script>
<body>
<c:import url="../default/detailHeader.jsp"></c:import>
	<div align="center">
		<h1>내 정보</h1>
	</div>
	<form action="update" method="post">
		<div class="form-group">
		닉네임 : <input type="text" class="form-control" id="user_nick" name="user_nick" placeholder="ID" required>
		<div class="check_font" id="nick_check"></div>
		<button type="submit">닉네임 변경</button>
	</form>
<c:import url="../default/footer.jsp"></c:import>
</body>
<script type="text/javascript" src="/resources/js/memberDetail.js"></script>
<script>
</script>
</html>
