<%@page import="vo.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>도서 목록</title>
</head>
<body>
<%
String msg = (String)request.getAttribute("result");
if(msg!=null) {
	out.print("<h3>"+msg+"</h3>");
}
%>
<%@ include file="bookSearch.jsp" %>
<%
ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("list");
if(!list.isEmpty()) {
%>
<table border = "1">
<tr><th>책 제목</th><th>저자</th><th>출판사</th><th>분야</th><th>ISBN</th><th></th></tr>
<% for (int i=0;i<list.size();i++) {
	Book book= list.get(i); %>
	<tr><td><%=book.getName()%></td>
	<td><%=book.getAuthor() %></td>
	<td><%=book.getCompany() %></td>
	<td><%=book.getField() %></td>
	<td><%=book.getIsbn()%></td>
	<td><form action="/library/manage/bookUpdate.jsp" method="post"><input type="hidden" name="book" value="<%=book.getIsbn()%>"><input type="submit" value="수정"></form>
	<form action="/library/bookDelete.do" method="post"><input type="hidden" name="book" value="<%=book.getIsbn()%>"><input type="submit" value="삭제"></form></td></tr>
	
<%}
} else {
	out.print("<h3>등록된 정보가 없습니다.<h3>");
}
%></table><br><br>
<%@ include file="manageHome.jsp" %>
</body>
</html>