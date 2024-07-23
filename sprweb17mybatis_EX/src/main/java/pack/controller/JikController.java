package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.DataDao;
import pack.model.JikwonData;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JikController {
	@Autowired
	public DataDao dao;

	// ---------------- select ------------
	@PostMapping("select")
	public String postMethodName(@RequestParam("selectBuser") String selectBuser, @RequestParam("grade") String grade,
			Model model) {
		List<JikwonData> list = dao.data(selectBuser, grade);
		model.addAttribute("list", list);

		// 연봉 평균 구하기
		double avgPay = 0;
		for (JikwonData j : list) {
			avgPay += j.getJikwon_pay();
		}
		avgPay = Math.round((avgPay / list.size()) * 100) / 100.0; // 소수점 이하 세번째에서 반올림
		model.addAttribute("avg", avgPay);

		return "list";
	}

}
