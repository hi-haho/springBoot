package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao {
	@Autowired
	private DataMappingInter inter;
	
	public List<JikwonDto> getListJik(String jik){
		List<JikwonDto> list = inter.selectJik(jik);
		return list;
	}
}
