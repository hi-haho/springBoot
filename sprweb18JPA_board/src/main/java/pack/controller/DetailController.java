package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.Board;
import pack.model.BoardDao;
@Controller
public class DetailController {
	@Autowired
	private BoardDao dao;
	
	@RequestMapping("detail")
	public String detail(@RequestParam("num")int num, Model model) {
		Board dto = dao.detail(num);
		model.addAttribute("dto",dto);
		return "detail";
	}
}
