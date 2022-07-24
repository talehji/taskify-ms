package com.pallas.task.repositories;

import com.pallas.task.entities.TaskAssign;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskAssignRepository extends CrudRepository<TaskAssign, Long> {
    Optional<TaskAssign> findAllByTask_IdAndIdUser(long idTask, long idUser);
}
