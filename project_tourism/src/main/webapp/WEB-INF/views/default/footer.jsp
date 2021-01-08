<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.footer {
		display:flex;
		position: relative;
		max-width: 1200px;
		max-height: 200px;
		margin : 20px auto;
		padding : 10px;
		box-sizing: border-box;
		border-radius: 4px;
		box-shadow: 0 2px 5px rgba(0,0,0,.2);
	}
	.a {
		width : 15%;
	}
	.b {
		width: 40%;
		padding : 20px 0 0 5px;
		color: #525050;
		font-size: 14px;
	}
	.c {
		width: 30%;
		padding : 20px 0 0 5px;
		color: #525050;
		font-size: 14px;
	}
	.d {
		width: auto%;
		padding : 15px 0 0 5px;
	}
	
</style>
</head>
<body>
	<hr style="color: #525050;">
	<div class='footer'>
		<div class='a'>
			<img src="/resources/images/odiro.jpg" style="width: 120px; height: 110px; border: 0px; vertical-align: middle;">
		</div>
		<div class='b'>
			서울시 마포구 성미산로30-9<br>
			TEL (02)123-4567  FAX (02)765-4321<br>
			COPYRIGHT(C)2021 ODIRO.CO.,LTD.ALL RIGHTS RESERVED.
		</div>
		<div class='c'>
			
		</div>
		<div class='d'>
			<img src="/resources/images/h2Logo.jpg" style="width: 100px; height: 34px; border: 0px; vertical-align: middle; display: flex; flex-flow: column;">
			<img src="/resources/images/h3Logo.jpg" style="width: 94px; height: 34px; border: 0px; vertical-align: middle; display: flex; flex-flow: column;">
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</html>