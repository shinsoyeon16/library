<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
${error }
<form action="/library/memberSearch.do" method="post">
<input type="text" name="id" placeholder="ID�� �Է��ϼ���">
<input type="text" name="name" placeholder="�̸��� �Է��ϼ���">
<input type="submit" value="�˻�">
</form><br>
</body>
</html>