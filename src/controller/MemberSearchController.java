package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.Member;

public class MemberSearchController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		ArrayList<Member> list = null;
		if (id.isEmpty() && name.isEmpty()) {
			request.setAttribute("error", "검색할 정보를 입력해주세요.");
			HttpUtil.forward(request, response, "/memberList.do");
		}
		Service service = Service.getInstance();
		if (id.isEmpty()) {
			list = service.memberSearch(name,1);
		} else if (name.isEmpty()) {
			list = service.memberSearch(id);
		} else if (!(id.isEmpty() || name.isEmpty())) {
			list = service.memberSearch(id, name);
		}

		if (list.isEmpty())
			request.setAttribute("result", "검색된 정보가 없습니다.");
		request.setAttribute("list", list);

		HttpUtil.forward(request, response, "/manage/memberSearchOutput.jsp");
	}
}
