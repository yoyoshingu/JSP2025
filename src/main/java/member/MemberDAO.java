package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement pstmt;
	
	final String JDBC_DRIVER = "org.h2.Driver" ;
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "sa", "");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public List<Member> getAll() {
		List<Member> memberlist = new ArrayList<>();
		// 모든 회원들의 정보를 리턴하는 부분
		open();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM members");
			ResultSet rs = pstmt.executeQuery();
			
			Member m = new Member();
			m.setId(rs.getInt("id"));
			m.setUsername(rs.getString("username"));
			m.setCompany(rs.getString("company"));
			m.setBirthday(rs.getDate("birthday"));
			m.setEmail(rs.getString("email"));
			
			memberlist.add(m);
			
		}catch(Exception e) {
			
		}finally {
			close();
		}
		
		return memberlist;
	}
	
	public void insert(Member m) {
		// 새로운 회원을 회원테이블에 집어넣기
	}
}
