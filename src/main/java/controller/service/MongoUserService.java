package controller.service;

import java.util.ArrayList;
import java.util.List;

import models.Message;
import models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.repository.UserRepository;

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
		userTmp.notifications.add(new Message("Admin", "Bienvenu sur ManagerAPP"));
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

	@Override
	public void deconnexion(String token) {
		User tmp = this.daoUser.findOneByToken(token);
		tmp.token=null;
		this.daoUser.save(tmp);
		
	}

	@Override
	public List<List<User>> getStat() {
		List stat=new ArrayList<String>();
		stat.add(this.daoUser.findByTypeUser("client"));
		stat.add(this.daoUser.findByTypeUser("manager"));
		stat.add(this.daoUser.findByTypeUser("developpeur"));
		return stat;
	}

	@Override
	public void modification(String login, String nom, String prenom, String service, String email) {
		User tmp=this.daoUser.findOneByLogin(login);
		tmp.setNom(nom);
		tmp.setPrenom(prenom);
		tmp.setService(service);
		tmp.setEmail(email);
		this.daoUser.save(tmp);
		
	}

	@Override
	public void suppression(String login) {
		this.daoUser.delete(login);
		
	}


	
	

}
