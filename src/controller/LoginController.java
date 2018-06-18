package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Service;


public class LoginController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if(id.isEmpty()||password.isEmpty()) {
			request.setAttribute("result", "모든 항목을 입력해주시기 바랍니다.");
			HttpUtil.forward(request, response, "");
			return;
		}
		if(id.equals("admin") && password.equals("12345")) {
			HttpUtil.forward(request, response, "/manage/manageMenu.jsp");
			return;
		}
		Service service = Service.getInstance();
		String dbPassword = service.login(id);
		if(dbPassword == null) {
			request.setAttribute("result", "존재하지 않는 아이디입니다.");
			HttpUtil.forward(request, response, "");
			return;
		}
		
		if(!dbPassword.equals(password)) {
			request.setAttribute("result", "비밀번호가 다릅니다.");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}
		HttpUtil.forward(request, response, "");
		return;
	}
}
