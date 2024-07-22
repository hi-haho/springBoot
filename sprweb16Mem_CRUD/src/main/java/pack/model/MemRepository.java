package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemRepository extends JpaRepository<MemEntity, Integer>{
	
	//num 가장 큰값(자동 증가)
	//@Query(value="select max(m.num) from Mem as m")
//	@Query(value="select max(num) from mem",nativeQuery = true)
	//int findByMaxNum();
	
	//1개 찾기 (jpql-jpa안에서만 사용되는 클래스(테이블) Mem/논리적 테이블X 물리테이블 사용해야한다.)
	@Query(value="select m from MemEntity as m where m.num=?1")
	MemEntity findByNum(String num);
	
}
