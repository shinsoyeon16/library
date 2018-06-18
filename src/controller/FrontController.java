package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	HashMap<String, Controller> list = null;

	public void init(ServletConfig sc) throws ServletException {
		list = new HashMap<String, Controller>(); 
		list.put("/memberList.do", new MemberListController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/bookList.do", new BookListController());
		list.put("/bookSearch.do", new BookSearchController());
		list.put("/bookInsert.do", new BookInsertController());
		list.put("/bookUpdate.do", new BookUpdateController());
		list.put("/bookDelete.do", new BookDeleteController());
		list.put("/login.do", new LoginController());
		list.put("/logout.do", new LogoutController());
		list.put("/join.do", new JoinController());
		list.put("/bookRental.do", new BookRentalController());
		list.put("/bookReturn.do", new BookReturnController());
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setCharacterEncoding(charset);
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = list.get(path);
		subController.execute(request, response);
	}

}
