package pack;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class checkPrice {
	@GetMapping("checkPrice")
	public String price(@RequestParam(value="sang",required=false) String sang, @RequestParam(value="price",required=false) String price, Model model) {
		String res = "상품명 : "+sang +", 가격: "+price+" 원";
		if(Integer.parseInt(price) >= 50000) {
			res+="(고가)";
		}else {
			res +="(저가)";
		}
		model.addAttribute("ress",res);
		return "res";
	}
}
