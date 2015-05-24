package controller.repository;

import models.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findOneByLoginAndPass(String login, String pass);
	public User findOneByToken(String token);

}
