package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.Book;

public class BookInsertController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String company = request.getParameter("company");
		String field = request.getParameter("field");
		String isbn = request.getParameter("isbn");
		ArrayList<Book> list = new ArrayList<Book>();
		Service service = Service.getInstance();
 
		if (name.isEmpty() || author.isEmpty() || company.isEmpty() || field.isEmpty() || isbn.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력하시기 바랍니다.");
			HttpUtil.forward(request, response, "manage/bookInsert.jsp");
			return;
		}
		
		Book book = new Book(name,author,company,field,isbn);
		list = service.bookSearch(isbn);
		if(!list.isEmpty()) { //회원정보가 이미 있는 경우
			request.setAttribute("error", "이미 존재하는 ISBN입니다.");
			HttpUtil.forward(request, response, "manage/bookInsert.jsp");
			return;
		}
		service.bookInsert(book);
		request.setAttribute("result", name+" 도서 추가가 완료되었습니다.");
		HttpUtil.forward(request, response, "bookList.do"); // 등록완료시 실행
	}
}
