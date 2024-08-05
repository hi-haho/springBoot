package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.MemberDto;
import pack.repository.MemberDao;


//@Controller
//@ResponseBody //자바 객체를 json 기반의 http body로 변환 (js입장에서 좋음!)
@RestController // = @ResponseBody + @Controller > restful한 프로그램(비동기), js에서 ajax 요청이 들어오겠구만 
//객체 데이터를 json 형태로 변환해 반환하는 역할
public class MmeberController {

	@Autowired
	private MemberDao dao;
	/*
	@GetMapping("/members") // => 기본 
	public String list(Model model) {
		List<MemberDto> list = dao.getList();
		model.addAttribute("list",list);
		return "list";
	}
	
	@GetMapping("/members") //js가 요청할거야 (js 객체가 오겠지) @ResponseBody를 써야해
	public MemberDto list(Model model) {
		MemberDto dto = new MemberDto();
		dto.setNum(1);
		dto.setName("신형만");
		dto.setAddr("떡잎마을");
		
		return dto;
		//위와 같은 경우, json으로 넘긴다 > 
	}
	
	@GetMapping("/insert")
	public String insert(Model model) {
		List<MemberDto> list = dao.getList();
		model.addAttribute("list",list);
		return "insert";
	}
	
	@PostMapping("/insert")
	public String postInsert(@RequestParam("name") String name,@RequestParam("addr") String addr) {
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		dao.insert(dto);
		return "redirect:/members"; //추가후 목록보기
	}
	
	*/
	// -----------REST 요청 처리----------------------------
	@GetMapping("/members")
	public List<MemberDto> getMem() {
		//DB 자료를 읽어
		//html 파일로 반환 X
		//json형태로 변환해 클라이언트(Javascript Ajax 요청)에 대한 반환
		//System.out.println("Get요청");
		return dao.getList();
	}
	
	@PostMapping("/members") //추가
	public Map<String, Object> postMem(@RequestBody MemberDto dto) {
		//@RequestBody : 요청 본문에 담긴 값(json)을 자바 객체로 변환 (클라이언트(리액트) --넘김--> 서버)
		dao.insert(dto);
		Map<String, Object> insertmap = new HashMap<String, Object>();
		insertmap.put("isSuccess",true);
		return insertmap;
	}
	
	//특정자료 읽기
	@GetMapping("/members/{num}") //http://localhost:80/member/3  ///member/{동적인값(변수명)}
	public MemberDto getMemOne(@PathVariable("num") int num) {
		//@PathVariable : URI 경로의 일부를 파라메터로 받는다.
		return dao.getData(num); //@ResponseBody로 인해 json형태로 넘어간다.
	}
	
	@PutMapping("/members/{num}")
	public Map<String, Object> update(@PathVariable("num") int num,@RequestBody MemberDto dto) { //@PathVariable("num") int num 사용안함
		dto.setNum(num);
		dao.update(dto);
		return Map.of("isSuccess",true);
		//Map.of("isSuccess",true);와 아래코드는 같은 의미
//		Map<String, Object> insertmap = new HashMap<String, Object>();
//		insertmap.put("isSuccess",true);
	}
	
	//자료 삭제
	@DeleteMapping("/members/{num}")
	public Map<String, Object> delete(@PathVariable("num") int num) {
		dao.delete(num);
		return Map.of("isSuccess",true);
	}
}
