<%@page import="java.util.ArrayList"%>
<%@page import="vo.Book"%>
<%@page import="service.Service"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>도서 정보 수정</title>
</head>
<body>
<%
String isbn = request.getParameter("book");
Service service = Service.getInstance();
ArrayList<Book> list = service.bookSearch(isbn);
request.setAttribute("book", list.get(0));
%>
<h3>도서 정보 수정<br></h3>
<form action="/library/bookUpdate.do" method="post">
책 제목 : <input type="text" name="name" required value = "${book.name}"><br>
저자 : <input type="text" name="author" required value = "${book.author}"><br>
출판사 : <input type="text" name="company" required value = "${book.company}"><br>
분야 : <select name="field">
		<option value="Self-improvement">자기계발</option>
		<option value="essay">에세이</option>
		<option value="fiction">소설</option>
		</select><br>
ISBN : <input type="text" readonly name="isbn" value = "${book.isbn}"><br>
<input type="submit" value="수정">
<input type="reset" value="재입력">
</form>

<br>
<%@ include file="manageHome.jsp"%>
</body>
</html>