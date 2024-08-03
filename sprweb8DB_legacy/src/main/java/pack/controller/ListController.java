package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.DataDao;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ListController {
	
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("testdb")
	public String listProcess(Model model) {
		ArrayList<DataDao> list = (ArrayList)dataDao.selectAll();
		model.addAttribute("list",list);
		return "list";
	}
	
}
