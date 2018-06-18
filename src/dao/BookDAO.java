package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Book;

public class BookDAO {
	private static BookDAO dao = new BookDAO();

	private BookDAO() {}

	public static BookDAO getInstance() {
		return dao;
	}

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "cs1234";
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println("커넥션 오류!");
		}
		return conn;
	}

	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("Error:close1" + e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("Error:close2" + e);
			}
		}
	}

	public ArrayList<Book> bookList() {
		ArrayList<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book= null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from book");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book=new Book();
				book.setName(rs.getString(1));
				book.setAuthor(rs.getString(2));
				book.setCompany(rs.getString(3));
				book.setField(rs.getString(4));
				book.setIsbn(rs.getString(5));
				list.add(book);
			}
		}
		catch (Exception e) {
			System.out.println("다오 북 리스트 오류!");
		}
		finally
		{
			close(conn,pstmt);
		}
		return list;
		}		
	
	public ArrayList<Book> bookSearch(String isbn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from book where isbn = ?");
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setName(rs.getString(1));
				book.setAuthor(rs.getString(2));
				book.setCompany(rs.getString(3));
				book.setField(rs.getString(4));
				book.setIsbn(rs.getString(5));
				list.add(book);
			}
		} catch (Exception e) {
		} finally {
			close(conn, pstmt);
		}
		return list;
	} 
	public ArrayList<Book> bookSearch(String name, int a) { //서치 오버로딩
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from book where name = ?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setName(rs.getString(1));
				book.setAuthor(rs.getString(2));
				book.setCompany(rs.getString(3));
				book.setField(rs.getString(4));
				book.setIsbn(rs.getString(5));list.add(book);
			}
		} catch (Exception e) {
		} finally {
			close(conn, pstmt);
		}
		return list;
	}
	public ArrayList<Book> bookSearch(String isbn, String name) { //서치 오버로딩
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from book where isbn=? and name = ?");
			pstmt.setString(1, isbn);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setName(rs.getString(1));
				book.setAuthor(rs.getString(2));
				book.setCompany(rs.getString(3));
				book.setField(rs.getString(4));
				book.setIsbn(rs.getString(5));list.add(book);
			}
		} catch (Exception e) {
		} finally {
			close(conn, pstmt);
		}
		return list;
	}
	
	public void bookInsert(Book book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into book values(?,?,?,?,?)");
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getCompany());
			pstmt.setString(4, book.getField());
			pstmt.setString(5, book.getIsbn());
			pstmt.executeUpdate();
			} catch (Exception e) {
			System.out.println("다오 실행중 오류");
		} finally {
			close(conn, pstmt);
		}
	}
	
	public void bookUpdate(Book book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update book set name=?, author=?, company=?, field=? where isbn=?");
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getCompany());
			pstmt.setString(4, book.getField());
			pstmt.setString(5, book.getIsbn());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("다오 실행중 오류");
		} finally {
			close(conn, pstmt);
		}
	}
	
	public void bookDelete(String isbn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from book where isbn=?");
			pstmt.setString(1, isbn);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("다오 실행중 오류");
		} finally {
			close(conn, pstmt);
		}
	}
}
