<%@page import="vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ���</title>
</head>
<body>
<%
String msg = (String)request.getAttribute("result");
if(msg!=null) {
	out.print("<h3>"+msg+"</h3>");
}
%>
<%@ include file="memberSearch.jsp" %>
<%
ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
if(!list.isEmpty()) {
%>
<table border = "1">
<tr><th>ID</th><th>��й�ȣ</th><th>�̸�</th><th>������ ����</th></tr>
<% for (int i=0;i<list.size();i++) {
	Member member = list.get(i); %>
	<tr><td><%=member.getId()%></td>
	<td><%=member.getPassword() %></td>
	<td><%=member.getName() %></td>
	<td><%=member.getRental() %></td></tr>
<%}
} else {
	out.print("<h3>��ϵ� ������ �����ϴ�.<h3>");
}
%>
</table><br><br>
<%@ include file="manageHome.jsp" %>
</body>
</html>