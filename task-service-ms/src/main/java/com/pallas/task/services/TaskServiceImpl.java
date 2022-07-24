package com.pallas.task.services;

import com.pallas.task.client.models.OrganisationDTO;
import com.pallas.task.client.models.UserDTO;
import com.pallas.task.client.services.OrganisationServiceClient;
import com.pallas.task.entities.Task;
import com.pallas.task.entities.TaskAssign;
import com.pallas.task.exceptions.AlreadyExistException;
import com.pallas.task.exceptions.NotFoundException;
import com.pallas.task.models.RequestTaskAssignDTO;
import com.pallas.task.models.RequestTaskDTO;
import com.pallas.task.models.RequestTaskStatusDTO;
import com.pallas.task.models.ResponseTaskDTO;
import com.pallas.task.repositories.TaskAssignRepository;
import com.pallas.task.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskAssignRepository taskAssignRepository;
    private final OrganisationServiceClient organisationServiceClient;

    public TaskServiceImpl(TaskRepository taskRepository, TaskAssignRepository taskAssignRepository, OrganisationServiceClient organisationServiceClient) {
        this.taskRepository = taskRepository;
        this.taskAssignRepository = taskAssignRepository;
        this.organisationServiceClient = organisationServiceClient;
    }


    @Override
    public void add(RequestTaskDTO taskDTO) {
        Task task = taskRepository.save(new Task()
                .setIdOrganisation(taskDTO.getIdOrganisation())
                .setTitle(taskDTO.getTitle())
                .setDescription(taskDTO.getDescription())
                .setDeadline(taskDTO.getDeadline())
                .setStatus(1) // New Task
        );
        taskDTO.getUsers().forEach(idUser -> taskAssignRepository.save(new TaskAssign()
                .setTask(task)
                .setIdUser(idUser)
        ));
    }

    @Override
    public void assign(RequestTaskAssignDTO taskAssignDTO, String Authorization) {
        UserDTO user = organisationServiceClient.getMyUser(Authorization);
        if (taskAssignRepository.findAllByTask_IdAndIdUser(taskAssignDTO.getId(), user.getId()).isPresent()) {
            throw new AlreadyExistException("This task already assign to you");
        }
        Optional<Task> task = taskRepository.findById(taskAssignDTO.getId());
        task.ifPresent(value -> taskAssignRepository.save(new TaskAssign()
                .setTask(value)
                .setIdUser(user.getId())
        ));
    }

    @Override
    public void changeStatus(RequestTaskStatusDTO taskStatusDTO) {
        Optional<Task> task = taskRepository.findById(taskStatusDTO.getId());
        if (task.isPresent()) {
            taskRepository.save(task.get().setStatus(taskStatusDTO.getStatus()));
        }else{
            throw new NotFoundException("Data not found");
        }
    }

    @Override
    public List<ResponseTaskDTO> list(String Authorization) {
        OrganisationDTO organisation = organisationServiceClient.getOrganisation(Authorization);
        if (organisation != null) {
            List<Task> tasks = taskRepository.findAllByIdOrganisation(organisation.getId());
            return tasks.stream()
                    .map(task -> new ResponseTaskDTO()
                            .setId(task.getId())
                            .setTitle(task.getTitle())
                            .setDeadline(task.getDeadline())
                            .setDescription(task.getDescription())
                            .setStatus(task.getStatus()))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}
