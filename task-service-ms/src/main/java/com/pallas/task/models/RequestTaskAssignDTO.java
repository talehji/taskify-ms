package com.pallas.task.models;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public class RequestTaskAssignDTO {

    @Min(value = 1, message = "id must be have positive value")
    @NotNull(message = "id must be have value")
    private long id;
    @Min(value = 1, message = "idUser must be have positive value")
    @NotNull(message = "idUser must be have value")
    private long idUser;

    public long getId() {
        return id;
    }

    public RequestTaskAssignDTO setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdUser() {
        return idUser;
    }

    public RequestTaskAssignDTO setIdUser(long idUser) {
        this.idUser = idUser;
        return this;
    }
}
