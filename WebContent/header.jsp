<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="b-header">
		<%
			String id = (String) session.getAttribute("id");
			if (id != null) {
				out.print(id + " 님 환영합니다.");
		%>
		<form action="/library/logout.do" method="post">
			<input type="submit" value="로그아웃">
		</form>
		<%
			} else {
		%>
		<form action="/library/login.do" id="thisform" method="post">
			<input type="text" id="textid" name="id" tabindex="1" accesskey="5"
				placeholder="아이디" onfocus="this.value='';" required /> <input
				type="password" id="txtPwd" name="password" tabindex="2"
				placeholder="비밀번호" onfocus="this.value='';" required /> <input
				type="checkbox" id="chkRemember" name="chkRemember" tabindex="3" />
			<label for="chkRemember">아이디 저장</label> <input type="submit"
				value="로그인" tabindex="4" /> <a href="join.jsp"><input
				type="button" value="회원가입" tabindex="5" /></a>
		</form>
		<%
			}
		%>

	</div>

	<a href="/library/library.jsp"><div class="header">
			<img class="header-image" src="resource/university_header.png" />
		</div></a>


	<div class="aside">
		<nav class="main-menu">
		<ul class="main-menu-ul">
			<li><a href="/library/content1.jsp">자료검색<span
					class="sub-arrow"></span></a>
				<ul>
					<li><a href="#">최근자료</a></li>
					<li><a href="#">통합검색</a></li>
				</ul></li>
			<li><a href="/library/content2.jsp">대출/현황<span
					class="sub-arrow"></span></a>
				<ul>
					<li><a href="#">내도서관</a></li>
					<li><a href="#">기간반납</a></li>
				</ul></li>
			<li><a href="/library/content3.jsp">추천도서<span
					class="sub-arrow"></span></a>
				<ul>
					<li><a href="#">이달의추천</a></li>
					<li><a href="#">베스트셀러</a></li>
					<li><a href="#">나의독후감</a></li>
				</ul></li>
		</ul>
		</nav>
	</div>
</body>
</html>