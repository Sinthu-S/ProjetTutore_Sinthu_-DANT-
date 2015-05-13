package hello;

import model.Projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tasks")
public class HomeController {

	//private final ProjetService service;

	/*@Autowired
	HomeController(ProjetService service) {
		this.service = service;
	}
	*/
	@RequestMapping("/home")
	 public String home() {
	  return "index";
	 }
/*

	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	void save(@PathVariable("id") String id){  
		System.out.println("Controller");
		Projet p=new Projet(id);
		service.save(p);

	}
*/

}
