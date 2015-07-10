package controller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controller.service.DeveloppeurService;
import controller.service.UserService;


@RestController
@RequestMapping("/developpeur")
public class DeveloppeurController {

	private final DeveloppeurService serviceUser;


	@Autowired
	public DeveloppeurController(DeveloppeurService serviceUser) {
		super();
		this.serviceUser = serviceUser;
		
	}
	
	@RequestMapping(value="/listDev/{loginManager}/", method = RequestMethod.GET)
	List getStat(@PathVariable("loginManager") String loginManager){
		return this.serviceUser.listDev(loginManager);
	}
}
