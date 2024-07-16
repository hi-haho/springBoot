package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	private DataSource dataSource;
	
	public DataDao() {}// 기본 생성자
	
	public ArrayList<DataDto> JikData(String jik){
		ArrayList<DataDto> list = new ArrayList<DataDto>();
		try {
			conn = dataSource.getConnection();
			String sql = "select * from jikwon where jikwon_jik=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,jik);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DataDto dto = new DataDto(); //초기화
				dto.setJikwonNo(rs.getString("jikwon_no"));
				dto.setJikwonName(rs.getString("jikwon_name"));
				dto.setJikwonGen(rs.getString("jikwon_gen"));
				dto.setJikwonPay(rs.getString("jikwon_pay"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("JikData err: " + e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println("close err: " + e2.getMessage());
			}
		}
		return list;
	}
}
