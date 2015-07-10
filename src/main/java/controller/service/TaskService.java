package controller.service;

import java.util.List;

import models.Task;

public interface TaskService {
	
	List<Task> taskParDev(String dev);

}
