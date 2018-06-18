package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.Book;

public class BookSearchController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String isbn = request.getParameter("isbn");
		ArrayList<Book> list = new ArrayList<Book>();
		if (name.isEmpty() && isbn.isEmpty()) {
			request.setAttribute("error", "검색할 정보를 입력해주세요.");
			HttpUtil.forward(request, response, "/bookList.do");
		}
		Service service = Service.getInstance();
		if (isbn.isEmpty()) {
			list= service.bookSearch(name,1);
		} else if (name.isEmpty()) {
			list = service.bookSearch(isbn);
		} else if (!(isbn.isEmpty() || name.isEmpty())) {
			list = service.bookSearch(isbn, name);
		}

		if (list.isEmpty())
			request.setAttribute("result", "검색된 정보가 없습니다.");
		request.setAttribute("list", list);

		HttpUtil.forward(request, response, "/manage/bookSearchOutput.jsp");
	}
}
