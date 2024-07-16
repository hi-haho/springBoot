package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.DataDao;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JikController {
	@Autowired
	private DataDao dataDao;
	
	@PostMapping("jik")
	public String getMethod(@RequestParam(value="jikwon")String jikwon,Model model) {
		ArrayList<DataDao> list = (ArrayList)dataDao.JikData(jikwon);
		model.addAttribute("list",list);
		return "list";
	}
	
}
