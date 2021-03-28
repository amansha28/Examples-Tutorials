package springinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

	@RequestMapping(path = "/home")
	public String homeHandler() {
		return "home";
	}

	@RequestMapping(path = "/processForm")
	public String processFormHandler(@RequestParam("username") String username, Model m) {
		System.out.println("username : " + username);
		m.addAttribute("username", username);
		return "result";
	}

	@RequestMapping(path = "/anotherhome")
	public String anotherHomeHandler() {
		return "anotherhome";
	}

	@RequestMapping(path = "/processForm1")
	public String processFormHandler1(@RequestParam("username") String username, Model m) {
		System.out.println("username : " + username);
		m.addAttribute("username", username);
		return "result";
	}
}
