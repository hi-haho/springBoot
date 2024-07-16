package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.JikwonDao;
import pack.model.JikwonDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JikwonController {
	@Autowired
	public JikwonDao dao;
	
	@GetMapping("jik")
	public String getMethod(@RequestParam("jikwon") String jik,Model model) {
		List<JikwonDto> list =dao.jikList(jik);
		model.addAttribute("list",list);
		return "list";
	}
	
}
