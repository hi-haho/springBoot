package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JsonController2 {
	@GetMapping("list2")
	@ResponseBody
	public Map<String, Object> getJsons() {
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "짱구");
		data.put("age", "22");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "철수");
		data.put("age", "22");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "유리");
		data.put("age", "22");
		dataList.add(data);
		
//		return dataList;
		Map<String, Object> data2 = new HashMap<String, Object>();
		//[{name=짱구, age=22}, {name=철수, age=22}, {name=유리, age=22}]
		data2.put("datas", dataList); 
//		System.out.println(dataList);
//		@ResponseBody 에 의해 json 형식(키벨류)의 문자열로 바뀐다.
//		{"datas":[{"name":"짱구","age":"22"},{"name":"철수","age":"22"},{"name":"유리","age":"22"}]}
		return data2;
	}
	
}
