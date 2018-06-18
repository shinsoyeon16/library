<%@page import="vo.Member"%>
<%@page import="service.Service"%>
<%@page import="controller.HttpUtil"%>
<%@page import="vo.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>YONGIN LIBRARY</title>
<link href='http://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet' type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="/library/library.css" rel="stylesheet" type="text/css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
</head>
<body>
	<%
		// 얼럿 노출을 위한 설정
		String result = (String) request.getAttribute("result");
		if (result != null) {
			out.println("<script language='javascript'>");
			out.println("alert('" + result + "');");
			out.println("</script>");
		}
	%>
	<%
		String id = (String) session.getAttribute("id");
		Service service = Service.getInstance();
		if (id == null) { //미로그인 상태일 경우 대출 불가
			request.setAttribute("result", "로그인 후 이용 가능한 서비스입니다.");
			HttpUtil.forward(request, response, "");
			return;
		}

		ArrayList<Member> list = service.memberSearch(id);
		Member member = list.get(0);
		ArrayList<Book> booklist = new ArrayList<Book>();
		booklist = service.bookSearch(member.getRental());
	%>
	<div id="wrap">
		<div id="container">
		<header> <jsp:include page="header.jsp"></jsp:include> </header>
			<!--//container -->

			<div id="content">
				<%
					if (!booklist.isEmpty()) {
				%>
				<table border="1">
					<tr>
						<th>표지</th>
						<th>책 제목</th>
						<th>저자</th>
						<th>출판사</th>
						<th>분야</th>
						<th>ISBN</th>
						<th></th>
					</tr>
					<%
						for (int i = 0; i < list.size(); i++) {
								Book book = booklist.get(i);
					%>
					<tr>
						<td class="bookimage"><img
							src="resource/<%=book.getIsbn()%>.png" /></td>
						<td><%=book.getName()%></td>
						<td><%=book.getAuthor()%></td>
						<td><%=book.getCompany()%></td>
						<td><%=book.getField()%></td>
						<td><%=book.getIsbn()%></td>
						<td><form action="/library/bookReturn.do" method="post">
								<input type="hidden" name="book" value="<%=book.getIsbn()%>"><input
									type="submit" value="반납하기">
							</form></td>
					</tr>

					<%
						}
						} else {
							request.setAttribute("result", "대출중인 도서가 없습니다.");
							HttpUtil.forward(request, response, "");
							return;
						}
					%>
				</table>
				<br>
				<br>
			</div>



			<!--footer -->
			<div id="footer">
				<%@ include file="footer.html"%>
			</div>
			<!--//footer -->
		</div>
		<!--//ui object -->
	</div>
</body>
</html>