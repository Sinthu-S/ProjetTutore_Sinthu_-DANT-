package controller.service;

import java.util.List;

import models.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.repository.TaskRepository;
import controller.repository.UserRepository;

@Service
public class MongoTaskService implements TaskService {
	
private final TaskRepository dao;
	
	@Autowired
	public MongoTaskService(TaskRepository dao) {
		this.dao = dao;
	}

	@Override
	public List<Task> taskParDev(String dev) {
		return this.dao.findByLoginDevloppeur(dev);
	}

}
