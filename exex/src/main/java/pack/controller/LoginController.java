package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
	//로그 정보 출력용 클래스
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping("login")
	public String submitCall() { //모델은 적을 수 없다(이는 html임을 잊지말자. html은 값을 받지 못한다.)
		//return "login.html";
		//forwording 하는 방법. 이는 spring에서 기본값이다. 때문에 redirect를 하려면 적어줘야한다.
		return "redirect:login.html";
		//클라이언트를 통해 들어왔기때문에 주소창에서 검색해서 와도된다.
		//return "redirect:http://localhost/login.html";
		
	}
	
	//클라이언트가 전달한 값 수신 방법 (전통적인 방법)
	/*
	@PostMapping("login")
	public String submit(HttpServletRequest request,Model model) {//Model model : jsp로 내보낼 것이다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id +" + "+ pw);
		//LOGGER.info(id +" + "+ pw); //log level : trace > debug > info > warn > error > fatal
		
		String data = "";
		if(id.equals("kor") && pw.equals("111")) {
			data = "로그인 성공";
		}else {
			data="로그인 실패";
		}
		model.addAttribute("data",data);
		return "result"; //forwording
	}
	
	*/
	//클라이언트가 전달한 값 수신 방법(spring annotation)
	
	@PostMapping("login")
	//public String submit(@RequestParam(value="id")String id,@RequestParam(value="pw")String pw, Model model) {
	//public String submit(@RequestParam(value="id")String id,@RequestParam(value="pw", defaultValue = "111")int pw, Model model) {
	public String submit(@RequestParam(value="id")String id,@RequestParam(value="pw")int pw, Model model) {
		String data = "";
		//if(id.equals("kor") && pw.equals("111")) {
		if(id.equals("kor") && pw == 111) {
			data = "로그인 성공";
		}else {
			data="로그인 실패";
		}
		model.addAttribute("data",data);
		return "result";
	}
}
