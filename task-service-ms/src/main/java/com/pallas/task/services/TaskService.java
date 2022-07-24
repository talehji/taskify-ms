package com.pallas.task.services;

import com.pallas.task.models.RequestTaskAssignDTO;
import com.pallas.task.models.RequestTaskDTO;
import com.pallas.task.models.RequestTaskStatusDTO;
import com.pallas.task.models.ResponseTaskDTO;

import java.util.List;

public interface TaskService {

    void add(RequestTaskDTO taskDTO);
    void assign(RequestTaskAssignDTO taskAssignDTO, String Authorization);
    void changeStatus(RequestTaskStatusDTO taskStatusDTO);
    List<ResponseTaskDTO> list(String Authorization);
}
