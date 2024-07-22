package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class InsertController {
	@Autowired
	private BoardDao dao;
	
	@RequestMapping(value="insert",method=RequestMethod.GET)
	public String insertmethod() {
		return "insertform";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insertSummit(BoardBean bean) {
		boolean b = dao.insertDate(bean);
		if(b) {
			return "redirect:/list";
		}
		return "error";
	}
}
