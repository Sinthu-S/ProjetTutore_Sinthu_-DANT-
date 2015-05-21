package controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import modelRepository.*;


@Controller
public class PageRouteController {
	
	@RequestMapping("/home")
	 public String home() {
	  return "index";
	 }
	
	@RequestMapping("/login")
	 public String login() {
	  return "login";
	 }

}
