package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMappingInter {
	
	//@Select("select jikwon_no as jikwonNo,jikwon_name as jikwonName,jikwon_gen as jikwonGen,jikwon_pay as jikwonPay from jikwon where jikwon_jik = #{jik}")
	@Select("select jikwon_no ,jikwon_name ,jikwon_gen,jikwon_pay from jikwon where jikwon_jik = #{jik}")
	@Results(id="jikwonMap",value= {
			@Result(property ="jikwonNo", column = "jikwon_no"),
			@Result(property ="jikwonName", column = "jikwon_name"),
			@Result(property ="jikwonGen", column = "jikwon_gen"),
			@Result(property ="jikwonPay", column = "jikwon_pay")
	})
	List<JikwonDto> selectJik(String jik);
}
