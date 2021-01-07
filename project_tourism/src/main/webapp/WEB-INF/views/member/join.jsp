<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<!-- 회원가입 페이지 -->
<style type="text/css">
	body {
		max-width: 1200px;
		margin : 20px auto;
		padding : 10px;
	}
</style>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>


<script>
// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
	$("#user_nick").blur(function() {
		var user_nick = $('#user_nick').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/member/nickCheck?userNick='+ user_nick,
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : "+ data);							
				
				if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#user_nick").text("사용중인 닉네임입니다 :p");
						$("#user_nick").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
						
						if(idJ.test(user_nick)){
							// 0 : 아이디 길이 / 문자열 검사
							$("#user_nick").text("");
							$("#reg_submit").attr("disabled", false);
				
						} else if(user_nick == ""){
							
							$('#user_nick').text('닉네임을 입력해주세요 :)');
							$('#user_nick').css('color', 'red');
							$("#reg_submit").attr("disabled", true);				
							
						} 
						
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});
</script>
<body>
<center>
<table border="1" width="450" height="400">
    
        <br> <br>
        <center>
        <span style="color: green; font-weight: bold;">회원가입</span> <br> <br>
                       
                        <form action="join_check.do${e_mail}" method="post">
                    <center>
                        <div>
                            인증받은 이메일 : ${e_mail}
                                                    
                        </div>
                        <br>
                        <div class="form-group">
							닉네임 : <input type="text" class="form-control" id="user_nick" name="user_nick" placeholder="ID" required>
					<div class="check_font" id="nick_check"></div>
					</div>
                        <br>
                        <div>
                            비밀번호 : <input type="password" name="user_pass"
                                placeholder="  비밀번호를 입력하세요. ">
                        </div>
                        <br>
                        <!-- 이메일은 인증받은 이메일을 사용해야 하므로 컨트롤러에서 이메일을 가져와서 사용함 -->
                        <!-- 가져온후에 다시 컨트롤러로 넘긴후에 db에 저장하는 식으로 진행 -->
                        
                        <br> <br>
                        <button type="submit" name="submit">회원가입</button>
                    </center>
                        </div>
                    </td>
                </tr>
            </table>
            </center>
        </form>   
        </center>
</body>
</html>
