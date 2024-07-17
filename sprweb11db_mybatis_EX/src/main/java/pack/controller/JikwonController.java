package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.JikwonDao;
import pack.model.JikwonDto;

@Controller
public class JikwonController {
	@Autowired
	JikwonDao dao;
	
	@GetMapping("/") ///resources/templates에 html이 있는 경우
	public String start() {
		return "index";
	}
	
	@GetMapping("jik")
	public String jikList(@RequestParam("jikwon") String jik,Model model) {
		List<JikwonDto> list = dao.getListJik(jik);
		//System.out.println(list);
		model.addAttribute("list",list);
		return "list";
	}
}
