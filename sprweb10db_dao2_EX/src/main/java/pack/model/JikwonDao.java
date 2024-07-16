package pack.model;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao extends JdbcDaoSupport{
	@Autowired
	public JikwonDao(DataSource dataSource) {
		setDataSource(dataSource); //db 연결
	}
	
	//특정 자료 읽기
	public List<JikwonDto> jikList(String jik) {
		String sql="select * from jikwon where jikwon_jik =?";
		Object[] args= {jik};
		return getJdbcTemplate().query(sql, args,(ResultSet rs, int rowNum)->{
			JikwonDto jikdto = new JikwonDto();
			jikdto.setJikwonNo(rs.getString("jikwon_no"));
			jikdto.setJikwonName(rs.getString("jikwon_name"));
			jikdto.setJikwonGen(rs.getString("jikwon_gen"));
			jikdto.setJikwonPay(rs.getString("jikwon_pay"));
			return jikdto;
		});
	}
}
