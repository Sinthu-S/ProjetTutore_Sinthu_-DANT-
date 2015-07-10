package controller.repository;



import java.util.List;

import models.Projet;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends MongoRepository<Projet, String> {

	public List<Projet> findByNomClient(String nomClient);
	public List<Projet> findByNomManager(String nomManager);
	public Projet findOneByNom(String nom);


}
