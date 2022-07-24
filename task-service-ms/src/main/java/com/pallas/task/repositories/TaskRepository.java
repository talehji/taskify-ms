package com.pallas.task.repositories;

import com.pallas.task.entities.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAllByIdOrganisation(long idOrganisation);
}
