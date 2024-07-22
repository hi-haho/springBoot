package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.MemEntity;

@Controller
public class MemController {
	@Autowired
	DataProcess process;

	@GetMapping("/")
	public String main() {
		return "start";
	}

	@GetMapping("list")
	public String list(Model model) {
		ArrayList<MemEntity> list = (ArrayList<MemEntity>) process.getDataAll();
		model.addAttribute("list", list);
		return "list";
	}

	// ------- insert -------
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}

	@PostMapping("insert")
	public String insertprocess(MemBean bean,Model model) {
		String msg = process.insertData(bean);
		
		if (msg.equals("success"))
			return "redirect:/list";
		else {
			model.addAttribute("msg",msg);
			return "error";
		}
	}
	
	// ------------------------
	// ------------update------------
	
	@GetMapping("update")
	public String updateMethod(@RequestParam("num")String num, Model model) {
		//System.out.println("updateMethod num : " + num);
		MemEntity dto = process.getData(num);
		model.addAttribute("dto",dto);
		return "updateForm";
	}
	
	@PostMapping("update")
	public String updetePost(MemBean bean,Model model) {
		String msg = process.upData(bean);
		if (msg.equals("success"))
			return "redirect:/list";
		else {
			model.addAttribute("msg",msg);
			return "error";
		}
	}

	// -----------delete-------------
	@GetMapping("delete")
	public String deleteMethod(@RequestParam("num")int num, Model model) {
		String msg = process.delete(num);
		
		if (msg.equals("success"))
			return "redirect:/list";
		else {
			model.addAttribute("msg",msg);
			return "error";
		}
	}
	
	// -----------error-------------
	@GetMapping("pathr")
	public String error() {
		return "error";
	}
	// ------------------------
}
