package com.joeldavg.quarkus.controller.user;

import com.joeldavg.quarkus.domain.user.model.User;
import com.joeldavg.quarkus.service.user.ListUserService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Path(value = "user")
@Produces(value = MediaType.APPLICATION_JSON)
public class ListUserController {

    @Inject
    private ListUserService service;

    @GET
    @Path(value = "list-users")
    public Uni<List<User>> listUsers() {
        log.info("REQUEST -> listUsers");
        return this.service.listUsers();
    }

}
