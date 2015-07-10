package controller.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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


	@RequestMapping(value="/inscription/{nom}/{prenom}/{service}/{typeUser}/{email}/{login}/{pass}/", method = RequestMethod.GET)
	void inscription(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom, @PathVariable("service") String service, @PathVariable("typeUser") String typeUser, @PathVariable("email") String email, @PathVariable("login") String login, @PathVariable("pass") String pass){
		User userTmp=new User(nom, prenom, service, typeUser,email, login, pass, new ArrayList(), new ArrayList());
		this.serviceUser.inscription(userTmp);
	}
	
	@RequestMapping(value="/modification/{nom}/{prenom}/{service}/{email}/{login}/", method = RequestMethod.GET)
	void modification(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom, @PathVariable("service") String service, @PathVariable("email") String email, @PathVariable("login") String login){
		System.out.println("modification"+login);
		this.serviceUser.modification(login, nom, prenom, service, email);
	}

	@RequestMapping(value="/suppression/{login}/", method = RequestMethod.GET)
	void suppression( @PathVariable("login") String login){
		System.out.println("Suppression"+ login);
		this.serviceUser.suppression(login);
	}

	@RequestMapping(value="/connexion/{login}/{pass}/", method = RequestMethod.GET)
	User connexion(@PathVariable("login") String login, @PathVariable("pass") String pass){  
		System.out.println("Login");
		User tmp=this.serviceUser.connexion(login, pass);
		if(tmp!=null){
		tmp.token=UUID.randomUUID().toString();
		this.serviceUser.majUser(tmp);
		}
		return tmp;
	}
	
	@RequestMapping(value="/token/{token}/", method = RequestMethod.GET)
	User initialise(@PathVariable("token") String token){ 
		System.out.println(this.serviceUser.initialise(token));
	return this.serviceUser.initialise(token);
	}
	
	@RequestMapping(value="/deconnexion/{token}", method = RequestMethod.GET)
	void deconnexion(@PathVariable("token") String token){
		this.serviceUser.deconnexion(token);
		System.out.println("deconnexion");
		
	}
	
	@RequestMapping(value="/stat", method = RequestMethod.GET)
	List getStat(){
		System.out.println(this.serviceUser.getStat());
		return this.serviceUser.getStat();
	}
	
	
}
