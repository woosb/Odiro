<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<body>
<script type="text/javascript">
var naver_id_login = new naver_id_login("eiAQbH1r7I4HCKucdQLe", "http://localhost:8081/member/login"); // 역시 마찬가지로 'localhost'가 포함된 CallBack URL

// 접근 토큰 값 출력

// 네이버 사용자 프로필 조회
naver_id_login.get_naver_userprofile("naverSignInCallback()");

// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
function naverSignInCallback() {
	document.getElementById('e_mail').value = naver_id_login.getProfileData('email'); 
	document.getElementById('nick').value = naver_id_login.getProfileData('nickname'); 
}
</script>
<form action ="/member/login.do" method = "post">
<c:import url="../default/header.jsp"/>
<center>
<br>
아이디 : <input type = "text" name="e_mail" id="e_mail" readonly /><br><br>
닉네임 : <input type = "text" name="nick" id="nick" readonly /><br><br>
<button type = "submit" name = "submit" class="btnGreen01" >나의 프로필 확인</button><br><br>
<c:import url="../default/footer.jsp"/>
</body>
</html>