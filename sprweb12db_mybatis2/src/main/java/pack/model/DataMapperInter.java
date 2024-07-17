package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.DataBean;

@Mapper // Marker interface for MyBatis mappers.
public interface DataMapperInter {
	@Select("select * from mem")
	List<DataDto> selectAll();
	
	@Select("select * from mem where num=#{num}")
	List<DataDto> selectOne(String num);
	
	@Insert("insert into mem values(#{num},#{name},#{addr})")
	int insertData(DataBean bean);
	
	@Update("update mem set name=#{name}, addr = #{addr} where num=#{num}")
	int update(DataBean bean);
	
	@Delete("delect from mem where num=#{num}")
	int delete(String num);
}
