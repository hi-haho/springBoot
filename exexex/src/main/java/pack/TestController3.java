package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController3 { //웹(많은 요청에 객체를 모두 만들면 서버 죽는다.)이기 때문에 싱글톤이다.
	@RequestMapping("/java/korea")
	public String ghi(Model model) {
		model.addAttribute("msg","get 성공 /java/korea");
		return "list";
	}
	
	@RequestMapping(value={"/java/good","/nice","/ok"})
	public String ghi2(Model model) {
		model.addAttribute("msg","java/good 과 nice과 ok 를 값은 같은 곳으로");
		return "list";
	}
}
