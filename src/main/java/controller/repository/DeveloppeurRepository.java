package controller.repository;

import java.util.List;

import models.Developpeur;
import models.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloppeurRepository extends MongoRepository<Developpeur, String> {
	
	public List<Developpeur> findByLoginmanager(String loginManager);

}
