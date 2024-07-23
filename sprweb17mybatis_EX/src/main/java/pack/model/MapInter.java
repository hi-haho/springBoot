package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MapInter {
	List<JikwonData> selectAll();
	List<JikwonData> searchDataAll(@Param("selectBuser") String selectBuser);
	List<JikwonData> searchData(@Param("selectBuser")String selectBuser,@Param("grade")String grade);
}
