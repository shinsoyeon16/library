package service;

import java.util.ArrayList;

import dao.BookDAO;
import dao.MemberDAO;
import vo.Book;
import vo.Member;

public class Service {
	private static Service service = new Service();
	public MemberDAO m = MemberDAO.getInstance();
	public BookDAO b = BookDAO.getInstance();
	private Service() {
	}
	public static Service getInstance() {
		return service;
	}
	
	//도서관 관리자 멤버관련 서비스
	public ArrayList<Member> memberList() {
		return m.memberList();
	}
	public ArrayList<Member> memberSearch(String id) {
		return m.memberSearch(id);
	}
	public ArrayList<Member> memberSearch(String name, int a) { // 서치 오버로딩
		return m.memberSearch(name, a);
	}
	public ArrayList<Member> memberSearch(String id, String name) { // 서치 오버로딩
		return m.memberSearch(id, name);
	}
	public void memberInsert(Member member) {
		m.memberInsert(member);
	}
	public void memberUpdate(Member member) {
		m.memberUpdate(member);
	}
	public void memberDelete(String id) {
		m.memberDelete(id);
	}
	
	
	//도서관 관리자 북 관련 서비스
	public ArrayList<Book> bookList() {
		return b.bookList();
	}
	public ArrayList<Book> bookSearch(String isbn) {
		return b.bookSearch(isbn);
	}
	public ArrayList<Book> bookSearch(String name, int a) { // 서치 오버로딩
		return b.bookSearch(name, a);
	}
	public ArrayList<Book> bookSearch(String isbn, String name) { // 서치 오버로딩
		return b.bookSearch(isbn, name);
	}
	public void bookInsert(Book book) {
		b.bookInsert(book);
	}
	public void bookUpdate(Book book) {
		b.bookUpdate(book);
	}
	public void bookDelete(String isbn) {
		b.bookDelete(isbn);
	}
	
	
	//여기부터는 도서관 서비스들
	public String login(String id) {
		return m.login(id);
	}
	public void join(Member member) {
		m.join(member);
	}
	public void bookRental(Member member, String isbn) {
		member.setRental(isbn);
		m.bookRental(member);
	}
	public void bookReturn(Member member) {
		m.bookReturn(member);
	}
}
