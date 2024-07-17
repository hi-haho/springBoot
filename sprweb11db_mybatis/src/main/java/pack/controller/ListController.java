package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.DataDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dao;
	
	@GetMapping("mybatis")
	public String list(Model model) {
		ArrayList<DataDto> list = (ArrayList<DataDto>)dao.getDataAll();
		model.addAttribute("list",list);
		return "list";
	}
	
	@GetMapping("search")
	public String search(FormBean bean, Model model) {
		ArrayList<DataDto> list = (ArrayList<DataDto>)dao.getDataSearch(bean);
		model.addAttribute("list",list);
		return "list";
	}
}
