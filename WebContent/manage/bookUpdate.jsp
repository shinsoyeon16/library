<%@page import="java.util.ArrayList"%>
<%@page import="vo.Book"%>
<%@page import="service.Service"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ���� ����</title>
</head>
<body>
<%
String isbn = request.getParameter("book");
Service service = Service.getInstance();
ArrayList<Book> list = service.bookSearch(isbn);
request.setAttribute("book", list.get(0));
%>
<h3>���� ���� ����<br></h3>
<form action="/library/bookUpdate.do" method="post">
å ���� : <input type="text" name="name" required value = "${book.name}"><br>
���� : <input type="text" name="author" required value = "${book.author}"><br>
���ǻ� : <input type="text" name="company" required value = "${book.company}"><br>
�о� : <select name="field">
		<option value="Self-improvement">�ڱ���</option>
		<option value="essay">������</option>
		<option value="fiction">�Ҽ�</option>
		</select><br>
ISBN : <input type="text" readonly name="isbn" value = "${book.isbn}"><br>
<input type="submit" value="����">
<input type="reset" value="���Է�">
</form>

<br>
<%@ include file="manageHome.jsp"%>
</body>
</html>