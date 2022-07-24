package com.pallas.task.api;

import com.pallas.task.models.RequestTaskAssignDTO;
import com.pallas.task.models.RequestTaskDTO;
import com.pallas.task.models.RequestTaskStatusDTO;
import com.pallas.task.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/task/api/v1/task")
public class TaskApi {

    private final TaskService taskService;

    public TaskApi(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid RequestTaskDTO taskDTO){
        taskService.add(taskDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/assign")
    public ResponseEntity<?> assign(@RequestBody @Valid RequestTaskAssignDTO taskAssignDTO, @RequestHeader String Authorization){
        taskService.assign(taskAssignDTO, Authorization);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/changeStatus")
    public ResponseEntity<?> changeStatus(@RequestBody @Valid RequestTaskStatusDTO taskStatusDTO){
        taskService.changeStatus(taskStatusDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestHeader String Authorization){
        return ResponseEntity.ok().body(taskService.list(Authorization));
    }
}
