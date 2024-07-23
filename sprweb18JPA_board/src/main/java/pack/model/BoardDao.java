package pack.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataRepo repo;
	
	//전체자료 읽기
	public List<Board> list(){
		List<Board> list = repo.findAll();
		logger.info("list size : " + list.size());
		return list;
	}
	
	//검색
	public List<Board> search(BoardBean bean){
		List<Board> slist = null;
		if(bean.getSearchName().equals("author")) {
			slist = repo.searchLike(bean.getSearchName());
		}else {
			slist = repo.searchLike2(bean.getSearchValue());
		}
		return slist;
	}
	
	@Transactional //프록시 객체는 해당 메소드가 처리될 때 commit이나 rollback을 수행
	//checkedException 또는 예외가 없는 경우 commit이 수행된다.
	//checkedException이 발생하면 rollback을 수행
	public String insertData(BoardBean bean) {
		try {
			//새글 등록 시 가장 큰번호 얻어 +1
			int max = repo.maxNum();
			
			Board dto = new Board();
			dto.setNum(max+1);
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setBwrite(Timestamp.valueOf(LocalDateTime.now()));
			dto.setReadcnt(0);
			repo.save(dto);
			return "success";
		} catch (Exception e) {
			return "입력 오류 : " + e;
		}
	}
	
	//상세페이지(select지만 조회수가 있어스 @Transactional 사용)
	@Transactional
	public Board detail(int num) {
		//조회수 증가
		repo.updateReadcnt(num);
		//Spring Data JPA를 사용할 때 Repository에서 findById()의 반환값은 Optional 타입
		//Optional<T>: null인 값을 참조해도 NullPointerException(NPE)이 발생하지 않도록 값을 래퍼로 감싸주는 타입.
		Optional<Board> board = repo.findById(num);
		logger.info("board :: {}",board.get());
		if(board.isPresent()) {
			return board.get(); //board를 넘기면 안된다. .get()을 넘겨야 객체값이 넘어간다.
		}else {
			return new Board();
		}
	}
	@Transactional
	public String updateData(BoardBean bean) {
		try {
			//조회수도 수정에 참여하기 위한 선행 작업
			Optional<Board> board = repo.findById(bean.getNum());
			Board imsi = board.get();
			/*
			Board dto = new Board();
			dto.setNum(bean.getNum()); //이미 등록된 번호이기에 수정 처리될 것
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			//dto.setBwrite(Timestamp.valueOf(LocalDateTime.now()));
			dto.setReadcnt(imsi.getReadcnt());
			repo.save(dto);
			*/
			imsi.setAuthor(bean.getAuthor());
			imsi.setTitle(bean.getTitle());
			imsi.setContent(bean.getContent());
			//imsi.setReadcnt(imsi.getReadcnt());
			return "success";
		} catch (Exception e) {
			return "수정 오류 : " + e;
		}
	}
	
	@Transactional
	public String deleteData(int num) {
		try {
			repo.deleteById(num);
			return "success";
		} catch (Exception e) {
			return "삭제 오류 : " + e;
		}
	}
	
}
