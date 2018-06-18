<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 삭제</title>
</head>
<body>
<% if(request.getAttribute("error")==null) request.setAttribute("error", "회원 삭제");%>
<h3>${error}<br></h3>
<form action="/library/memberDelete.do" method="post">
ID : <input type="text" name="id">
<input type="submit" value="확인">
</form>
<br>
<%@ include file="manageHome.jsp"%>

</body>
</html>