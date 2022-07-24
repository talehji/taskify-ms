package com.pallas.task.entities;

import javax.persistence.*;

@Entity
public class TaskAssign {

    @Id
    @GeneratedValue
    private long id;
    private long idUser;
    @ManyToOne
    @JoinColumn(name = "id_task", referencedColumnName = "id")
    private Task task;

    public TaskAssign() {
    }

    public long getId() {
        return id;
    }

    public TaskAssign setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdUser() {
        return idUser;
    }

    public TaskAssign setIdUser(long idUser) {
        this.idUser = idUser;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public TaskAssign setTask(Task task) {
        this.task = task;
        return this;
    }
}
