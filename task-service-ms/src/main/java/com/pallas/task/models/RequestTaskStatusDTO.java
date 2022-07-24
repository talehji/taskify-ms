package com.pallas.task.models;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public class RequestTaskStatusDTO {

    @Min(value = 1, message = "id must be have positive value")
    @NotNull(message = "id must be have value")
    private long id;
    @NotNull(message = "status must be have value")
    @Min(value = 1, message = "status can be 1, 2, 3")
    @Max(value = 3, message = "status can be 1, 2, 3")
    private int status;

    public long getId() {
        return id;
    }

    public RequestTaskStatusDTO setId(long id) {
        this.id = id;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public RequestTaskStatusDTO setStatus(int status) {
        this.status = status;
        return this;
    }
}
