package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
	
	@GetMapping("thymeleaf")
	public String haha(Model model) { //model과 view를 분리한 것
		model.addAttribute("msg","타임리프랍니다.");
		model.addAttribute("msg2","(❁´◡`❁)");
		model.addAttribute("msg3","(●'◡'●)");
		
		//DTO 자료 출력용
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("삼다수");
		sangpum.setSu("3");
		sangpum.setDan("1000");
		model.addAttribute("sangpum",sangpum);
		
		ArrayList<Sangpum> list = new ArrayList<Sangpum>();
		list.add(sangpum);
		
		sangpum = new Sangpum();
		sangpum.setCode("20");
		sangpum.setSang("죠리퐁");
		sangpum.setSu("10");
		sangpum.setDan("2000");
		list.add(sangpum);
		
		model.addAttribute("list",list);
		
		return "list1"; //forwarding (templates 파일을 찾아간다. 이때 확장자는 .html이다.)
	}
	
}
