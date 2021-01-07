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
	<div style="text-align: center"> 
	<h3>* 닉네임 중복확인 *</h3> 
	<c:if test = "${nick == null}">
	<form method="post" action="nickCheck" onsubmit="return blankCheck(this)"> 
	닉네임 : <input type="text" name="nick" maxlength="10" autofocus> 
	<input type="submit" value="중복확인"> 
	</c:if>
	<c:if test = "${nick != null}">
		<script type="text/javascript">
			window.close()
		</script>
	</c:if>
	</form>
    </div> 
    <script> 
    function blankCheck(f){ 
    	var nick=f.nick.value; 
    	nick=nick.trim(); 
    	if(nick.length<1){ 
    		alert("닉네임은 1자 이상 입력해주십시오."); 
    	return false; 
    	}//if end 
    	return true; 
    	}//blankCheck() end 
    	</script>

</body>
</html>