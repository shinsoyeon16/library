<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ���� ����</title>
</head>
<body>
<% if(request.getAttribute("error")==null) request.setAttribute("error", "ȸ�� ���� ����");%>
<h3>${error}<br></h3>
<form action="/library/memberUpdate.do" method="post">
ID : <input type="text" name="id" value = "${member.id}">
<% if(session.getAttribute("id") == null) {%>
<input type="submit" value="�˻�">
<% } %>
</form>
<% if(session.getAttribute("id") != null) {%>
<form action="/library/memberUpdate.do" method="post">
��й�ȣ : <input type="password" name="password" value="${member.password}"> <br />
�̸� : <input type="text" name="name" value="${member.name}"> <br />
<input type="submit" value="����">
<input type="reset" value="���Է�">
</form>
<%}%><br>
<%@ include file="manageHome.jsp"%>
</body>
</html>