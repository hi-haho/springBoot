package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.MemberDao;

@Controller
public class insertController {
	@Autowired
	private MemberDao dao;
	/*
	@ModelAttribute("command")
	public MemberBean formBack() {
		return new MemberBean();
	}
	*/
	@GetMapping("insert")
	public String dada() {
		return "insform";
	}
	
	@PostMapping("insert")
	public String submit(MemberBean bean) {
		dao.insData(bean);
		//return "list"; //바로 보내면 예전 화면이 보인다.(추가되 내용이 안보인다.) =>forwarding을 하면 안된다.
		return "redirect:list"; //추가 후 목록보기 (다시 listController를 만나야한다!)
	}
}
