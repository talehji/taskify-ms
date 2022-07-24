package com.pallas.task.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private long id;
    private long idOrganisation;
    private String title;
    private String description;
    private LocalDateTime deadline;
    /**
     * Normally store this values in database or enum
     * 1 - new
     * 2 - in progress
     * 3 - done
     */
    private int status;
    @OneToMany(mappedBy = "task")
    private List<TaskAssign> taskAssigns = new ArrayList<>();

    public Task() {
    }

    public long getId() {
        return id;
    }

    public Task setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdOrganisation() {
        return idOrganisation;
    }

    public Task setIdOrganisation(long idOrganisation) {
        this.idOrganisation = idOrganisation;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public Task setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Task setStatus(int status) {
        this.status = status;
        return this;
    }

    public List<TaskAssign> getTaskAssigns() {
        return taskAssigns;
    }

    public Task setTaskAssigns(List<TaskAssign> taskAssigns) {
        this.taskAssigns = taskAssigns;
        return this;
    }
}
