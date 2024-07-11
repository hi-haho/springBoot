package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test9")
public class TestController2 {
	@RequestMapping(method= RequestMethod.GET)
	//HttpServletRequest 객체에 값을 저장 후 뷰에 전달
	public String def1(Model model) {
		model.addAttribute("msg","get 성공");
		return "list"; //파일명으로 포워딩하고 있다.
		//서버의 파일을 찾아서 push하고 있는 것!
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public String def2(Model model) {
		model.addAttribute("msg","post 성공");
		return "list"; //파일명으로 사용
	}
}
