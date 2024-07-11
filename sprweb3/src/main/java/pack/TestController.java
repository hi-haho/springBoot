package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller //사용자의 요청을 받아 처리한 후 지정된 뷰(템플릿엔진/jsp..)에 모델 객체를 넘겨주는 역할
public class TestController {
	@RequestMapping("test1") //get 방식과 post방식 모두 처리
	public ModelAndView haha() {
		//System.out.println("haha 처리");
		//return null;
		//return new ModelAndView("list","msg", "안녕! jsp?");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		//addObject() = request.setAttribute("msg", "안녕! jsp?");
		//httpServletRequest를 사용해 키,값으로 jsp에 전송
		modelAndView.addObject("msg", "안녕! jsp?");
		return modelAndView;
	}
	
	@RequestMapping(value="test2",method=RequestMethod.GET) //get 요청처리
	public ModelAndView hoho() {
		return new ModelAndView("list","msg", "안녕!?");
	}
	
	@GetMapping("test3") //get 요청 처리
	public ModelAndView hehe() {
		return new ModelAndView("list","msg", "안녕! 123");
	}
	
	@GetMapping("test4") //get 요청 처리
	public String hyhy(Model model) {
		model.addAttribute("msg","성공이다!! 4번째!!"); //model에 직접 값을 넣어놨다.
		return "list";
	}
	
	@RequestMapping(value="test5",method=RequestMethod.POST) // status=405 요청 다름
	public ModelAndView heyhey() {
		return new ModelAndView("list","msg", "안녕!?5번 성공");
	}
	
	@PostMapping("test6") //get 요청 처리
	public ModelAndView haho() {
		 //model에 직접 값을 넣어놨다.
		return new ModelAndView("list","msg", "벌써.. 6번 성공");
	}
	
	@PostMapping("test7") //get 요청 처리
	public String hahahoho(Model model) {
		//파일명(viewfileName)을 넘기는 것이다. 단순한 String이 아님. 어노테이션
		model.addAttribute("msg", "행운의 7");
		return "list";
	}
	
	@GetMapping("test8")
	@ResponseBody //일반 data를 그대로 전달
	public String hihi() { //순수 String
		String value = "일반 데이터 - String, Map, JSON등을 전달 가능";
		return value;
	}
	
	@GetMapping("test8_1")
	@ResponseBody //일반 data를 그대로 전달 (json)
	public DataDto hihi8_1() { //순수 String
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("하하호호");
		return dto; //json 형태로 return(library 中 jackson 지원)
	}
}
