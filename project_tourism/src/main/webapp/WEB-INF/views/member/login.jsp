<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
 <style type="text/css">
	body {
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
	}
	.btnGreen01 { 
		display:inline-block; 
		width:130px; 
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
 <c:import url="../default/header.jsp"/>
<body class="loginBody">
<br>
<!-- 세션에 id값이 저장되어 있는 경우 로그아웃 버튼과 로그인한 아이디가 출력되도록 코드를 작성함 -->
<c:if test = "${sessionScope.e_mail != null}">
 
(일반)${sessionScope.nick}님이 로그인 하셨습니다. <br><br>
<form action = "/memberDetail/detail" method = "get">
<button type = "submit" name = "submit" class="btnGreen01">나의 프로필 확인</button></form><br><br>
 
 
</c:if>
 
 
<c:if test = "${sessionScope.navername != null}">
 
(네이버)${sessionScope.navername}님이 로그인 하셨습니다.<br><br>
<form action = "/memberDetail/detail" method = "post">
<button type = "submit" name = "submit" class="btnGreen01">나의 프로필 확인</button></form><br><br>
 
</c:if>
 
<c:if test = "${sessionScope.kakaonickname != null}">
 
(카카오톡)${sessionScope.kakaonickname}님이 로그인 하셨습니다.<br><br>
<form action = "authentication.do" method = "post">
<button type = "submit" name = "submit">회원 인증하기 (인증을 해야 각종 기능들 사용 가능)</button></form><br><br>
 
<form action = "/memberDetail/detail" method = "post">
<button type = "submit" name = "submit" class="btnGreen01">나의 프로필 확인</button></form><br><br>
 
</c:if>
 
 
<c:if test = "${sessionScope.admin_id != null}">
 
(관리자)${sessionScope.admin_id}님이 로그인 하셨습니다.<br><br>
<form action = "/memberDetail/detail" method = "post">
<button type = "submit" name = "submit" class="btnGreen01">나의 프로필 확인</button></form><br><br>
 
</c:if>
 
 
 
 
<c:if test = "${sessionScope.e_mail == null and sessionScope.navername == null and sessionScope.kakaonickname == null and sessionScope.facebookname == null and sessionScope.admin_id == null}">
 
<%
//url로 보낸 아이디를 세션에 저장하기 위해 변수에 저장함
String navername = request.getParameter("navername");
String kakaonickname = request.getParameter("kakaonickname");
String facebookname = request.getParameter("facebookname");
String normalname = request.getParameter("user_id");
String admin_id = request.getParameter("admin_id");
 
 
//url로 보낸 이메일를 세션에 저장하기 위해 변수에 저장함
String navere_mail = request.getParameter("navername");
String kakaoe_mail = request.getParameter("kakaonickname");
String facebooke_mail = request.getParameter("facebookname");
 
%>    
 
 
<%
//아이디를 세션에 저장
session.setAttribute("navername", navername);
session.setAttribute("kakaonickname", kakaonickname);
session.setAttribute("facebookname", facebookname);
session.setAttribute("normalname", normalname);
session.setAttribute("admin_id", admin_id);
 
 
//이메일을 세션에 저장
session.setAttribute("navere_mail", navere_mail);
session.setAttribute("kakaoe_mail", kakaoe_mail);
session.setAttribute("facebooke_mail", facebooke_mail);
 
 
if (navername == null && kakaonickname == null && facebookname == null && normalname == null && admin_id == null) {
    
%>
 
(guest)님 방문을 환영합니다.     <br>
                                <br>
                                
로그인을 하셔야 다른 기능을 정상적으로 이용하실 수 있습니다. <br>
        
    
<%
 
    } 
 
%>
    
    
    </c:if>
 <c:import url="../default/footer.jsp"/>
</body>
</html>
