package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.MemberDao;
import pack.model.MemberDto;


@Controller
public class ListController {
	@Autowired
	private MemberDao dao;
	
	@GetMapping("list")
	public String getMethod(Model model) {
		List<MemberDto> list = dao.getMemberList();
		model.addAttribute("list",list);
		return "list";
	}
	
}
