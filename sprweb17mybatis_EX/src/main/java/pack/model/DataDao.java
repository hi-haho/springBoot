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
	public List<JikwonData> data(String buserNum, String rating){
		ArrayList<JikwonData> list = null;
		try {
			if(rating.equals("all")) {
				list = (ArrayList<JikwonData>)inter.searchDataAll(buserNum);
			} else {				
				list = (ArrayList<JikwonData>)inter.searchData(buserNum, rating);
			}
		} catch (Exception e) {
			logger.info("list err : " + e);
		}
		return list;
	}
}
