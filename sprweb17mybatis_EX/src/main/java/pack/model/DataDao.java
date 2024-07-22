package pack.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	//log
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MapInter inter;
	
	/**
	 *  전체 데이터 리스트출력
	 */
	public List<JikwonData> dataAll(){
		ArrayList<JikwonData> list = null;
		try {
			list = (ArrayList<JikwonData>)inter.selectAll();
		}catch (Exception e) {
			logger.info("DataAll err : " + e.getMessage());
		}
		return list;
		
	}
	/**
	 *  특정 부서의 전체 데이터 리스트출력
	 */
	public List<JikwonData> searchAll(String selectBuser){
		ArrayList<JikwonData> list = null;
		try {
			list = (ArrayList<JikwonData>)inter.searchDataAll(selectBuser);
		}catch (Exception e) {
			logger.info("DataAll err : " + e.getMessage());
		}
		return list;
		
	}
	
	/**
	 *  검색 데이터 리스트출력
	 */
	public List<JikwonData> searchData(String selectBuser,String grade){
		ArrayList<JikwonData> list = null;
		try {
			list = (ArrayList<JikwonData>)inter.searchData(selectBuser, grade);
			System.out.println("****" + list);
		} catch (Exception e) {
			logger.info("searchData error : " + e);
		}
		return list;
	}
	
}
