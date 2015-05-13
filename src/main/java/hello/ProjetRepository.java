package hello;



import java.util.List;

import model.Projet;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjetRepository extends MongoRepository<Projet, String> {
	
	//public Projet findByFirstName(String firstName);
   // public List<Projet> findByLastName(String lastName);

}
