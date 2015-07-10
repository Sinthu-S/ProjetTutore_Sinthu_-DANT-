package controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.repository.DeveloppeurRepository;
import controller.repository.UserRepository;
import models.Developpeur;
import models.User;

@Service
public class MongoDeveloppeurService implements DeveloppeurService{

private final DeveloppeurRepository daoUser;
	
	@Autowired
	public MongoDeveloppeurService(DeveloppeurRepository daoUser) {
		this.daoUser = daoUser;
	}
	
	@Override
	public List<Developpeur> listDev(String loginManager) {
		return this.daoUser.findByLoginmanager(loginManager);
	}

	@Override
	public void ajoutDev(Developpeur dev) {
		// TODO Auto-generated method stub
		
	}
}
