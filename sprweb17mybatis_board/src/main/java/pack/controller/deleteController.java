package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.BoardDao;

@Controller
public class deleteController {
	@Autowired
	private BoardDao dao;
	
	@RequestMapping("delete")
	public String delete(BoardBean bean) {
		boolean b = dao.deleteData(bean);
		if(b) {
			return "redirect:/list";
		}
		return "error";
	}
}
