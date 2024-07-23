package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DataRepo extends JpaRepository<Board, Integer> {
	// jpql
	// 검색용
	// 작가별
	@Query(value = "select b from Board as b where b.author like %?1%") // 위치기반
	List<Board> searchLike(String searchValue);

	// 제목별
	@Query(value = "select b from Board b where b.title like %:searchValue%") // 이름기반
	List<Board> searchLike2(@Param("searchValue") String searchValue);

	// 추가할 때 가장 큰 번호 얻기
	@Query("select max(b.num) from Board b")
	int maxNum();

	// @Query 어노테이션을 통해 작성된 변경이 일어나는 쿼리(INSERT, DELETE, UPDATE )를 실행할 때 사용
	// 벌크 연산 : jpa는 내부적으로 벌크 연산을 한다.
	// 여러 건(대량의 데이터)을 한 번에 수정하거나 삭제하는 방법
	// 벌크 연산은 영속성 컨텍스트와 2차 캐시를 무시하고 데이터베이스에 직접 쿼리한다는 점을 주의
	// 영속성 컨텍스트와 데이터베이스 간에 데이터 차이 발생
	// 해결방법 _ 1)em.refresh() 2)벌크 연산 먼저 실행(가장 실용적) 3)벌크 연산 수행 후 영속성 컨텍스트 초기화

	// 상세보기 할 때 조회수 증가 (벌크연산_jpa) > 영속성 컨텍스트에 있는 Board와 DB에 있는 Board의 값이 다를 수 있다.
	// 벌크 연산 수행 후 연속성 컨텍스트에 있는 쿼리를 refresh해야한다.
	@Modifying(clearAutomatically = true) // 1차 캐시를 비워주는 설정, 영속성 컨텍스트에 있는 쿼리를 초기화
	@Query(value = "update Board bo set bo.readcnt=bo.readcnt+1 where bo.num=?1")
	void updateReadcnt(int num);

	/*
	  JPA에서 조회를 실행할 시에 1차 캐시를 확인해서 해당 엔티티가 1차 캐시에 존재한다면 DB에 접근하지 않고, 1차 캐시에 있는 엔티티를
	  반환한다. 하지만 벌크 연산은 1차 캐시를 포함한 영속성 컨텍스트를 무시하고 바로 Query를 실행하기 때문에 영속성 컨텍스트는 데이터
	  변경을 알 수가 없다. 즉, 벌크 연산 실행 시, 1차 캐시(영속성 컨텍스트)와 DB의 데이터 싱크가 맞지 않게 되는 것이다.
	 */
}
