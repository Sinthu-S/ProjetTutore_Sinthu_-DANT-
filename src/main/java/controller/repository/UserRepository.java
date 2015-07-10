package controller.repository;

import java.util.List;

import models.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findOneByLoginAndPass(String login, String pass);
	public User findOneByToken(String token);
	public User findOneByLogin(String login);
	public List<User> findByTypeUser(String typeuser);
	public User findOneByNomAndPrenom(String nom, String prenom);


}
