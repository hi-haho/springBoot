package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private SangpumRepository repository;
	
	//전체 자료 읽기
	public List<SangpumEntity> getDataAll(){
		List<SangpumEntity> list = repository.findAll(); //jpa spring 기본 제공
		return list;
	}
	
	//특정 자료 읽기
	/*
	public List<SangpumEntity> getSearchValue(String svalue){
		List<SangpumEntity> list = repository.findBySangContaining(svalue);
		System.out.println("list 수 : " + list.size());
		return list;
	}
	*/
	//특정 자료 읽기 - jpql(직접 sql문 작성)
	public List<SangpumEntity> getSearchValue(String svalue){
		List<SangpumEntity> list = repository.searchLike(svalue);
		System.out.println("list 수 : " + list.size());
		return list;
	}
	/*
	public List<SangpumEntity> findBySangStartingWith(String svalue){
		List<SangpumEntity> list = repository.findBySangStartingWith(svalue);
		System.out.println("list 수 : " + list.size());
		return list;
	}
	*/
	
}
