package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

public class BookDeleteController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("book");
		Service service = Service.getInstance();
		service.bookDelete(isbn);
		request.setAttribute("result", "도서 정보가 삭제되었습니다.<br>");
		HttpUtil.forward(request, response, "bookList.do");
		return;
	}
}
