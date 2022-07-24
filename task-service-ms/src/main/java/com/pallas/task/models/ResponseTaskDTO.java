package com.pallas.task.models;

import java.time.LocalDateTime;

public class ResponseTaskDTO {

    private long id;
    private long idOrganisation;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private int status;

    public long getId() {
        return id;
    }

    public ResponseTaskDTO setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdOrganisation() {
        return idOrganisation;
    }

    public ResponseTaskDTO setIdOrganisation(long idOrganisation) {
        this.idOrganisation = idOrganisation;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ResponseTaskDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ResponseTaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public ResponseTaskDTO setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ResponseTaskDTO setStatus(int status) {
        this.status = status;
        return this;
    }
}
