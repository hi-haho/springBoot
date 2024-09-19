package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.Friend;
import pack.FriendService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class WebController {
	
	@GetMapping("/")
	  public String getStart() {
	      return "start";
	  }
	
	@Autowired
	private FriendService friendService;
	
	@GetMapping("/list")
    public String getShowList(Model model) {
        List<Friend> friends = friendService.findAll();
        model.addAttribute("friends", friends);
        return "list";
    }
	
	@GetMapping("/login")
	public String getMethodName() {
		return "login";
	}
	
}
