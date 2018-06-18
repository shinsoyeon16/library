package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.Member;

public class MemberInsertController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		ArrayList<Member> list = null;
		Service service = Service.getInstance();
		Member member = null;
		if (id.isEmpty() || password.isEmpty() || name.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력하시기 바랍니다.");
			HttpUtil.forward(request, response, "manage/memberInsert.jsp");
			return;
		}
		list = service.memberSearch(id);

		if (!list.isEmpty()) { // 회원정보가 이미 있는 경우
			request.setAttribute("error", "존재하는 아이디 입니다.");
			HttpUtil.forward(request, response, "manage/memberInsert.jsp");
			return;
		}

		member = new Member(id, password, name);
		service.memberInsert(member);
		request.setAttribute("result", id + " 회원 추가가 완료되었습니다.");
		HttpUtil.forward(request, response, "memberList.do"); // 등록완료시 실행
	}
}
