package controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.repository.UserRepository;
import models.User;

@Service
public class MongoUserService implements UserService{
	
	
	private final UserRepository daoUser;
	
	@Autowired
	public MongoUserService(UserRepository daoUser) {
		this.daoUser = daoUser;
	}

	@Override
	public User connexion(String login, String pass) {
		return daoUser.findOneByLoginAndPass(login, pass);
	}

	@Override
	public void inscription(User userTmp) {
		daoUser.save(userTmp);
	}

	@Override
	public User initialise(String token) {
		return daoUser.findOneByToken(token);
	}

	@Override
	public void majUser(User userTmp) {
		this.daoUser.save(userTmp);
		
	}
	
	

}
