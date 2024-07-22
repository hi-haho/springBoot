package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.BoardBean;

@Mapper
public interface DataMapInter {
	//추상메서드명은 mapper.xml의 id명과 일치
	List<Board> selectList();
	List<Board> selectSearch(BoardBean bean);
	Board selectOne(String num);
	
	int insert(BoardBean bean);
	void updateReadcnt(String num);
	int update(BoardBean bean);
	int delete(String num);
}
