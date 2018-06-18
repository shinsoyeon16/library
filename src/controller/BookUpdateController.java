package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.Book;

public class BookUpdateController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String author = request.getParameter("author");
		String company=request.getParameter("company");
		String field = request.getParameter("field");
		String isbn = request.getParameter("isbn");
		Book book = new Book(name,author,company,field,isbn);
		
		Service service = Service.getInstance();
		service.bookUpdate(book);
		
		request.setAttribute("result", request.getParameter("name") + " 도서정보 수정이 완료되었습니다.<br>");
		HttpUtil.forward(request, response, "bookList.do");
}
}
