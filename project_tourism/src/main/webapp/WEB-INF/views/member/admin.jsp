<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	body {
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
	}
	table {
    	width: 40%;
    	border-top: solid #444444;
    	border-collapse: collapse;
  	}
  	th, td {
    	border-bottom: 1px solid #444444;
    	padding: 10px;
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
<body>
	 <c:import url="../default/header.jsp"/>
	 <c:if test = "${map.list != null}">
 
 
<center>
 
<span style="color: green; font-weight: bold; font-size: 25px;">회원 관리</span> <br> <br>
 
<table border="1" width="300" height="250">
    
        <div style="text-align:center;">   
    <c:forEach var = "member" items = "${map.list}"><!-- 컨트롤러에서 넘어온 map의 값 --> 
    <c:if test = "${member.e_mail!='admin@naver.com'}">
    <tr>        
                <td>
                    
                    <center>
                    
                        <form action="delete" method="post"> 
                           	이메일 : <input type="email" name="e_mail" value="${member.e_mail}" readonly /><br><br>
                            비밀번호 : ${member.user_pass} <br><br>
                            닉네임 : ${member.nickName } <br><br>
                            <button type = "submit" name = "submit" class="btnGreen01">회원 강제 삭제</button>
                        </form>                        
                      
                        
                    </center>
                        
                    </td>
                </tr>
                </c:if>
                </div>
                </c:forEach>
            </table>
            </center>
 
</c:if>
	  <c:import url="../default/footer.jsp"/>
</body>
</html>