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
	 <c:import url="../default/header.jsp"/>
	 <c:if test = "${map.list != null}">
 
 
<center>
 
<span style="color: green; font-weight: bold;">회원 프로필</span> <br> <br>
 
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
                            <button type = "submit" name = "submit" >회원 강제 삭제</button>
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