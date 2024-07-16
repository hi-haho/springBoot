package pack.model;

import java.lang.reflect.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport {
	
	@Autowired
	public MemberDao(DataSource dataSource) {
		setDataSource(dataSource); //db 연결!
	}
	
	//전체 자료 읽기
	public List<MemberDto> getMemberList(){
		String sql = "select * from memberteb";
		/* 
		return getJdbcTemplate().query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}
		});
		*/
		//람다는 추상이 1개인 경우 사용할 수 있다.
		return getJdbcTemplate().query(sql,(ResultSet rs, int rowNum)->{
			MemberDto member = new MemberDto();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPasswd(rs.getString("passwd"));
			member.setReg_date(rs.getString("reg_date"));
			return member;
		});
	}
	
	//insert
	public void insData(MemberBean bean) {
		String sql = "insert into memberteb values(?,?,?,now())";
		
		Object[] params = {bean.getId(),bean.getName(),bean.getPasswd()}; //데이터가 하나일지라고 배열로 처리해야한다.
		getJdbcTemplate().update(sql, params);
	}
	
	//update
	
	
	//delect
	
}
