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
				out.print(id + " �� ȯ���մϴ�.");
		%>
		<form action="/library/logout.do" method="post">
			<input type="submit" value="�α׾ƿ�">
		</form>
		<%
			} else {
		%>
		<form action="/library/login.do" id="thisform" method="post">
			<input type="text" id="textid" name="id" tabindex="1" accesskey="5"
				placeholder="���̵�" onfocus="this.value='';" required /> <input
				type="password" id="txtPwd" name="password" tabindex="2"
				placeholder="��й�ȣ" onfocus="this.value='';" required /> <input
				type="checkbox" id="chkRemember" name="chkRemember" tabindex="3" />
			<label for="chkRemember">���̵� ����</label> <input type="submit"
				value="�α���" tabindex="4" /> <a href="join.jsp"><input
				type="button" value="ȸ������" tabindex="5" /></a>
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
			<li><a href="/library/content1.jsp">�ڷ�˻�<span
					class="sub-arrow"></span></a>
				<ul>
					<li><a href="#">�ֱ��ڷ�</a></li>
					<li><a href="#">���հ˻�</a></li>
				</ul></li>
			<li><a href="/library/content2.jsp">����/��Ȳ<span
					class="sub-arrow"></span></a>
				<ul>
					<li><a href="#">��������</a></li>
					<li><a href="#">�Ⱓ�ݳ�</a></li>
				</ul></li>
			<li><a href="/library/content3.jsp">��õ����<span
					class="sub-arrow"></span></a>
				<ul>
					<li><a href="#">�̴�����õ</a></li>
					<li><a href="#">����Ʈ����</a></li>
					<li><a href="#">���ǵ��İ�</a></li>
				</ul></li>
		</ul>
		</nav>
	</div>
</body>
</html>