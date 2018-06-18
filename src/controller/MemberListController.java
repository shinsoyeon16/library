package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.Member;

public class MemberListController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Service service = Service.getInstance();
		ArrayList<Member> list = service.memberList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/manage/memberList.jsp");
	}

}
