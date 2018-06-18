package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.Member;

public class JoinController implements Controller	{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		ArrayList<Member> list = null;
		Service service = Service.getInstance();
		
		list = service.memberSearch(id);

		if (!list.isEmpty()) { // 회원정보가 이미 있는 경우
			request.setAttribute("error", "존재하는 아이디 입니다.");
			HttpUtil.forward(request, response, "join.jsp");
			return;
		}
		Member member = new Member(id,password,name);
		service.join(member);
		request.setAttribute("result", id + " 님 회원가입이 완료되었습니다.");
		HttpUtil.forward(request, response, "");

	}
}
