package com.pallas.task.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Validated
public class RequestTaskDTO {

    @Min(value = 1, message = "idOrganisation must be have positive value")
    @NotNull(message = "idOrganisation must be have value")
    private long idOrganisation;
    @Size(min = 2, message = "Min 2 character")
    @Size(max = 20, message = "Max 20 character")
    @NotBlank(message = "Title cannot be null")
    private String title;
    @Size(min = 2, message = "Min 2 character")
    @Size(max = 200, message = "Max 200 character")
    @NotBlank(message = "Title cannot be null")
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime deadline;
    private List<Long> users = new ArrayList<>();

    public long getIdOrganisation() {
        return idOrganisation;
    }

    public RequestTaskDTO setIdOrganisation(long idOrganisation) {
        this.idOrganisation = idOrganisation;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RequestTaskDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RequestTaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public RequestTaskDTO setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
        return this;
    }

    public List<Long> getUsers() {
        return users;
    }

    public RequestTaskDTO setUsers(List<Long> users) {
        this.users = users;
        return this;
    }
}
