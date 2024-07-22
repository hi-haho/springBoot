package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.DataDao;
import pack.model.JikwonData;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class JikController {
	@Autowired
	public DataDao dao;
	
	//---------------- select ------------
	@PostMapping("select")
	public String postMethodName(@RequestParam("selectBuser") String selectBuser,@RequestParam("grade") String grade,Model model) {
		if(grade.equals("all")) {
			ArrayList<JikwonData> list = (ArrayList<JikwonData>)dao.searchAll(selectBuser);
			model.addAttribute("list",list);
		}else {
			ArrayList<JikwonData> list = (ArrayList<JikwonData>)dao.searchData(selectBuser, grade);
			model.addAttribute("list",list);
		}
		return "list";
	}
	
}
