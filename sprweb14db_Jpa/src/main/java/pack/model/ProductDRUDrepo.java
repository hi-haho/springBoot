package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductDRUDrepo extends JpaRepository<Product, Integer> {
//	CrudRepository > PagingAndSortingRepository > *JpaRepositoty*
	
	//메소드 이름으로 쿼리 생성 방법 : fird + (엔티티 이름 ) + By + 변수이름
	//엔티티 이름(1개인 경우)은 생략 가능
	Product findByCode(Integer code);
	
	//jpql product(엔티티) 물리적 이름을 사용해야한다.
	@Query(value="select p from Product as p")
	List<Product> findAllData();
	
	//where 조건
	@Query(value="select p from Product as p where p.code=:code") //이름기반
	Product findByCodeMy(@Param("code") int code);
	
	@Query(value="select p from Product as p where p.code=?1") //순서기반
	Product findByCodeMy2(int code);
	
	@Query(value="select p from Product as p where p.code=?1 or p.sang=?2") //순서기반
	List<Product> findByData(int code,String sang);
	
	//native query : sql벤더마다 sql문이 달라진다. native는 최대한 자제해야한다.(jpa의 장점을 못살린다.)
	@Query(value="select code,sang,su,dan from prod where code <=5", nativeQuery=true)
	List<Product> findAllData2();
}