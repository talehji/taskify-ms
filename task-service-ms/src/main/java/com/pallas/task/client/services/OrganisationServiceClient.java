package com.pallas.task.client.services;

import com.pallas.task.client.models.OrganisationDTO;
import com.pallas.task.client.models.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "organisation-service")
public interface OrganisationServiceClient {

    @GetMapping(value = "/organisation/api/v1/organisation/get/my")
    OrganisationDTO getOrganisation(@RequestHeader String Authorization);

    @GetMapping(value = "/organisation/api/v1/authentication/get/me")
    UserDTO getMyUser(@RequestHeader String Authorization);
}
