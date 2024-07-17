package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
import pack.model.MemberDto;
@Controller
public class UpdateController {
	@Autowired
	private MemberDao dao;
	
	@GetMapping("update") //특정 멤버 읽어야겠지
	public String getupdateProcess(@RequestParam("id")String id,Model model) {
		MemberDto dto = dao.getMember(id);
		model.addAttribute("member",dto);
		return "updateForm";
	}
	
	@PostMapping("update")
	public String postUpdateProcess(MemberBean bean) {
		dao.upData(bean);
		return "redirect:/list";
	}
}
