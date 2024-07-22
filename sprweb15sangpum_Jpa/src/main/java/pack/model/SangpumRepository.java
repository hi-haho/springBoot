package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SangpumRepository extends JpaRepository<SangpumEntity, Integer> {
	//검색
	//method naming rule : findBy[엔티티명]칼럼명 ,readBy[엔티티명]칼럼명, getBy[엔티티명]칼럼명..
	//findBy변수명and변수명, findBy변수명or변수명, findBy변수명GreaterThanEqual변수명
	
	List<SangpumEntity> findBySangContaining(String svalue); //검색어가 포함된: like'%검색어%'
	List<SangpumEntity> findBySangStartingWith(String svalue); //검색어가 시작된: like'검색어%'
	List<SangpumEntity> findBySangEndingWith(String svalue); //검색어가 끝나는: like'%검색어'
	
	//jpql 사용
	@Query(value="select s from sangdata as s where s.sang like %:svalue%")
	List<SangpumEntity> searchLike(@Param("svalue") String svalue);
}
