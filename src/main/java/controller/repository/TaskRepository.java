package controller.repository;

import java.util.List;

import models.Task;
import models.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{

	List<Task> findByLoginDevloppeur(String login);
}
