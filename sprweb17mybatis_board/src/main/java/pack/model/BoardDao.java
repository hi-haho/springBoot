package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMapInter dataMapInter;
	
	public List<Board> list(){
		List<Board> list = null;
		try {
			list = dataMapInter.selectList();
		} catch (Exception e) {
			logger.info("list err : " + e.getMessage());
		}
		return list;
	}
	
	public boolean insertDate(BoardBean bean) {
		boolean b = false;
		int re = dataMapInter.insert(bean);
		if(re > 0) return true; 
		return b;
	}
	
	public List<Board> search(BoardBean bean){
		List<Board> slist = dataMapInter.selectSearch(bean);
		return slist;
	}
	
	public Board detail(String num) {
		//조회수 증가
		dataMapInter.updateReadcnt(num);
		//상세보기 처리
		Board board = dataMapInter.selectOne(num);
		return board;
	}
	
	public boolean updateData(BoardBean bean) {
		boolean b = false;
		int re = dataMapInter.update(bean);
		if(re > 0) return true; 
		return b;
	}
	
	public boolean deleteData(BoardBean bean) {
		boolean b = false;
		int re = dataMapInter.delete(Integer.toString(bean.getNum()));
		if(re > 0) return true; 
		return b;
	}
}
