package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MapInter {
	List<JikwonData> selectAll();
	List<JikwonData> searchDataAll(String selectBuser);
	List<JikwonData> searchData(String selectBuser,String grade);
}
