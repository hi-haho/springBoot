package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.SangpumEntity;


@Controller
public class TestController {
	
	@Autowired
	private DataDao dao;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("testjpa")
	public String list(Model model) {
		ArrayList<SangpumEntity> list = (ArrayList<SangpumEntity>)dao.getDataAll();
		model.addAttribute("list",list);
		return "list";
	}
	
	@GetMapping("search")
	public String searchList(Bean bean,Model model) {
		ArrayList<SangpumEntity> list = (ArrayList<SangpumEntity>)dao.getSearchValue(bean.getSearchValue());
		model.addAttribute("list",list);
		return "list";
	}
}
