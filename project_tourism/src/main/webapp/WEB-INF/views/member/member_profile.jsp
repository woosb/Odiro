<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
</head>
<body>
<<<<<<< HEAD
        <center>
=======
 <c:import url="../default/header.jsp"/>
>>>>>>> e978f682d04f2ecc9361af7241cc34984056e34c
        <br>
        <br>
        <br>
<c:if test = "${map.list != null}">
<<<<<<< HEAD
 
 
<center>
 
<span style="color: green; font-weight: bold;">나의 프로필</span> <br> <br>
 
<table border="1" width="300" height="250">
    
        <div style="text-align:center;">
            <tr>        
                <td>
                    
                    <center>
                        <div>    
    <c:forEach var = "member" items = "${map.list}"><!-- 컨트롤러에서 넘어온 map의 값 --> 
    					<c:if test = "${check==null}">
    					<form action="nickName_check" method="post">
                            이메일 : <input type="email" name="e_mail" value="${member.e_mail}" readonly /> <br><br>
                            닉네임 : <input type="text" name="nickName" value="${member.nickName}">
                            <button type = "submit" name = "submit" >중복 확인</button>
                        </form>
                        </c:if>
    					<c:if test = "${check!=null}">
    					<form action="update" method="post">
                            이메일 : <input type="email" name="e_mail" value="${member.e_mail}" readonly /> <br><br>
                            닉네임 : <input type="text" name="nickName" value="${member.nickName}">
                            <button type = "submit" name = "submit" >닉네임 변경</button>
                        </form>
                        </c:if>
                        
                        </div>                        
                        
                        
                    </center>
                        
                    </td>
                </tr>
                </div>
                </c:forEach>
            </table>
            </center>
 
</c:if>
 
=======
	<span style="color: green; font-weight: bold;">나의 프로필</span> <br> <br>
	<div align="center">
		<table border="1" width="300" height="250">
		<tr>        
		    <td>
		        <div>    
					<c:forEach var = "member" items = "${map.list}"><!-- 컨트롤러에서 넘어온 map의 값 --> 
					               이메일 : ${member.e_mail} <br><br>    
					</c:forEach>
		         </div>                        
		    </td>
		</tr>
		</table> 
	</div>
</c:if>
 
<c:import url="../default/footer.jsp"/>
>>>>>>> e978f682d04f2ecc9361af7241cc34984056e34c
</body>
</html>
