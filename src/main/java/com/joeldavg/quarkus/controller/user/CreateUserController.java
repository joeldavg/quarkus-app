package com.joeldavg.quarkus.controller.user;

import com.joeldavg.quarkus.domain.user.model.User;
import com.joeldavg.quarkus.service.user.CreateUserService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path(value = "user")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class CreateUserController {

    @Inject
    private CreateUserService service;

    @POST
    @Path(value = "create")
    public Uni<User> createUser(User user) {
        log.info("REQUEST -> createUser, Body -> user: " + user);
        return this.service.createUser(user);
    }

}
