package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDto;
import pack.model.DataProcess;

@Controller
public class MemController {

	@Autowired
	private DataProcess process;

	@GetMapping("/")
	public String start() {
		return "start";
	}

	@GetMapping("/list")
	public String list(Model model) { // model이 request를 지원하고 있다.
		ArrayList<DataDto> list = (ArrayList<DataDto>) process.getDataAll();
		model.addAttribute("list", list);
		return "list";
	}
	//------- insert -------
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}

	@PostMapping("insert")
	public String insertprocess(DataBean bean) {
		boolean b = process.insertData(bean);
		if (b)
			return "redirect:list";
		else
			return "redirect:error";
	}
	// ------------------------
	// --------- update ---------
	@GetMapping("update")
	public String getUp(@RequestParam("num") String num, Model model) {
		DataDto dto = process.selectOne(num);
		model.addAttribute("dto", dto);
		return "updateForm";
	}

	@PostMapping("update")
	public String posttUpdate(DataBean bean) {
		boolean b = process.update(bean);
		if (b)
			return "redirect:list";
		else
			return "redirect:error";
	}
	// ------------------------
	// --------- delete ---------
	@GetMapping("delete")
	public String del(@RequestParam("num") String num) {
		process.delete(num);
		return "redirect:list";
	}

	@GetMapping("pathr")
	public String error() {
		return "error";
	}

}
