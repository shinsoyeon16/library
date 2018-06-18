<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 추가</title>
<style rel="stylesheet">
html {
	width: 100%;
	height: 100%;
}

body {
	background: url("/library/resource/university.png");
	background-repeat: no-repeat;
	font-family: "Roboto", sans-serif;
	font-size: 14px;
	line-height: 1.6em;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

.overlay, .form-panel.one:before {
	position: absolute;
	top: 0;
	left: 0;
	display: none;
	background: rgba(0, 0, 0, 0.8);
	width: 100%;
	height: 100%;
}

.form {
	z-index: 15;
	position: relative;
	background: #FFFFFF;
	width: 600px;
	border-radius: 4px;
	box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
	box-sizing: border-box;
	margin: 100px auto 10px;
	overflow: hidden;
}

.form-toggle {
	z-index: 10;
	position: absolute;
	top: 60px;
	right: 60px;
	background: #FFFFFF;
	width: 60px;
	height: 60px;
	border-radius: 100%;
	-webkit-transform-origin: center;
	-ms-transform-origin: center;
	transform-origin: center;
	-webkit-transform: translate(0, -25%) scale(0);
	-ms-transform: translate(0, -25%) scale(0);
	transform: translate(0, -25%) scale(0);
	opacity: 0;
	cursor: pointer;
	-webkit-transition: all 0.3s ease;
	transition: all 0.3s ease;
}

.form-group {
	display: -webkit-box;
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	-webkit-flex-wrap: wrap;
	-ms-flex-wrap: wrap;
	flex-wrap: wrap;
	-webkit-box-pack: justify;
	-webkit-justify-content: space-between;
	-ms-flex-pack: justify;
	justify-content: space-between;
	margin: 0 0 20px;
}

.form-group label {
	display: block;
	margin: 0 0 10px;
	color: rgba(0, 0, 0, 0.6);
	font-size: 12px;
	font-weight: 500;
	line-height: 1;
	text-transform: uppercase;
	letter-spacing: .2em;
}

.form-group input {
	outline: none;
	display: block;
	background: rgba(0, 0, 0, 0.1);
	width: 100%;
	border: 0;
	border-radius: 4px;
	box-sizing: border-box;
	padding: 12px 20px;
	color: rgba(0, 0, 0, 0.6);
	font-family: inherit;
	font-size: inherit;
	font-weight: 500;
	line-height: inherit;
	-webkit-transition: 0.3s ease;
	transition: 0.3s ease;
}

.form-group input:focus {
	color: rgba(0, 0, 0, 0.8);
}

.form-group select {
	outline: none;
	display: block;
	background: rgba(0, 0, 0, 0.1);
	width: 100%;
	border: 0;
	border-radius: 4px;
	box-sizing: border-box;
	padding: 12px 20px;
	color: rgba(0, 0, 0, 0.6);
	font-family: inherit;
	font-size: inherit;
	font-weight: 500;
	line-height: inherit;
	-webkit-transition: 0.3s ease;
	transition: 0.3s ease;
}

.form-group button {
	outline: none;
	background: #4285F4;
	width: 45%;
	border: 0;
	border-radius: 4px;
	padding: 12px 20px;
	color: #FFFFFF;
	font-family: inherit;
	font-size: inherit;
	font-weight: 500;
	line-height: inherit;
	text-transform: uppercase;
	cursor: pointer;
}

.form-panel {
	padding: 60px calc(5% + 60px) 60px 60px;
	box-sizing: border-box;
}

.form-header {
	margin: 0 0 40px;
}

.form-header h1 {
	padding: 4px 0;
	color: #4285F4;
	font-size: 24px;
	font-weight: 700;
	text-transform: uppercase;
}
</style>
</head>
<body>
	<form action="/library/memberInsert.do" method="post">

		<div class="form">
			<div class="form-toggle"></div>
			<div class="form-panel one">
				<div class="form-header">
					<%
						if (request.getAttribute("error") == null)
							request.setAttribute("error", "회원추가");
					%>
					<h1>${error}<br>
					</h1>
				</div>
				<div class="form-content">
					<form>
						<div class="form-group">
							<label for="name">아이디</label> <input type="text" id="id"
								name="id" required="required" />
						</div>
						<div class="form-group">
							<label for="company">비밀번호</label> <input type="password"
								id="password" name="password" required="required">
						</div>
						<div class="form-group">
							<label for="name">이름</label> <input type="text" id="name"
								name="name" required="required" />
						</div>
						<div class="form-group">
							<button type="submit">추가</button>
							<button type="reset">다시입력</button>
						</div>
					</form>
				</div>
			</div>
			<%
				request.removeAttribute("error");
			%><br>
</body>
</html>