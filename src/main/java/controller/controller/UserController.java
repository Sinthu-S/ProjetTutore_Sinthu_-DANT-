package controller.controller;

import java.util.ArrayList;
import java.util.UUID;

import models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controller.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	UserService serviceUser;


	@Autowired
	public UserController(UserService serviceUser) {
		super();
		this.serviceUser = serviceUser;
	}


	@RequestMapping(value="/inscription/{nom}/{prenom}/{service}/{typeUser}/{login}/{pass}")
	void inscription(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom, @PathVariable("service") String service, @PathVariable("typeUser") String typeUser, @PathVariable("login") String login, @PathVariable("pass") String pass){
		User userTmp=new User(nom, prenom, service, typeUser, login, pass, new ArrayList(), new ArrayList());
		this.serviceUser.inscription(userTmp);
	}

	@RequestMapping(value="/connexion/{login}/{pass}", method = RequestMethod.GET)
	User connexion(@PathVariable("login") String login, @PathVariable("pass") String pass){  
		System.out.println("Login");
		User tmp=this.serviceUser.connexion(login, pass);
		tmp.token=UUID.randomUUID().toString();
		this.serviceUser.majUser(tmp);
		return tmp;
	}
	
	@RequestMapping(value="/token/{token}", method = RequestMethod.GET)
	User initialise(@PathVariable("token") String token){  
	return this.serviceUser.initialise(token);
	}
}
