<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id" content="576736845363-o0474pib5q69qlcv6lm7o42hs6lu5u59.apps.googleusercontent.com">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name = "viewport" content = "user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0,
width=device-width" />
 <style type="text/css">
	body {
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
	}
	.btnGreen01 { 
		display:inline-block; 
		width:60px; 
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
	.btnGreen02 { 
		display:inline-block; 
		width:80px; 
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
	.btnGreen03 { 
		display:inline-block; 
		width:110px; 
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
	.btnGreen04 { 
		display:inline-block; 
		width:120px; 
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
</style>
</head>
 <c:import url="../default/header.jsp"/>
 
<table border="1" width="300" style="border-collapse: collapse; margin: auto;">
 
<tr>
<td>
<br>
<center>
<span style="color:green; font-weight : bold;">회원 로그인</span>
</center>
 
<!-- 로그인창 -->
<form action ="/member/login_form" method = "post">
<center>
<br>
아이디 : <input type = "text" name="e_mail" placeholder="  이메일을 입력하세요 "><br><br>
비밀번호 : <input type = "password" name="user_pass" placeholder="  비밀번호를 입력하세요 "><br><br>
<button type = "submit" name = "submit" class="btnGreen01" >로그인</button><br><br>
 <a href="/member/idfind" style="text-decoration: none;">아이디 찾기</a>&nbsp&nbsp<a href="/member/passwordFind" style="text-decoration: none;">비밀번호 찾기</a>
<br>
<br>
<div class = "row">
    <div class="col-xs-8">
        <div class="checkbox icheck">
        <label>
            <input type = "checkbox" name = "useCookie"> 로그인유지
        </label>
        </div>
    </div>
</div>
</center>
 
<center>
 
<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
</head>
<body>
<br>
<!-- 네이버아이디로로그인 버튼 노출 영역 -->
<div id="naverIdLogin"></div>
<!-- //네이버 아이디로 로그인 버튼 노출 영역 -->
 
<!-- 네이버 아이디로 로그인 초기화 Script -->
<script type="text/javascript">
    var naverLogin = new naver.LoginWithNaverId(
        {
            //클라이언트 id와 콜백 url (결과페이지)
            clientId: "eiAQbH1r7I4HCKucdQLe",
            callbackUrl: "http://localhost:8081/member/naverLogin",
            isPopup: false, /* 팝업을 통한 연동처리 여부 */
            loginButton: {color: "green", type: 3, height: 40} /* 로그인 버튼의 타입을 지정 */
            
        }
    );
    
    /* 설정정보를 초기화하고 연동을 준비 */
    naverLogin.init();
    
</script>
</center>
 
 
</center>
 
 
</form>
<br>
<!-- 회원가입 -->
<form action ="/member/email.do">
<center>
${e_mail = null}
<button class="btnGreen02">회원가입</button>
</center>
</form>
</td>
</tr>
<tr>
</tr>
</table>
<br>
 <c:import url="../default/footer.jsp"/>
 
<body>
<!-- 로그인 실패나 성공시 메시지를 받아서 출력하는 자바스크립트 구문 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    $(function(){
        var responseMessage = "<c:out value="${message}" />";
        if (responseMessage != ""){
            alert(responseMessage)
        }
    })
</script>
</body>
</html>
