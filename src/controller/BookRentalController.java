package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Service;
import vo.Member;

public class BookRentalController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Service service = Service.getInstance();
		String id = (String)session.getAttribute("id");
		String isbn = request.getParameter("book");
		if(id==null) { //미로그인 상태일 경우 대출 불가
			request.setAttribute("result", "로그인 후 이용 가능한 서비스입니다.");
			HttpUtil.forward(request, response, "content1.jsp");
			return;
		}
		
		ArrayList<Member> list = service.memberSearch(id);
		Member member = list.get(0);
		if(!member.getRental().equals("")) { //이미 도서대출을 한 경우 대출 불가
			request.setAttribute("result", "현재 대출 중인 도서를 반납하신 후 이용 부탁드립니다.");
		} else {
			service.bookRental(member,isbn);
			request.setAttribute("result", "도서 대출이 완료되었습니다.");
		}
		HttpUtil.forward(request, response, "content1.jsp");
		return;
	}
}
