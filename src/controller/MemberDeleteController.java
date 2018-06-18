package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.Member;

public class MemberDeleteController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member();
		Service service = Service.getInstance();
		String id = request.getParameter("id");
		ArrayList<Member> list = null;

		if (id.isEmpty()) {
			request.setAttribute("error", "아이디를 다시 입력해주세요.");
			HttpUtil.forward(request, response, "/manage/memberDelete.jsp");
			return;
		}
		list = service.memberSearch(id);

		if (list.isEmpty()) { // 아이디가 회원정보에 없는 경우
			request.setAttribute("error", "입력하신 아이디로는 회원정보가 검색되지 않습니다.");
			HttpUtil.forward(request, response, "/manage/memberDelete.jsp");
			return;
		}

		service.memberDelete(id);
		request.setAttribute("result", id + " 회원정보 삭제가 완료되었습니다.<br>");
		HttpUtil.forward(request, response, "memberList.do");
		return;
	}

}
