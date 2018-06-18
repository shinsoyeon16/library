package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Member;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();

	private MemberDAO() {}

	public static MemberDAO getInstance() {
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

	public ArrayList<Member> memberList() {
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member=new Member();
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setRental(rs.getString(4));
				list.add(member);
			}
		}
		catch (Exception e) {
			System.out.println("다오 멤버 리스트 오류!");
		}
		finally
		{
			close(conn,pstmt);
		}
		return list;
		}		
	
	public ArrayList<Member> memberSearch(String id) {
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member=new Member();
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setRental(rs.getString(4));
				list.add(member);
			}
		} catch (Exception e) {
		} finally {
			close(conn, pstmt);
		}
		return list;
	} 
	public ArrayList<Member> memberSearch(String name, int a) { //서치 오버로딩
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where name = ?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member=new Member();
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setRental(rs.getString(4));
				list.add(member);
			}
		} catch (Exception e) {
		} finally {
			close(conn, pstmt);
		}
		return list;
	}
	public ArrayList<Member> memberSearch(String id, String name) { //서치 오버로딩
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id = ? and name=?");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member=new Member();
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setRental(rs.getString(4));
				list.add(member);
			}
		} catch (Exception e) {
		} finally {
			close(conn, pstmt);
		}
		return list;
	} 
	
	
	
	public void memberInsert(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getRental());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("다오 실행중 오류");
		} finally {
			close(conn, pstmt);
		}
	}
	public void memberUpdate(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set password=?, name=? where id=?");
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("다오 실행중 오류");
		} finally {
			close(conn, pstmt);
		}
	}
	public void memberDelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from member where id=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("다오 실행중 오류");
		} finally {
			close(conn, pstmt);
		}
	}
	public String login(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String password=null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select password from member where id = ?");
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				password = rs.getString(1);
			}
		} catch (Exception e) {
		} finally {
			close(conn, pstmt);
		}
		return password;
	}
	public void join(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getRental());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("다오 실행중 오류");
		} finally {
			close(conn, pstmt);
		}
	}
	public void bookRental(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set rental=? where id=?");
			pstmt.setString(1, member.getRental());
			pstmt.setString(2, member.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("다오 실행중 오류");
		} finally {
			close(conn, pstmt);
		}
	}
	public void bookReturn(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set rental='' where id=?");
			pstmt.setString(1, member.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("다오 실행중 오류");
		} finally {
			close(conn, pstmt);
		}
	}
}

