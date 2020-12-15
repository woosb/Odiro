<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <c:if test = "${e_mail == null}">
 <c:import url="../default/header.jsp"/>
 </c:if>
<table border="1" width="300" height="300" align= "center">
<center>
<span style="color: green; font-weight: bold;">이메일 인증 (이메일을 인증 받아야 다음 단계로 넘어갈 수 있습니다.)</span> <br> <br>    
        <br> <br>
        <div style="text-align:center;">
            <tr>        
                <td>
                <center>
                <c:if test = "${e_mail == null}">
                        <div>
                        <form action="email_check.do" method="post">
                            이메일 : <input type="email" name="e_mail" placeholder="  이메일주소를 입력하세요. "><br><br> 
                                
                                <button type="submit" name="submit">중복확인</button></form>
                        </div>                                                    
        </c:if>
        <c:if test = "${e_mail != null}">
 <div>
                    <form action="auth.do${e_mail}" method="post">
                    
                    <center>
                        <br>이메일 : ${e_mail}
                        <br> <br>
                        <button type="submit" name="submit">이메일 인증받기 (이메일 보내기)</button>
 
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
