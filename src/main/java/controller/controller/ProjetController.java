package controller.controller;

import java.util.List;

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
@RequestMapping("/projet")
public class ProjetController {

	private final ProjetService service;

	@Autowired
	ProjetController(ProjetService service) {
		this.service = service;
	}
	

	@RequestMapping(value="/{nom}/{client}/{manager}/", method = RequestMethod.GET)
	void ajoutProjet(@PathVariable("nom") String nom, @PathVariable("client") String client, @PathVariable("manager") String manager){  
		this.service.ajoutProjet(new Projet(nom,client,manager));
		

	}
	
	@RequestMapping(value="/all/", method = RequestMethod.GET)
	List<Projet> projets(){
		System.out.println(this.service.projetsGet());
		return this.service.projetsGet();
	}
	
	@RequestMapping(value="/all/manager/{login}/", method = RequestMethod.GET)
	List<Projet> projetsParManager(@PathVariable("login") String login){
		System.out.println(login +  "" + this.service.projetParManager(login));
		return this.service.projetParManager(login);
	}
	
	@RequestMapping(value="/all/client/{login}/", method = RequestMethod.GET)
	List<Projet> projetsParClient(@PathVariable("login") String login){
		System.out.println(login +  "" + this.service.projetParManager(login));
		return this.service.projetParClient(login);
	}
	
	
	@RequestMapping(value="/add/{projet}/{titre}/{description}/{service}/{techno}/", method = RequestMethod.GET)
	void ajoutDemande(@PathVariable("projet") String projet, @PathVariable("titre") String titre, @PathVariable("description") String description, @PathVariable("service") String service, @PathVariable("techno") String techno
			){
		System.out.println("  nom projet :"+projet);
		this.service.ajoutDemande(projet, new Task(titre,description,service,techno));
		
	}
	
	@RequestMapping(value="/maj/{nomProjet}/{indice}/{nom}/{comment}/{progress}/{dev}/", method = RequestMethod.GET)
	void majProjet(@PathVariable("nomProjet") String nomprojet,@PathVariable("indice") int i, @PathVariable("nom") String nom, @PathVariable("comment") String comment, @PathVariable("progress") int progress, @PathVariable("dev") String dev){
		this.service.majProjet(nomprojet, i, nom, comment, progress,dev);
		
	}
	
	@RequestMapping(value="/maj/{nomProjet}/{indice}/{nom}/{comment}/{progress}/", method = RequestMethod.GET)
	void majProjet(@PathVariable("nomProjet") String nomprojet,@PathVariable("indice") int i, @PathVariable("nom") String nom, @PathVariable("comment") String comment, @PathVariable("progress") int progress){
		this.service.majProjet(nomprojet, i, nom, comment, progress);
		
	}
}
