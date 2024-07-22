package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class FormController {
	
	@GetMapping("formController")
	public String nameAge(@RequestParam("name") String name,@RequestParam("age") int age,Model model) {
		String res = name+"님은 ";
		if(age == 10) {
			res += "십대";
		}else if(age == 20) {
			res += "이십대";
		}else if(age == 30) {
			res += "삼십대";
		}else if(age == 40) {
			res += "사십대";
		}else if(age == 50) {
			res += "오십대";
		}else {
			res += "육십대 이상";
		}
		model.addAttribute("res",res);
		return "result";
	}
}
