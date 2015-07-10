package controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import modelRepository.*;


@Controller
public class PageRouteController {
	
	@RequestMapping("/homeAdmin")
	 public String homeAdmin() {
	  return "homeAdmin";
	 }
	
	@RequestMapping("/homeChefDeProjet")
	 public String homeChefDeProjet() {
	  return "homeChefDeProjet";
	 }
	
	@RequestMapping("/homeClient")
	 public String homeClient() {
	  return "homeClient";
	 }
	
	@RequestMapping("/homeDeveloppeur")
	 public String homeDeveloppeur() {
	  return "homeDeveloppeur";
	 }
	@RequestMapping("/gestionChefDeProjet")
	 public String gestionChefDeProjet() {
	  return "gestionChefDeProjet";
	 }
	@RequestMapping("/gestionClient")
	 public String gestionClient() {
	  return "gestionClient";
	 }
	@RequestMapping("/gestionDeveloppeur")
	 public String gestionDeveloppeur() {
	  return "gestionDeveloppeur";
	 }
	@RequestMapping("/gestionProjet")
	 public String gestionProjet() {
	  return "gestionProjet";
	 }
	@RequestMapping("/gestionProjetDemande")
	 public String gestionProjetDemande() {
	  return "gestionProjetDemande";
	 }
	
	@RequestMapping("/gestionProjetDemandeDev")
	 public String gestionProjetDemandeDev() {
	  return "gestionProjetDemandeDev";
	 }
	
	@RequestMapping("/gestionProjetDemandeClient")
	 public String gestionProjetDemandeClient() {
	  return "gestionProjetDemandeClient";
	 }
	
	
	
	@RequestMapping("/login")
	 public String login() {
	  return "login";
	 }

}


