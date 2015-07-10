package controller.controller;

import java.util.List;

import models.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controller.service.TaskService;
import controller.service.UserService;

@RestController
@RequestMapping("/task")
public class TaskController {
	TaskService service;


	@Autowired
	public TaskController(TaskService serviceUser) {
		super();
		this.service = serviceUser;
	}
	
	
	@RequestMapping(value="/all/{dev}/", method = RequestMethod.GET)
	List<Task> suppression( @PathVariable("dev") String dev){
		return this.service.taskParDev(dev);
	}

}
