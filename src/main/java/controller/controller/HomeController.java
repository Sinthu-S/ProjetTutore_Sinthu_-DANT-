package controller.controller;

import modelRepository.*;
import models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import controller.service.ProjetService;


@RestController
@RequestMapping("/tasks")
public class HomeController {

	private final ProjetService service;

	@Autowired
	HomeController(ProjetService service) {
		this.service = service;
	}
	

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	void save(@PathVariable("id") String id){  
		System.out.println("Controller");
		Projet p=new Projet(id);
		service.save(p);
		System.out.println(service.find(id));
		System.out.println("fait");
		

	}

	@RequestMapping(method = RequestMethod.GET)
	void rep(){  
		System.out.println("Controller");
		System.out.println("fait");
		

	}
}
