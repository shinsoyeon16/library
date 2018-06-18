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
<script src="http://malsup.github.com/jquery.cycle2.js"></script>
<!-- 맨 위는 제이쿼리 소스, 아래는 슬라이드 제이쿼리 소스-->
<script>
	src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
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
	<div id="wrap">
		<div id="container">
			<header> <jsp:include page="header.jsp"></jsp:include> </header>
			<!--//container -->
			<div id="content">
				<h3 style="text-align: center; letter-spacing: 4px;">~ 이달의 추천도서
					~</h3>
				<div id="content-table">
					<table>
						<tr>
							<td class="bookimage"><img src="resource/bookno1.png" /></td>
							<td class="bookname">무례한 사람에게 웃으며 대처하는 법</td>
							<td class="author">정문정</td>
							<td class="company">가나출판사</td>
							<td class="filed">자기계발</td>
							<td class="ISBN">9788957369364</td>
						</tr>

						<tr>
							<td class="bookimage"><img src="resource/bookno2.png" /></td>
							<td class="bookname">시작된 미래 e</td>
							<td class="author">제작팀</td>
							<td class="company">가나출판사</td>
							<td class="filed">에세이</td>
							<td class="ISBN">9788957368978</td>
						</tr>

						<tr>
							<td class="bookimage"><img src="resource/bookno3.png" /></td>
							<td class="bookname">보이는 세상은 실재가 아니다</td>
							<td class="author">카를로 로벨리</td>
							<td class="company">쌤앤파커스</td>
							<td class="filed">에세이</td>
							<td class="ISBN">9788965706205</td>
						</tr>

						<tr>
							<td class="bookimage"><img src="resource/bookno4.png" /></td>
							<td class="bookname">포르투갈의 높은 산</td>
							<td class="author">얀 마텔</td>
							<td class="company">작가정신</td>
							<td class="filed">소설</td>
							<td class="ISBN">9791160260632</td>
						</tr>
						<tr>
							<td class="bookimage"><img src="resource/bookno5.png" /></td>
							<td class="bookname">모든것이 되는 법</td>
							<td class="author">에밀리 와프닉</td>
							<td class="company">웅진지식하우스</td>
							<td class="filed">자기계발</td>
							<td class="ISBN">9788901221083</td>
						</tr>

					</table>
				</div>
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