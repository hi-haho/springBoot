package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
@Controller
public class DeleteController {

	@Autowired
	MemberDao dao;
	
	@GetMapping("/delete")
	public String delDate(@RequestParam("id") String id,Model model) {
		dao.delete(id);
		return "redirect:list";
	}
}
