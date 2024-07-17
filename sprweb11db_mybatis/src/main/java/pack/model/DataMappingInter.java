package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;

@Mapper //완전한 객체 처리가 됐다고 말하기 애매하다
//application.properties에서 연결
public interface DataMappingInter {
	//전체 자료 검색
	@Select("select * from sangdata")
	List<DataDto> selectAll();
	
	//검색용
	@Select("select code,sang,su,dan from sangdata where sang like concat('%',#{searchValue},'%')")
	//@Select("select code,sang,su,dan from sangdata where sang like '%'||#{searchValue}||'%'") //오라클
	List<DataDto> selectSearch(FormBean formBean);
	
}
