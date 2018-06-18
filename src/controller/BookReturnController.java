package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Service;
import vo.Member;

public class BookReturnController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String id = (String)session.getAttribute("id");
		
		Service service = Service.getInstance();
		
		ArrayList<Member> list = service.memberSearch(id);
		Member member = list.get(0);
		
			service.bookReturn(member);
		request.setAttribute("result", "도서 반납이 완료되었습니다.");
		HttpUtil.forward(request, response, "");
		return;
		
	}
}
