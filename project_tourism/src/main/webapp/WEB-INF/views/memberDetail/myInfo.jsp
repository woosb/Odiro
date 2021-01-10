<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<script>
//이메일 입력값 검증
$('#user_nick').on('keyup', function(){
	console.log($(this).val());
	
	//공백확인
	if($('#user_nick').val() === ""){
		$('#nick_check').html('<i style="color: red" class="far fa-times-circle"></i>');
		chk1 = false;
	
	//이메일 유효성 검증
	} else if(!getMailCheck.test($('#user_nick').val())){
		
		$('#nick_check).html('<i style="color: red" class="far fa-times-circle"></i>');
		chk1 = false;
		
	//이메일 중복확인 비동기 처리
	} else {
		const email = $('#user_nick').val();
		$.ajax({
			type: "POST",
			url: "/member/nickCheck",
			headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "POST"
            },
            data: email,
            datatype: "json",
            success: function(data){
            	console.log(data);
            	if(data.confirm === "OK"){
            		$('#nick_check').html('<i style="color: #262626;" class="far fa-check-circle"></i>');
            		chk1 = true;
            	} else {
            		$('#nick_check').html('<i style="color: red" class="far fa-times-circle"></i>');
            		chk1 = false;
            	}
            },
            error: function(error){
            	console.log("error : " + error);
            }
		});
	}
});
</script>
 <style type="text/css">
	body {
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
	}
	.btnGreen01 { 
		display:inline-block; 
		width:100px; 
		height:25px; 
		padding:2px 0;
		border-radius: 0.5pt;
		border-color: #262626; 
		text-align:center; 
		font-family:NGBold; 
		font-size:13px; 
		color:#fff; 
		background: #069370; 
	}
</style>
<body>
<c:import url="../default/detailHeader.jsp"></c:import>
	<div align="center">
		<h1>닉네임 변경</h1>
	
		<form action="update" method="post">
		닉네임 : <input type="text" class="form-control" id="user_nick" name="user_nick" placeholder="ID" required>
		
		<div class="check_font" id="nick_check"></div>
		<br>
		<button type="submit" class="btnGreen01">닉네임 변경</button>
	</form>
	</div>
	<div align="center">
		<h1>비밀번호 변경</h1>
	
		<form action="pw_update" method="post">
		비밀번호 : <input type="password" class="form-control" id="user_pass" name="user_pass" placeholder="PW" required>
		<br>
		<br>
		<button type="submit" class="btnGreen01">비밀번호 변경</button>
	</form>
	<br>
	</div>
	<div align="center">
		<form action="delete" method="get">
		<button type="submit" class="btnGreen01">회원 탈퇴</button>
	</form>
	</div>
	
<c:import url="../default/footer.jsp"></c:import>
</body>
<script type="text/javascript" src="/resources/js/memberDetail.js"></script>
<script>
</script>
</html>
