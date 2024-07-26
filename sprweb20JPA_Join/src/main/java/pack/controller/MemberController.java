package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.Memberdto;
import pack.service.MemberServiceInter;



@Controller
public class MemberController {
	@Autowired
	private MemberServiceInter serviceInter;
	
	@GetMapping("/member/mlist")
	public String getMethodName(Model model) {
		serviceInter.getList(model);
		return "member/mlist";
	}
	
	//-------자료 추가---------
	@GetMapping("/member/insertform")
	public String getInsert() {
		return "member/insertform";
	}
	
	@PostMapping("/member/insert")
	public String poetInsert(Memberdto fbean) {
		serviceInter.insert(fbean);
		return "member/insert";
	}
	//---------------
	
	//-------수정---------
	@GetMapping("/member/updateform")
	public String getUpdate(@RequestParam("num")Long num,Model model) {
		serviceInter.getdata(num,model);
		return "member/updateform";
	}
	@PostMapping("/member/update")
	public String poetUpdate(Memberdto fbean) {
		//serviceInter.update(fbean);
		serviceInter.update2(fbean);
		return "member/update";
	}
	//-------------
	
	//------ 삭제---------
	@GetMapping("/member/delete")
	public String getDelete(@RequestParam("num")Long num) {
		serviceInter.delete(num);
		return "redirect:/member/mlist";
	}
}
