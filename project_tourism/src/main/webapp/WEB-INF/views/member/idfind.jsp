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
<c:if test = "${e_mail == null}">
 <c:import url="../default/header.jsp"/>
 </c:if>
<table border="1" width="300" height="300" align= "center">
<center>
<span style="color: green; font-weight: bold;"></span> <br> <br>    
        <br> <br>
        <div style="text-align:center;">
            <tr>        
                <td>
                <center>
                <c:if test = "${e_mail == null}">
                        <div>
                        <form action="idfind" method="post">
                            닉네임 : <input type="nick" name="nick" placeholder="  닉네임을 입력하세요. "><br><br> 
                                
                                <button type="submit" name="submit" class="btnGreen01">아이디확인</button></form>
                        </div>                                                    
        </c:if>
        <c:if test = "${e_mail != null}">
 <div>
                    
                    <center>
                        <br>이메일 : ${e_mail}
                        <br> <br>
                        <a href="/member/login_form">로그인으로 가기</a>
 
                        </div>
                        </c:if>
        
                   
                    </td>
                </tr>
                    </center>
            </table>
        </form>
</center>
 <c:if test = "${e_mail == null}">
 <c:import url="../default/footer.jsp"/>
 </c:if>
</body>
</html>