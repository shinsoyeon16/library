<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>YONGIN LIBRARY</title>
<link href="/library/library.css" rel="stylesheet" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet' type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.cycle2.js"></script>
<!-- 맨 위는 제이쿼리 소스, 아래는 슬라이드 제이쿼리 소스-->
<script>
	src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" >
</script>
<script>
	$(document).ready(function() {
		var show = 3;
		var w = $('#slider').width() / show;
		var l = $('.slide').length;

		$('.slide').width(w);
		$('#slide-container').width(w * l)

		function slider() {
			$('.slide:first-child').animate({
				marginLeft : -w
			}, 'slow', function() {
				$(this).appendTo($(this).parent()).css({
					marginLeft : 0
				});
			});
		}
		var timer = setInterval(slider, 2000);

		$('#slider').hover(function() {
			clearInterval(timer);
		}, function() {
			timer = setInterval(slider, 2000);
		});
	});
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
			<!--//container -->
			<header> <jsp:include page="header.jsp"></jsp:include> </header>
			<div id="content">
				<div class="cycle-slideshow" data-cycle-fx=scrollHorz
					data-cycle-timeout=4000>
					<!-- empty element for pager links -->
					<div class="cycle-pager"></div>

					<img src="resource/1.png"> <img src="resource/2.png"> <img
						src="resource/3.png"> <img src="resource/4.png">

					<div class="inno1">
						<div class="box">

							<h1>공지사항</h1>
							<p>2018년 8월 대학원 석박사 학위논문 온라인제출</p>
							<P>제 1회 독서경시대회 퀴즈정답</P>
							<p>열람실 24시간 개방 안내</p>
							<p>6월 신착 도서 안내(2018-6월)</p>
							<p>도서관 휴관 안내(06.08)</p>

						</div>
					</div>
					<div class="inno2">
						<div class="box">

							<h1>공지사항</h1>
							<p>2018년 8월 대학원 석박사 학위논문 온라인제출</p>
							<P>제 1회 독서경시대회 퀴즈정답</P>
							<p>열람실 24시간 개방 안내</p>
							<p>6월 신착 도서 안내(2018-6월)</p>
							<p>도서관 휴관 안내(06.08)</p>

						</div>
					</div>

				</div>
				<h1
					style="text-align: center; margin-top: 60px; color: #3C3C8C; font-size: 30px">이달의
					추천책</h1>
				<div id="slider">
					<div id="slide-container">
						<div class="slide">
							<img src="resource/book1.png">Slide 1
						</div>
						<div class="slide">
							<img src="resource/book2.png">Slide 2
						</div>
						<div class="slide">
							<img src="resource/book3.png">Slide 3
						</div>
						<div class="slide">
							<img src="resource/book4.png">Slide 4
						</div>
						<div class="slide">
							<img src="resource/book5.png">Slide 5
						</div>
						<div class="slide">
							<img src="resource/book6.png">Slide 6
						</div>
						<div class="slide">
							<img src="resource/book7.png">Slide 7
						</div>
						<div class="slide">
							<img src="resource/book8.png">Slide 8
						</div>
					</div>
				</div>


				<!--//content -->
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