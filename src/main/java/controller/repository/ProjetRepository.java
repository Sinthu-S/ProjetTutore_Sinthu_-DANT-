package controller.repository;



import java.util.List;

import models.Projet;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends MongoRepository<Projet, String> {

	public Projet findByidClient(String idClient);
	//public List<Projet> findByLastName(String lastName);

}
