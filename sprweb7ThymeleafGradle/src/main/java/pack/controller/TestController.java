package pack.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping(value="thleaf")
public class TestController {
	@GetMapping("/ex1")
	public String haha(Model model) {
		ItemDto dto = new ItemDto();
		dto.setId("ksh");
		dto.setName("인형");
		dto.setRegDate(LocalDate.now());
		dto.setPrice(3000);
		model.addAttribute("dto",dto);
		return "show1"; //forward: 기본값
	}
	
	@GetMapping("/ex2")
	public String method2(Model model) {
		List<ItemDto> list = new ArrayList<ItemDto>();
		
		for(int i = 1 ; i <= 3 ; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("item" + i);
			dto.setName("name" + i);
			dto.setPrice(1000 * i);
			dto.setRegDate(LocalDate.now());
			list.add(dto);
		}
		
		model.addAttribute("list", list);
		return "show2";
	}

	@GetMapping("/ex3")
	public ModelAndView method3() { // ModelAndView는 구식~!~!
		ModelAndView mav = new ModelAndView();
		List<ItemDto> list = new ArrayList<ItemDto>();
		
		for(int i = 1 ; i <= 5 ; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("item" + i);
			dto.setName("name" + i);
			dto.setPrice(1000 * i);
			dto.setRegDate(LocalDate.now());
			list.add(dto);
		}
		
		mav.setViewName("show3");
		return mav.addObject("list", list);
	}
	
	@GetMapping("/ex4")
	public String method4(Model model,@RequestParam("haha1") String haha1,@RequestParam("haha2") String haha2) {
		System.out.println(haha1);
		System.out.println(haha2);
		model.addAttribute("gaga1",haha1);
		model.addAttribute("gaga2",haha2);
		return "show4";
	}

}
