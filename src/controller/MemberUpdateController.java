package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Service;
import vo.Member;

public class MemberUpdateController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member();
		Service service = Service.getInstance();
		String id = request.getParameter("id");
		HttpSession se = request.getSession(false);
		ArrayList<Member> list = null;
		if (se.isNew() || se.getAttribute("id") == null) {
			if (id.isEmpty()) {
				request.setAttribute("error", "아이디를 다시 입력해주세요.");
				HttpUtil.forward(request, response, "/manage/memberUpdate.jsp");
				return;
			}
			list = service.memberSearch(id);

			if (list.isEmpty()) { // 아이디가 회원정보에 없는 경우
				request.setAttribute("error", "입력하신 아이디로는 회원정보가 검색되지 않습니다.");
			} else {
				se = request.getSession();
				se.setAttribute("id", id);
				member=list.get(0);
				request.setAttribute("member", member);
			}
			HttpUtil.forward(request, response, "/manage/memberUpdate.jsp");
			return;
		} else { 
			id = (String) se.getAttribute("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");

			if (se.getAttribute("id") !=null && (password.isEmpty() || name.isEmpty())) {
				request.setAttribute("error", "모든 항목을 빠짐없이 입력해주세요.");
				Member updatem = new Member(id, password, name);
				request.setAttribute("member", updatem);
				HttpUtil.forward(request, response, "/manage/memberUpdate.jsp");
				return;
			}
			
			Member updatem = new Member(id, password, name);
			request.setAttribute("updatem", updatem);
			service.memberUpdate(updatem);
			se.invalidate();
			request.setAttribute("result", id + " 회원정보 수정이 완료되었습니다.<br>");
			HttpUtil.forward(request, response, "memberList.do");
			return;
		}

	}

}
